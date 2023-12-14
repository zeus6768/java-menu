package menu.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.coach.Coach;

public class InputView {

    public List<String> askCoachNames() {
        System.out.printf("%n코치의 이름을 입력해 주세요. (, 로 구분)%n");
        return split(Console.readLine());
    }

    public List<String> askDislikedMenusByCoach(Coach coach) {
        System.out.printf("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach.getName());
        return split(Console.readLine());
    }

    private List<String> split(String input) {
        return List.of(input.trim().split("\\s*,\\s*"));
    }
}
