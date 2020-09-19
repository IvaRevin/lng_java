package homework.patternExamples.creational;

public class PrototypeExample {
    public static void main(String[] args) {
        Humann original = new Humann(18, "Ivan");
        Humann copy = (Humann) original.copy();

        System.out.println(original);
        System.out.println(copy);

        HumannFactory humannFactory = new HumannFactory(copy);
        Humann h1 = humannFactory.makeCopy();
        System.out.println(h1);

        humannFactory.setPrototype(new Humann(25, "Anna"));

        Humann h2 = humannFactory.makeCopy();
        System.out.println(h2);
    }
}

interface Copyable {
    Object copy();
}

class Humann implements Copyable {
    private int age;
    private String name;

    Humann(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Humann copy = new Humann(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Humann{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumannFactory {
    private Humann humann;

    HumannFactory(Humann humann) {
        setPrototype(humann);
    }

    void setPrototype(Humann humann) {
        this.humann = humann;
    }

    Humann makeCopy() {
        return (Humann) humann.copy();
    }
}
