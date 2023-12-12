package menu;

import menu.config.MenuConfig;
import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuConfig config = MenuConfig.getInstance();
        MenuController controller = config.menuController();
        controller.run();
    }
}
