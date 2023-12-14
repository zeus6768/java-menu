package menu.exception;

import java.util.function.Supplier;

public class ExceptionHandler {

    private static final String ERROR = "[ERROR] ";

    public <T> T handle(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR + exception.getMessage());
            }
        }
    }
}
