package menu.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public void addDislikedMenus(Collection<Menu> menus) {
        dislikedMenus.addAll(menus);
    }

    public String getName() {
        return name;
    }

    public Set<Menu> getDislikedMenus() {
        return Collections.unmodifiableSet(dislikedMenus);
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
}
