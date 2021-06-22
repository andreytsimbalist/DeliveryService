package eu.exposit.DeliveryService.intializers;

import eu.exposit.DeliveryService.utils.SerializationUtil;

public class ContextInitializer {

    private ContextInitializer() {

    }

    public static void initContext() {
        SerializationUtil.deserialization();
    }

}
