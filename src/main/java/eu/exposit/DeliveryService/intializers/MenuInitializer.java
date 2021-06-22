package eu.exposit.DeliveryService.intializers;

import eu.exposit.DeliveryService.actions.*;
import eu.exposit.DeliveryService.menu.Menu;
import eu.exposit.DeliveryService.menu.MenuContext;
import eu.exposit.DeliveryService.menu.MenuItem;

import java.util.ArrayList;

public class MenuInitializer {

    private MenuInitializer() {

    }

    public static void initMenuContext() {
        initRootMenu();
    }

    private static void initRootMenu() {
        MenuContext.setCurrentMenu(new Menu());
        MenuContext.getCurrentMenu().setItems(new ArrayList<>());

        MenuItem clientMenu = new MenuItem(" Работа с клиентами", new ToSubmenuAction(),
                initClientMenu(MenuContext.getCurrentMenu()));
        MenuItem productMenu = new MenuItem(" Работа с продуктами", new ToSubmenuAction(),
                initProductMenu(MenuContext.getCurrentMenu()));
        MenuItem shopMenu = new MenuItem(" Работа с магазинами", new ToSubmenuAction(),
                initShopMenu(MenuContext.getCurrentMenu()));
        MenuItem bookingMenu = new MenuItem(" Работа с заказами", new ToSubmenuAction(),
                initBookingMenu(MenuContext.getCurrentMenu()));
        MenuItem exit = new MenuItem(" Выйти", new ExitAction());

        MenuContext.getCurrentMenu().getItems().add(clientMenu);
        MenuContext.getCurrentMenu().getItems().add(productMenu);
        MenuContext.getCurrentMenu().getItems().add(shopMenu);
        MenuContext.getCurrentMenu().getItems().add(bookingMenu);
        MenuContext.getCurrentMenu().getItems().add(exit);
    }

    private static Menu initClientMenu(Menu previousMenu) {
        Menu clientMenu = new Menu();
        clientMenu.setItems(new ArrayList<>());

        MenuItem register = new MenuItem(" Регистрация", new RegisterClientAction());
        MenuItem update = new MenuItem(" Редактировать", new UpdateClientAction());
        MenuItem delete = new MenuItem(" Удалить", new DeleteClientAction());
        MenuItem display = new MenuItem(" Вывести", new DisplayClientsAction());
        MenuItem exit = new MenuItem(" Выйти", new ExitAction());

        clientMenu.getItems().add(register);
        clientMenu.getItems().add(update);
        clientMenu.getItems().add(delete);
        clientMenu.getItems().add(display);
        clientMenu.getItems().add(exit);

        clientMenu.setPreviousMenu(previousMenu);

        return clientMenu;
    }

    private static Menu initProductMenu(Menu previousMenu) {
        Menu productMenu = new Menu();
        productMenu.setItems(new ArrayList<>());

        MenuItem create = new MenuItem(" Создать", new CreateProductAction());
        MenuItem update = new MenuItem(" Редактировать", new UpdateProductAction());
        MenuItem delete = new MenuItem(" Удалить", new DeleteProductAction());
        MenuItem searchByCategory = new MenuItem(" Найти товары в заданных категориях",
                new SearchProductByCategoryAction());
        MenuItem searchByAttribute = new MenuItem(" Найти товары по атрибутам",
                new SearchProductByAttributesAction());
        MenuItem sortByPrice = new MenuItem(" Сортировка товаров по цене",
                new SortProductsByPriceAction());
        MenuItem display = new MenuItem(" Вывести", new DisplayProductsAction());
        MenuItem exit = new MenuItem(" Выйти", new ExitAction());

        productMenu.getItems().add(create);
        productMenu.getItems().add(update);
        productMenu.getItems().add(delete);
        productMenu.getItems().add(searchByCategory);
        productMenu.getItems().add(searchByAttribute);
        productMenu.getItems().add(sortByPrice);
        productMenu.getItems().add(display);
        productMenu.getItems().add(exit);

        productMenu.setPreviousMenu(previousMenu);

        return productMenu;

    }

    private static Menu initShopMenu(Menu previousMenu) {
        Menu shopMenu = new Menu();
        shopMenu.setItems(new ArrayList<>());

        MenuItem register = new MenuItem(" Создать", new RegisterShopAction());
        MenuItem update = new MenuItem(" Редактировать", new UpdateShopAction());
        MenuItem delete = new MenuItem(" Удалить", new DeleteShopAction());
        MenuItem addProduct = new MenuItem(" Добавить продукт", new AddProductToShopAction());
        MenuItem updateStock = new MenuItem(" Изменение информации о товаре", new UpdateStockAction());
        MenuItem display = new MenuItem(" Вывести", new DisplayShopsAction());
        MenuItem exit = new MenuItem(" Выйти", new ExitAction());

        shopMenu.getItems().add(register);
        shopMenu.getItems().add(update);
        shopMenu.getItems().add(delete);
        shopMenu.getItems().add(addProduct);
        shopMenu.getItems().add(updateStock);
        shopMenu.getItems().add(display);
        shopMenu.getItems().add(exit);

        shopMenu.setPreviousMenu(previousMenu);

        return shopMenu;

    }

    private static Menu initBookingMenu(Menu previousMenu) {
        Menu bookingMenu = new Menu();
        bookingMenu.setItems(new ArrayList<>());

        MenuItem create = new MenuItem(" Создать", new CreateBookingAction());
        MenuItem display = new MenuItem(" Вывести", new DisplayBookingsAction());
        MenuItem exit = new MenuItem(" Выйти", new ExitAction());

        bookingMenu.getItems().add(create);
        bookingMenu.getItems().add(display);
        bookingMenu.getItems().add(exit);

        bookingMenu.setPreviousMenu(previousMenu);

        return bookingMenu;

    }



}
