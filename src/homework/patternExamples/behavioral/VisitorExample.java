package homework.patternExamples.behavioral;


public class VisitorExample {
    public static void main(String[] args) {
//        Element body = new BodyElement();
//        Element engine = new EngineElement();
//        Visitor mechanic = new MechanicVisitor();
//
//        body.accept(mechanic);
//        engine.accept(mechanic);

        Element car = new CarElement();
        car.accept(new DriverVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}

//Visitor
interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);

    void visit(CarElement car);

    void visit(WheelElement wheel);
}

//Element - Автозапчасть
interface Element {
    void accept(Visitor visitor);
}

//Кузов
class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Двигатель
class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class DriverVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Сел в машину");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Поехал на машине");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Проверил " + wheel.getName() + " колеса");
    }
}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал корпус");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Проверил внешний вид автомобиля");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Подкачал " + wheel.getName() + " колесо");
    }
}

class WheelElement implements Element {
    private String name;

    WheelElement(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    private Element[] elements;

    CarElement() {
        this.elements = new Element[]{new WheelElement("переднее левое"), new WheelElement("переднее правое"),
                new WheelElement("заднее левое"), new WheelElement("заднее правое"),
                new BodyElement(), new EngineElement()};
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }


}

