package menu.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Coach;
import menu.model.Coaches;

public class InputView {

    private static final String DELIMITER = ",";

    public Coaches askCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String[] coachNames = Console.readLine().split(DELIMITER);
        List<Coach> coaches = Arrays.stream(coachNames).map(Coach::from).toList();
        return Coaches.from(coaches);
    }
}
