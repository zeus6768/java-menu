package menu.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.constant.Category;
import menu.domain.constant.DayOfWeek;
import menu.domain.result.RecommendResult;

public class MenuService {

    public Coaches createCoaches(String[] coachNames) {
        List<Coach> coaches = Arrays.stream(coachNames).map(Coach::from).toList();
        return Coaches.from(coaches);
    }

    public RecommendResult recommend(Coaches coaches) {
        Map<DayOfWeek, Category> recommendCategories = new LinkedHashMap<>();
        Map<Coach, Map<DayOfWeek, String>> recommendMenus = new LinkedHashMap<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            Category category = getValidCategory(recommendCategories.values());
            recommendCategories.put(dayOfWeek, category);
            for (Coach coach : coaches.getCoaches()) {
                Map<DayOfWeek, String> menus = recommendMenus.getOrDefault(coach, new LinkedHashMap<>());
                String menu = getValidMenu(category, menus.values());
                menus.put(dayOfWeek, menu);
                recommendMenus.put(coach, menus);
            }
        }
        return new RecommendResult(recommendCategories, recommendMenus);
    }

    private Category getValidCategory(Collection<Category> categories) {
        Category category = Category.getRandomCategory();
        while (countCategory(categories, category) >= 2) {
            category = Category.getRandomCategory();
        }
        return category;
    }

    private String getValidMenu(Category category, Collection<String> menus) {
        String menu = Category.getRandomMenu(category);
        while (menus.contains(menu)) {
            menu = Category.getRandomMenu(category);
        }
        return menu;
    }

    private int countCategory(Collection<Category> categories, Category category) {
        return (int) categories.stream().filter(value -> value == category).count();
    }
}
