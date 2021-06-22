package eu.exposit.DeliveryService.actions.menu;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.menu.MenuContext;

public class ToSubmenuAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        MenuContext.setCurrentMenu(MenuContext.getCurrentMenu().getItems().get(index).getSubmenu());
    }

}
