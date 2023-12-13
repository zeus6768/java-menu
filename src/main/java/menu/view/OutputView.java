package menu.view;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

import menu.domain.coach.Coach;
import menu.domain.constant.Category;
import menu.domain.constant.DayOfWeek;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(Map<DayOfWeek, Category> categoryRecommendations,
                            Map<Coach, Map<DayOfWeek, String>> menuRecommendations) {
        printCategories(categoryRecommendations);
        printMenusByCoach(menuRecommendations);
    }

    public void printCategories(Map<DayOfWeek, Category> categoryRecommendations) {
        StringJoiner dayOfWeekStringJoiner = getResultStringJoiner("구분");
        StringJoiner categoryStringJoiner = getResultStringJoiner("카테고리");
        categoryRecommendations.forEach((dayOfWeek, category) -> {
            dayOfWeekStringJoiner.add(dayOfWeek.getName());
            categoryStringJoiner.add(category.getName());
        });
        System.out.println(dayOfWeekStringJoiner);
        System.out.println(categoryStringJoiner);
    }

    public void printMenusByCoach(Map<Coach, Map<DayOfWeek, String>> menusByCoach) {
        menusByCoach.forEach((coach, menus) -> {
            StringJoiner stringJoiner = getResultStringJoiner(coach.getName());
            menus.values().forEach(stringJoiner::add);
            System.out.println(stringJoiner);
        });
    }

    private StringJoiner getResultStringJoiner(String prefix) {
        return new StringJoiner(" | ", "[ " + prefix + " | ", " ]");
    }
}
