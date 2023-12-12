package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;

public enum Category {
    NONE(Menu.class, ""),
    ASIAN(AsianMenu.class, "아시안"),
    CHINESE(ChineseMenu.class, "중식"),
    JAPANESE(JapaneseMenu.class, "일식"),
    KOREAN(KoreanMenu.class, "한식"),
    WESTERN(WesternMenu.class, "양식");

    private final String name;

    Category(Class<? extends Menu> category, String name) {
        this.name = name;
    }

    public static Category getRandomCategory() {
        return values()[Randoms.pickNumberInRange(1, 5)];
    }

    public String getName() {
        return name;
    }
}
