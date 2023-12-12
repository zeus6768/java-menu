package menu.controller;

import java.util.List;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        Coaches coaches = inputView.askCoachNames();
        askAndSetDislikedMenus(coaches);
    }

    private void askAndSetDislikedMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<Menu> dislikedMenus = inputView.askDislikedMenusByCoach(coach);
            coach.addDislikedMenus(dislikedMenus);
        }
    }
}
