package menu.domain.coach;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import menu.domain.menu.Menu;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private final Set<Menu> dislikedMenus;

    private Coach(String name) {
        validate(name);
        this.name = name;
        dislikedMenus = new HashSet<>();
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    public void putDislikedMenus(Collection<Menu> menus) {
        validateMenuSize(menus);
        dislikedMenus.addAll(menus);
    }

    private void validate(String name) {
        int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 "
                    + MIN_NAME_LENGTH
                    + "글자, 최대 "
                    + MAX_NAME_LENGTH
                    + "글자입니다."
            );
        }
    }

    private void validateMenuSize(Collection<Menu> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지 입력할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Coach other
                && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public Set<Menu> getDislikedMenus() {
        return Collections.unmodifiableSet(dislikedMenus);
    }
}
