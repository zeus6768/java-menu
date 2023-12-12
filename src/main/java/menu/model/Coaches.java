package menu.model;

import java.util.Collection;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(Collection<Coach> coaches) {
        validate(coaches);
        this.coaches = List.copyOf(coaches);
    }

    public static Coaches from(Collection<Coach> coaches) {
        return new Coaches(coaches);
    }

    private void validate(Collection<Coach> coaches) {
        validateDuplicates(coaches);
        validateSize(coaches);
    }

    private void validateDuplicates(Collection<Coach> coaches) {
        long distinctSize = coaches.stream().distinct().count();
        if (coaches.size() != distinctSize) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private void validateSize(Collection<Coach> coaches) {
        int size = coaches.size();
        if (size < 2 || size > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명 식사할 수 있습니다.");
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
