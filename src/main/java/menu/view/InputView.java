package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.coach.Coach;

public class InputView {

    private static final String DELIMITER = "\\s*,\\s*";

    public String[] askCoachNames() {
        System.out.printf("%n코치의 이름을 입력해 주세요. (, 로 구분)%n");
        return Console.readLine().split(DELIMITER);
    }

    public String[] askDislikedMenusByCoach(Coach coach) {
        System.out.printf("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach.getName());
        return Console.readLine().split(DELIMITER);
    }
}
