public class Logger {
    private static Logger instance;
    private Logger() {
        System.out.println("Logger initialized.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (singleton works).");
        } else {
            System.out.println("Different instances exist (singleton failed).");
        }
    }
}
