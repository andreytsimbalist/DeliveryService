package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.BookingController;
import eu.exposit.DeliveryService.controllers.ClientController;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.controllers.ShopController;
import eu.exposit.DeliveryService.exceptions.NoRegisteredClientsException;
import eu.exposit.DeliveryService.exceptions.NotEnoughProductException;
import eu.exposit.DeliveryService.model.*;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBookingAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        ClientController clientController = ClientController.getInstance();
        ProductController productController = ProductController.getInstance();
        ShopController shopController = ShopController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();

        Booking booking = new Booking();

        if (clientController.getAll().isEmpty()) {
            throw new NoRegisteredClientsException();
        }

        int choice;
        System.out.println("\nВыберите номер с вашими данными");
        for (int i = 0; i < clientController.getAll().size(); i++) {
            System.out.println((i + 1) + ". " + clientController.getAll().get(i));
        }
        System.out.print("Ваш выбор: ");
        choice = scanner.nextInt();
        booking.setClient(new Client(clientController.getAll().get(choice - 1)));

        while (true) {

            for (int i = 0; i < productController.getAll().size(); i++) {
                System.out.println("\n" + (i + 1) + productController.getAll().get(i));
            }

            System.out.print("\n" + (productController.getAll().size() + 1) + " Завершить\nВаш выбор: ");
            choice = scanner.nextInt();
            if (choice == productController.getAll().size() + 1){
                break;
            }
            Product product = new Product(productController.getAll().get(choice - 1));

            List<Shop> shops = new ArrayList<>();

            for (Shop shop : shopController.getAll()) {
                for (Stock stock : shop.getStocks()) {
                    if (stock.getProduct().equals(product)){
                        shops.add(shop);
                        break;
                    }
                }
            }

            for (int i = 0; i < shops.size(); i++) {
                System.out.println("\n" + (i + 1) + shops.get(i));
            }
            System.out.print("\nВаш выбор: ");
            choice = scanner.nextInt();
            Shop shop = new Shop(shops.get(choice - 1));
            Stock temp = shopController.getAll().get(shopController.getAll().indexOf(shop)).getStocks()
                    .stream()
                    .filter(entity -> entity.getProduct().equals(product)).findFirst().get();
            shop.getStocks().add(new Stock(temp));

            System.out.print("\nКоличество товара: ");
            int count = scanner.nextInt();
            if (count > temp.getCount()){
                throw new NotEnoughProductException();
            }
            temp.setCount(temp.getCount() - count);
            shop.getStocks().get(0).setCount(count);
            booking.getShops().add(shop);
        }

        for (Shop shop : booking.getShops()) {
            for (Stock stock : shop.getStocks()) {
                booking.setTotal(booking.getTotal() + stock.getPrice() * stock.getCount());
            }
        }

        if (!booking.getShops().isEmpty()) {
            BookingController.getInstance().create(booking);
        }

    }

}
