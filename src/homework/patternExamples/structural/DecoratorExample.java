package homework.patternExamples.structural;

public class DecoratorExample {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new TextDecorator(new Printer("Hello!")));
        printer.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface {
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    public void print() {
        component.print();
    }
}

class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("\"");
        super.print();

    }
}

class TextDecorator extends Decorator {
    public TextDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        super.print();
        System.out.println(" My name is Ivan.\"");
    }
}