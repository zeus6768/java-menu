package menu.domain.menu;

public enum ChineseMenu implements Menu {
    KKANPUNGGI("깐풍기"),
    DONGPO_PORK("동파육"),
    JJAJANGMYEON("짜장면"),
    JJAMPONG("짬뽕"),
    MAPO_TOFU("마파두부"),
    TANGSUYUK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    GOCHU_JAPCHAE("고추잡채");

    private final String name;

    ChineseMenu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}