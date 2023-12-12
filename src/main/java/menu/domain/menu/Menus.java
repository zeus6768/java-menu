package menu.domain.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Menus {

    private final Map<String, Menu> menus;

    public Menus() {
        menus = new HashMap<>();
        putMenus(AsianMenu.values());
        putMenus(ChineseMenu.values());
        putMenus(JapaneseMenu.values());
        putMenus(KoreanMenu.values());
        putMenus(WesternMenu.values());
    }

    public Menu find(String name) {
        if (menus.containsKey(name)) {
            return menus.get(name);
        }
        throw new IllegalArgumentException(name + " 메뉴는 존재하지 않습니다.");
    }

    private void putMenus(Menu[] menus) {
        Stream.of(menus).forEach(this::put);
    }

    private void put(Menu menu) {
        menus.put(menu.getName(), menu);
    }
}
