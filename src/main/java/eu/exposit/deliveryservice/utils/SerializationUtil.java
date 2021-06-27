package eu.exposit.deliveryservice.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.exposit.deliveryservice.datastorage.BookingDatabase;
import eu.exposit.deliveryservice.datastorage.ClientDatabase;
import eu.exposit.deliveryservice.datastorage.ProductDatabase;
import eu.exposit.deliveryservice.datastorage.ShopDatabase;
import eu.exposit.deliveryservice.model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

    private SerializationUtil() {

    }

    private static final Gson gson = new Gson();
    private static final String clientPath = "src/main/java/eu/exposit/DeliveryService/save/ClientDatabase.json";
    private static final String shopPath = "src/main/java/eu/exposit/DeliveryService/save/ShopDatabase.json";
    private static final String productPath = "src/main/java/eu/exposit/DeliveryService/save/ProductDatabase.json";
    private static final String bookingPath = "src/main/java/eu/exposit/DeliveryService/save/BookingDatabase.json";

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

        for (Product product : productDatabase.getEntities()) {
            for (Shop shop : shopDatabase.getEntities()) {
                for (Stock stock : shop.getStocks()) {
                    if (stock.getProduct().equals(product)) {
                        stock.setProduct(product);
                    }
                }
            }
        }

        BookingDatabase bookingDatabase = BookingDatabase.getInstance();
        bookingDatabase.setEntities(getFromJson(bookingPath, new TypeToken<List<Shop>>() {
        }.getType()));
        bookingDatabase.setIdSequence((long) bookingDatabase.getEntities().size());


    }

    private static <T extends BaseEntity> List<T> getFromJson(String path, Type type) {
        try {
            File file = new File(path);
            List<T> entities = null;
            if (!file.createNewFile()) {
                FileReader fileReader = new FileReader(path);
                entities = gson.fromJson(fileReader, type);
                fileReader.close();
            }
            return entities == null ? new ArrayList<>() : entities;
        } catch (IOException ioException) {
            System.out.println("\nПуть не найден.");
        }
        return new ArrayList<>();
    }

    public static void serialization() {

        writeToJson(clientPath, ClientDatabase.getInstance().getEntities());
        writeToJson(productPath, ProductDatabase.getInstance().getEntities());
        writeToJson(shopPath, ShopDatabase.getInstance().getEntities());
        writeToJson(bookingPath, BookingDatabase.getInstance().getEntities());

    }

    private static <T extends BaseEntity> void writeToJson(String path, List<T> entities) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(gson.toJson(entities));
        } catch (Exception e) {
            System.out.println("\nОшибка работы с файлом: " + e.getMessage());
        }
    }

}
