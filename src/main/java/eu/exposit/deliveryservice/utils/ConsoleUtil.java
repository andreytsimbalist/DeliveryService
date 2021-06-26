package eu.exposit.deliveryservice.utils;

import lombok.Getter;

import java.util.Scanner;

public class ConsoleUtil {

    private ConsoleUtil() {

    }

    @Getter
    private static final Scanner scanner = new Scanner(System.in);

}
