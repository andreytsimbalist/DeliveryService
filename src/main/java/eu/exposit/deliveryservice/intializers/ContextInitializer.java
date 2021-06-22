package eu.exposit.deliveryservice.intializers;

import eu.exposit.deliveryservice.utils.SerializationUtil;

public class ContextInitializer {

    private ContextInitializer() {

    }

    public static void initContext() {
        SerializationUtil.deserialization();
    }

}
