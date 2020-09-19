package homework.patternExamples.behavioral.chain_of_responsibility;

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);

        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("Все хорошо", Level.INFO);
        logger0.writeMessage("Идет режим отладки", Level.DEBUG);
        logger0.writeMessage("Система упала", Level.ERROR);
    }
}

class Level {
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;

}

abstract class Logger {
    private int priority;

    Logger(int priority) {
        this.priority = priority;
    }

    private Logger next;

    void setNext(Logger next) {
        this.next = next;
    }

    void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);

}

class SMSLogger extends Logger {
    SMSLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("СМС: " + message);
    }
}

class FileLogger extends Logger {
    FileLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Вывод в файл: " + message);
    }
}

class EmailLogger extends Logger {
    EmailLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("E-mail сообщение: " + message);
    }
}