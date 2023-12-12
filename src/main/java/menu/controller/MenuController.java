package menu.controller;

import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView;

    public MenuController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
    }
}
