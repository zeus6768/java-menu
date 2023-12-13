package menu.domain.result;

import java.util.Map;

import menu.domain.coach.Coach;
import menu.domain.constant.Category;
import menu.domain.constant.DayOfWeek;

public record RecommendResult(
        Map<DayOfWeek, Category> categoryRecommendations,
        Map<Coach, Map<DayOfWeek, String>> menuRecommendations) {}
