package homework.patternExamples.behavioral;


public class TemplateMethod {
    public static void main(String[] args) {
        Parent a = new A();
        a.templateMenthod();

        System.out.println();

        Parent b = new B();
        b.templateMenthod();
    }
}

abstract class Parent {
    void templateMenthod() {
        System.out.print(1);
        differ();
        System.out.print(3);
        differ2();
    }

    abstract void differ();

    abstract void differ2();
}

class A extends Parent {
    void differ() {
        System.out.print(2);
    }

    void differ2() {
        System.out.print(5);
    }

}

class B extends Parent {
    void differ() {
        System.out.print(4);
    }

    void differ2() {
    }
}