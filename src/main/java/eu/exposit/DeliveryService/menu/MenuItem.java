package eu.exposit.DeliveryService.menu;

import eu.exposit.DeliveryService.api.actions.Action;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {

    private String text;
    private Action action;
    private Menu submenu;

    public MenuItem(String text, Action action, Menu submenu) {
        this.text = text;
        this.action = action;
        this.submenu = submenu;
    }

    public MenuItem(String text, Action action) {
        this.text = text;
        this.action = action;
    }
}
