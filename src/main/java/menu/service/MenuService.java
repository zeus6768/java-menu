package menu.service;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.constant.Category;
import menu.domain.constant.DayOfWeek;

public class MenuService {

    public Map<DayOfWeek, Category> recommendCategories() {
        Map<DayOfWeek, Category> recommendations = new TreeMap<>();
        EnumMap<Category, Integer> categoryCount = new EnumMap<>(Category.class);
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            Category category = getValidCategory(categoryCount);
            recommendations.put(dayOfWeek, category);
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }
        return recommendations;
    }

    public Map<Coach, Map<DayOfWeek, String>> recommendMenus(Coaches coaches, Map<DayOfWeek, Category> categories) {
        Map<Coach, Map<DayOfWeek, String>> result = new LinkedHashMap<>();
        for (Coach coach : coaches.getCoaches()) {
            Map<DayOfWeek, String> menuByDayOfWeek = new LinkedHashMap<>();
            for (Entry<DayOfWeek, Category> entry : categories.entrySet()) {
                DayOfWeek dayOfWeek = entry.getKey();
                Category category = entry.getValue();
                String menu = getValidMenu(category, menuByDayOfWeek);
                menuByDayOfWeek.put(dayOfWeek, menu);
            }
            result.put(coach, menuByDayOfWeek);
        }
        return result;
    }

    private String getValidMenu(Category category, Map<DayOfWeek, String> menus) {
        String menu = Category.getRandomMenu(category);
        while (menus.containsValue(menu)) {
            menu = Category.getRandomMenu(category);
        }
        return menu;
    }

    private Category getValidCategory(EnumMap<Category, Integer> categoryCount) {
        Category category = Category.getRandomCategory();
        while (categoryCount.containsKey(category) && categoryCount.get(category) == 2) {
            category = Category.getRandomCategory();
        }
        return category;
    }
}
