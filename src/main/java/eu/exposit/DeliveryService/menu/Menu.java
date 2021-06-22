package eu.exposit.DeliveryService.menu;


import eu.exposit.DeliveryService.utils.ConsoleUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.List;

@Getter
@Setter
public class Menu {

    private List<MenuItem> items;
    private Menu previousMenu;

    public void executeSelectedFunction() {
        try {
            int index = ConsoleUtil.getScanner().nextInt() - 1;
            try {
                items.get(index).getAction().execute(index);
            } catch (IndexOutOfBoundsException exception){
                System.out.println("\nТакого пункта нет.");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } catch (InputMismatchException exception) {
            ConsoleUtil.getScanner().nextLine();
            System.out.println("\nОшибка формата ввода.");
        }
    }

}
