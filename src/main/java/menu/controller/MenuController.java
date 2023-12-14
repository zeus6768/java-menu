package menu.controller;

import menu.domain.coach.Coaches;
import menu.domain.result.RecommendResult;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        outputView.printStartMessage();
        Coaches coaches = createCoaches();
        putDislikedMenus(coaches);
        RecommendResult result = recommendMenus(coaches);
        outputView.printResult(result);
    }

    private Coaches createCoaches() {
        return menuService.createCoaches(inputView::askCoachNames);
    }

    private void putDislikedMenus(Coaches coaches) {
        menuService.putDislikedMenus(coaches, inputView::askDislikedMenusByCoach);
    }

    private RecommendResult recommendMenus(Coaches coaches) {
        return menuService.recommendMenus(coaches);
    }
}
