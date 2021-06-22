package eu.exposit.deliveryservice;

import eu.exposit.deliveryservice.intializers.MainInitializer;
import eu.exposit.deliveryservice.main.UserInterface;

public class Runner {

    public static void main(String[] args) {
        MainInitializer.init();
        UserInterface.run();
    }

}
