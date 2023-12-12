package menu;

import menu.config.MenuConfig;
import menu.controller.MenuController;
import menu.domain.menu.Menus;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuConfig config = MenuConfig.getInstance();
        MenuController controller = config.menuController();
        controller.run();
    }
}
