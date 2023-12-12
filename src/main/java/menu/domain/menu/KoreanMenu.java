package menu.domain.menu;

public enum KoreanMenu implements Menu {
    KIMBAP("김밥"),
    KIMCHI_JJIGAE("김치찌개"),
    SSAMBAP("쌈밥"),
    DOENJANG_JJIGAE("된장찌개"),
    BIBIMBAP("비빔밥"),
    KAL_GUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JEYUK_BOKKEUM("제육볶음");

    private final String name;

    KoreanMenu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
