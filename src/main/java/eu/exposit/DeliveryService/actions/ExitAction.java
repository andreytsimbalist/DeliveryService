package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.menu.Menu;
import eu.exposit.DeliveryService.menu.MenuContext;
import eu.exposit.DeliveryService.utils.SerializationUtil;

public class ExitAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        SerializationUtil.serialization();

        Menu menu = MenuContext.getCurrentMenu().getPreviousMenu();
        if (menu == null) {
            System.exit(0);
        } else {
            MenuContext.setCurrentMenu(menu);
        }

    }

}
