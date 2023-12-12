package menu.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coach {

    private final String name;
    private final Set<Menu> dislikedMenus;

    private Coach(String name) {
        this.name = name;
        dislikedMenus = new HashSet<>();
    }

    public static Coach from(String name) {
        return new Coach(name);
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
