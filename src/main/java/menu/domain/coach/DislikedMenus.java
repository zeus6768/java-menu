package menu.domain.coach;

import java.util.Collection;
import java.util.Set;

import menu.domain.constant.Category;

public class DislikedMenus {

    private final Set<String> menus;

    private DislikedMenus(Collection<String> menus) {
        validateExist(menus);
        validateSize(menus);
        this.menus = Set.copyOf(menus);
    }

    public static DislikedMenus from(Collection<String> menus) {
        return new DislikedMenus(menus);
    }

    private void validateExist(Collection<String> menus) {
        boolean exists = menus.stream().allMatch(Category::containsMenu);
        if (!exists) {
            throw  new IllegalArgumentException("존재하지 않는 메뉴입니다.");
        }
    }

    private void validateSize(Collection<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지 입력할 수 있습니다.");
        }
    }

    public Set<String> getMenus() {
        return menus;
    }
}
