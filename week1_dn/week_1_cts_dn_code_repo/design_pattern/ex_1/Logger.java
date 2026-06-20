package design_pattern.ex_1;

public class Logger {

    private static Logger instance;

    private Logger() {

    }

    public static Logger getInstance() {

        if(instance == null) {
            instance = new Logger();
        }

        return instance;
    }
}