package eu.exposit.deliveryservice.actions.menu;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.menu.MenuContext;

public class ToSubmenuAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        MenuContext.setCurrentMenu(MenuContext.getCurrentMenu().getItems().get(index).getSubmenu());
    }

}
