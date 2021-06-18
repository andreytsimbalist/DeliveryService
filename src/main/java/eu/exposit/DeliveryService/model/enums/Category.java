package eu.exposit.DeliveryService.model.enums;

import lombok.Getter;

public enum Category {

    CHILD("Товары для детей"),
    HOUSING("Все для дома"),
    APPEARANCE("Красота и здоровье"),
    APPLIANCE("Бытовая техника"),
    COMPUTERS("Компьютеры"),
    SPORT("Спортивные товары"),
    ALIVE("Животные и растения"),
    FURNITURE("Мебель"),
    OFFICE("Все для оффиса"),
    BUILDING("Строительство и ремонт"),
    TELEPHONES("Телефоны"),
    TRANSPORT("Авто и мото"),
    ELECTRONICS("Электроника и фото"),
    PRESENTS("Подарки, сувениры, цветы"),
    BOOKS("Книги"),
    PHARMACY("Аптека"),
    GARDEN("Все для сада и дачи"),
    FOOD("Продукты, напитки, табак"),
    MEDIAINFO("Музыка и видеофильмы");

    @Getter
    private final String description;

    Category(String description) {
        this.description = description;
    }
}
