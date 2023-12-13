package menu.controller;

import menu.domain.coach.Coach;
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
        askAndPutDislikedMenus(coaches);
        RecommendResult result = recommend(coaches);
        outputView.printResult(result);
    }

    private Coaches createCoaches() {
        String[] coachNames = inputView.askCoachNames();
        return menuService.createCoaches(coachNames);
    }

    private void askAndPutDislikedMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            String[] dislikedMenus = inputView.askDislikedMenusByCoach(coach);
            coach.putDislikedMenus(dislikedMenus);
        }
    }

    private RecommendResult recommend(Coaches coaches) {
        return menuService.recommend(coaches);
    }
}
