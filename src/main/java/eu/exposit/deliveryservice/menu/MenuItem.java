package eu.exposit.deliveryservice.menu;

import eu.exposit.deliveryservice.api.actions.Action;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {

    private String text;
    private Action action;
    private Menu submenu;

    public MenuItem(String text, Action action) {
        this.text = text;
        this.action = action;
    }
}
