package menu.domain.menu;

public enum JapaneseMenu implements Menu {
    GYUDON("규동"),
    UDON("우동"),
    MISOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDONG("가츠동"),
    ONIGIRI("오니기리"),
    HAYASHI_RICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼");

    private final String name;

    JapaneseMenu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
