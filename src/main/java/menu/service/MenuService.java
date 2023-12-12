package menu.service;

import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

import menu.domain.constant.DayOfWeek;
import menu.domain.menu.Category;
import menu.domain.menu.Menus;

public class MenuService {

    private final Menus menus;

    public MenuService(Menus menus) {
        this.menus = menus;
    }

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

    private Category getValidCategory(EnumMap<Category, Integer> categoryCount) {
        Category category = Category.getRandomCategory();
        while (categoryCount.containsKey(category) && categoryCount.get(category) == 2) {
            category = Category.getRandomCategory();
        }
        return category;
    }
}
