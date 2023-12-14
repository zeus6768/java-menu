package menu.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.coach.DislikedMenus;
import menu.domain.constant.Category;
import menu.domain.constant.DayOfWeek;
import menu.domain.result.RecommendResult;
import menu.exception.ExceptionHandler;

public class MenuService {

    private final ExceptionHandler exceptionHandler;

    public MenuService(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public Coaches createCoaches(Supplier<List<String>> coachNamesInput) {
        return exceptionHandler.handle(() -> {
            List<String> coachNames = coachNamesInput.get();
            System.out.println(coachNames);
            List<Coach> coaches = coachNames.stream().map(Coach::from).toList();
            return Coaches.from(coaches);
        });

    }

    public void putDislikedMenus(Coaches coaches, Function<Coach, List<String>> dislikedMenusInput) {
        for (Coach coach : coaches.getCoaches()) {
            exceptionHandler.handle(() -> {
                List<String> dislikedMenuNames = dislikedMenusInput.apply(coach);
                DislikedMenus dislikedMenus = DislikedMenus.from(dislikedMenuNames);
                coach.putDislikedMenus(dislikedMenus);
                return null;
            });
        }
    }

    public RecommendResult recommendMenus(Coaches coaches) {
        Map<DayOfWeek, Category> recommendCategories = recommendCategories();
        Map<Coach, Map<DayOfWeek, String>> recommendMenus = recommendMenus(coaches, recommendCategories);
        return new RecommendResult(recommendCategories, recommendMenus);
    }

    private Map<DayOfWeek, Category> recommendCategories() {
        Map<DayOfWeek, Category> recommendations = new LinkedHashMap<>();
        Arrays.stream(DayOfWeek.values()).forEach(dayOfWeek -> {
            Category category = getValidCategory(recommendations.values());
            recommendations.put(dayOfWeek, category);
        });
        return recommendations;
    }

    private Map<Coach, Map<DayOfWeek, String>> recommendMenus(Coaches coaches,
                                                              Map<DayOfWeek, Category> recommendCategories) {
        Map<Coach, Map<DayOfWeek, String>> recommendations = new LinkedHashMap<>();
        recommendCategories.forEach((dayOfWeek, category) ->
                coaches.getCoaches().forEach(coach -> {
                    Map<DayOfWeek, String> menus = recommendations.getOrDefault(coach, new LinkedHashMap<>());
                    String menu = getValidMenu(coach, category, menus.values());
                    menus.put(dayOfWeek, menu);
                    recommendations.put(coach, menus);
                })
        );
        return recommendations;
    }

    private Category getValidCategory(Collection<Category> categories) {
        Category category = Category.getRandomCategory();
        while (countCategory(categories, category) >= 2) {
            category = Category.getRandomCategory();
        }
        return category;
    }

    private String getValidMenu(Coach coach, Category category, Collection<String> menus) {
        Set<String> dislikedMenus = coach.getDislikedMenus();
        String menu = Category.getRandomMenu(category);
        while (menus.contains(menu) || dislikedMenus.contains(menu)) {
            menu = Category.getRandomMenu(category);
        }
        return menu;
    }

    private int countCategory(Collection<Category> categories, Category category) {
        return (int) categories.stream().filter(value -> value == category).count();
    }
}
