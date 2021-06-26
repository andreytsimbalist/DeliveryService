package eu.exposit.deliveryservice.menu;

import lombok.Getter;
import lombok.Setter;

public class MenuContext {

    private MenuContext() {

    }

    @Getter
    @Setter
    private static Menu currentMenu;

}
