package eu.exposit.deliveryservice.intializers;

public class MainInitializer {

    private MainInitializer() {

    }

    public static void init() {
        MenuInitializer.initMenuContext();
        ContextInitializer.initContext();
    }

}
