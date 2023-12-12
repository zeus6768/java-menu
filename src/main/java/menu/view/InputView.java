package menu.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.Menu;
import menu.domain.menu.Menus;

public class InputView {

    private static final String DELIMITER = ",";

    private final Menus menus;

    public InputView(Menus menus) {
        this.menus = menus;
    }

    public Coaches askCoachNames() {
        System.out.printf("%n코치의 이름을 입력해 주세요. (, 로 구분)%n");
        String[] coachNames = Console.readLine().split(DELIMITER);
        List<Coach> coaches = Arrays.stream(coachNames).map(Coach::from).toList();
        return Coaches.from(coaches);
    }

    public List<Menu> askDislikedMenusByCoach(Coach coach) {
        System.out.printf("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach.getName());
        String[] dislikedMenuNames = Console.readLine().split(DELIMITER);
        return Arrays.stream(dislikedMenuNames).map(menus::find).toList();
    }
}
