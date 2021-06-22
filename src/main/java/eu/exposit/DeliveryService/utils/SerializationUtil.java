package eu.exposit.DeliveryService.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.exposit.DeliveryService.DataStorage.BookingDatabase;
import eu.exposit.DeliveryService.DataStorage.ClientDatabase;
import eu.exposit.DeliveryService.DataStorage.ProductDatabase;
import eu.exposit.DeliveryService.DataStorage.ShopDatabase;
import eu.exposit.DeliveryService.model.Client;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.model.Stock;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

    private static final Gson gson = new Gson();
    private static final String clientPath = "eu/exposit/DeliveryService/save/ClientDatabase.json";
    private static final String shopPath = "eu/exposit/DeliveryService/save/ShopDatabase.json";
    private static final String productPath = "eu/exposit/DeliveryService/save/ProductDatabase.json";
    private static final String bookingPath = "eu/exposit/DeliveryService/save/BookingDatabase.json";

    public static void deserialization() {

        ClientDatabase clientDatabase = ClientDatabase.getInstance();
        clientDatabase.setEntities(getFromJson(clientPath, new TypeToken<List<Client>>() {
        }.getType()));
        clientDatabase.setIdSequence((long) clientDatabase.getEntities().size());

        ProductDatabase productDatabase = ProductDatabase.getInstance();
        productDatabase.setEntities(getFromJson(productPath, new TypeToken<List<Product>>() {
        }.getType()));
        productDatabase.setIdSequence((long) productDatabase.getEntities().size());

        ShopDatabase shopDatabase = ShopDatabase.getInstance();
        shopDatabase.setEntities(getFromJson(shopPath, new TypeToken<List<Shop>>() {
        }.getType()));
        shopDatabase.setIdSequence((long) shopDatabase.getEntities().size());

        BookingDatabase bookingDatabase = BookingDatabase.getInstance();
        bookingDatabase.setEntities(getFromJson(bookingPath, new TypeToken<List<Shop>>() {
        }.getType()));
        bookingDatabase.setIdSequence((long) bookingDatabase.getEntities().size());

        for (Product product : productDatabase.getEntities()) {
            for (Shop shop : shopDatabase.getEntities()) {
                for (Stock stock : shop.getStocks()) {
                    if (stock.getProduct().equals(product)) {
                        stock.setProduct(product);
                    }
                }
            }
        }

    }

    private static List getFromJson(String path, Type type) {
        try {
            FileReader fileReader = new FileReader(path);
            List entities = gson.fromJson(fileReader, type);
            return entities == null ? new ArrayList<>() : entities;
        } catch (IOException ioException) {
            try {
                File file = new File(path);
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("\nПуть не найден.");
            }
        }
        return new ArrayList<>();
    }

    public static void serialization() {

        writeToJson(clientPath, ClientDatabase.getInstance().getEntities());
        writeToJson(productPath, ProductDatabase.getInstance().getEntities());
        writeToJson(shopPath, ShopDatabase.getInstance().getEntities());
        writeToJson(bookingPath, BookingDatabase.getInstance().getEntities());

    }

    private static void writeToJson(String path, List entities) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            try {
                fileWriter.write(gson.toJson(entities));
            } catch (IOException exception) {
                throw new IOException();
            } finally {
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException exception) {
            System.out.println("\nОшибка работы с файлом.");
        }
    }

}
