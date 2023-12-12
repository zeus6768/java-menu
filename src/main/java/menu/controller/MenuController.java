package menu.controller;

import java.util.List;
import java.util.Map;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.constant.DayOfWeek;
import menu.domain.menu.Category;
import menu.domain.menu.Menu;
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
        Coaches coaches = inputView.askCoachNames();
        askAndSetDislikedMenus(coaches);
        Map<DayOfWeek, Category> recommendedCategories = recommendCategories();
    }

    private void askAndSetDislikedMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<Menu> dislikedMenus = inputView.askDislikedMenusByCoach(coach);
            coach.putDislikedMenus(dislikedMenus);
        }
    }

    private Map<DayOfWeek, Category> recommendCategories() {
        return menuService.recommendCategories();
    }
}
