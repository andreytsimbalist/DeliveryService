package eu.exposit.deliveryservice.actions.menu;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.menu.Menu;
import eu.exposit.deliveryservice.menu.MenuContext;
import eu.exposit.deliveryservice.utils.SerializationUtil;

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
