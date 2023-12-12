package menu.domain.menu;

public enum WesternMenu implements Menu {
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    YAKI_UDON("뇨끼"),
    KATSU("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private final String name;

    WesternMenu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
