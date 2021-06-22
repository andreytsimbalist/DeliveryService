package eu.exposit.DeliveryService;

import eu.exposit.DeliveryService.intializers.MainInitializer;
import eu.exposit.DeliveryService.main.UserInterface;

public class Runner {

    public static void main(String[] args) {
        MainInitializer.init();
        UserInterface.run();
    }

}
