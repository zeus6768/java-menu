package menu;

import menu.controller.MenuController;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController(
                new OutputView()
        );
        menuController.run();
    }
}
