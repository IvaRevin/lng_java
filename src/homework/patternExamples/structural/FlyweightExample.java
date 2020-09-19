package homework.patternExamples.structural;

import java.util.*;

public class FlyweightExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(shapeFactory.getShape("Квадрат"));
        shapeList.add(shapeFactory.getShape("Круг"));
        shapeList.add(shapeFactory.getShape("Круг"));
        shapeList.add(shapeFactory.getShape("Точка"));
        shapeList.add(shapeFactory.getShape("Квадрат"));
        shapeList.add(shapeFactory.getShape("Круг"));

        Random random = new Random();
        for (Shape shape : shapeList) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
        }


    }
}

//Flyweight
interface Shape {
    void draw(int x, int y);
}

//Point Flyweight
class Point implements Shape {

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем точку");
    }
}

//Circle Flyweight
class Circle implements Shape {
    private int r = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем круг радиусом " + r);
    }
}

//Square Flyweight
class Square implements Shape {
    private int a = 10;

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем квадарат со стороной " + a);
    }

}

class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();

    Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName) {
                case "Круг":
                    shape = new Circle();
                    break;
                case "Квадрат":
                    shape = new Square();
                    break;
                case "Точка":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}