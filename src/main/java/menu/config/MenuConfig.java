package menu.config;

import menu.controller.MenuController;
import menu.exception.ExceptionHandler;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuConfig {

    private static MenuConfig menuConfig;

    private MenuController menuController;
    private MenuService menuService;
    private InputView inputView;
    private OutputView outputView;
    private ExceptionHandler exceptionHandler;

    private MenuConfig() {}

    public static MenuConfig getInstance() {
        if (menuConfig == null) {
            menuConfig = new MenuConfig();
        }
        return menuConfig;
    }

    public MenuController menuController() {
        if (menuController == null) {
            menuController = new MenuController(
                    inputView(),
                    outputView(),
                    menuService()
            );
        }
        return menuController;
    }

    public MenuService menuService() {
        if (menuService == null) {
            menuService = new MenuService(exceptionHandler());
        }
        return menuService;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public ExceptionHandler exceptionHandler() {
        if (exceptionHandler == null) {
            exceptionHandler = new ExceptionHandler();
        }
        return exceptionHandler;
    }
}
