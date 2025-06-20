
// SingletonPattern.java

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Hello from logger 1!");

        Logger logger2 = Logger.getInstance();
        logger2.log("Hello again from logger 2!");

        Logger logger3 = Logger.getInstance();
        logger3.log("Third log message!");

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("All loggers are the same instance.");
        } else {
            System.out.println("Different Logger instances exist.");
        }

        System.out.println("Total logs written: " + logger1.getLogCount());
    }
}



class Logger {
    private static Logger singleInstance = null;
    private int logCount = 0;

    private Logger() {
        System.out.println("Logger instance created.");
    }


    public static synchronized Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("Log: " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
