package menu.domain.coach;

import java.util.Objects;
import java.util.Set;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private DislikedMenus dislikedMenus;

    private Coach(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    public void putDislikedMenus(DislikedMenus dislikedMenus) {
        this.dislikedMenus = dislikedMenus;
    }

    private void validateNameLength(String name) {
        int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 "
                    + MIN_NAME_LENGTH + "글자, 최대 "
                    + MAX_NAME_LENGTH + "글자입니다."
            );
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

    public Set<String> getDislikedMenus() {
        return dislikedMenus.getMenus();
    }
}
