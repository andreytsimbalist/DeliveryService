package eu.exposit.DeliveryService.intializers;

public class MainInitializer {

    private MainInitializer() {

    }

    public static void init() {
        MenuInitializer.initMenuContext();
        ContextInitializer.initContext();
    }

}
