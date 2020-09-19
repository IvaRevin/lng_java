package homework.patternExamples.behavioral.chain_of_responsibility;

public class BankomatApp {
    public static void main(String[] args) {
        NoteModule note5000 = new NoteModule5000();
        NoteModule note1000 = new NoteModule1000();
        NoteModule note500 = new NoteModule500();
        NoteModule note100 = new NoteModule100();

        note5000.setNextMoneyModule(note1000);
        note1000.setNextMoneyModule(note500);
        note500.setNextMoneyModule(note100);

        note5000.takeMoney(new Money(156_000));
    }
}

class Note {
    static final int R100 = 100;
    static final int R500 = 500;
    static final int R1000 = 1000;
    static final int R5000 = 5000;

}

class Money {
    private int amt;

    Money(int amt) {
        setAmt(amt);
    }

    int getAmt() {
        return amt;
    }

    private void setAmt(int amt) {
        if (amt > 0 && amt <= 200_000 && amt % Note.R100 == 0) {
            this.amt = amt;
        } else {
            throw new RuntimeException("Сумма должна быть кратная 100 и не больше 200 000");
        }
    }
}

abstract class NoteModule {
    NoteModule next;

    abstract void takeMoney(Money money);

    void setNextMoneyModule(NoteModule module) {
        next = module;
    }

}

class NoteModule5000 extends NoteModule {
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R5000;
        int remind = money.getAmt() % Note.R5000;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R5000);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule1000 extends NoteModule {
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R1000;
        int remind = money.getAmt() % Note.R1000;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R1000);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule500 extends NoteModule {
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R500;
        int remind = money.getAmt() % Note.R500;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R500);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule100 extends NoteModule {
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R100;
        int remind = money.getAmt() % Note.R100;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R100);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}