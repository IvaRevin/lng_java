package homework.patternExamples.structural;

public class BridgeExample {
    public static void main(String[] args) {
        Car car = new HatchBack(new Skoda());
        car.showDetails();
    }
}

abstract class Car {
    Mark mark;

    public Car(Mark mark) {
        this.mark = mark;
    }

    abstract void showType();

    void showDetails() {
        showType();
        mark.setMark();
    }
}

class Sedan extends Car {

    public Sedan(Mark mark) {
        super(mark);
    }

    @Override
    void showType() {
        System.out.println("Sedan");
    }
}

class HatchBack extends Car {

    public HatchBack(Mark mark) {
        super(mark);
    }

    @Override
    void showType() {
        System.out.println("HatchBack");
    }
}

interface Mark {
    void setMark();
}

class Kia implements Mark {

    @Override
    public void setMark() {
        System.out.println("Kia");
    }
}

class Skoda implements Mark {

    @Override
    public void setMark() {
        System.out.println("Skoda");
    }
}