package homework.patternExamples.behavioral;

public class CommandExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        User user = new User(new LieDownCommand(dog), new SitDownCommand(dog), new StandUpCommand(dog));
        user.dogLieDown();
        user.dogSitDown();
        user.dogStandUp();

    }
}

interface Command {
    void execute();
}

class Dog {
    public void lieDown() {
        System.out.println("Лежать");
    }

    public void sitDown() {
        System.out.println("Сидеть");
    }

    public void standUp() {
        System.out.println("Встать");
    }
}

class LieDownCommand implements Command {

    Dog dog;

    LieDownCommand(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void execute() {
        dog.lieDown();
    }

}

class SitDownCommand implements Command {

    Dog dog;

    SitDownCommand(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void execute() {
        dog.sitDown();
    }

}

class StandUpCommand implements Command {

    Dog dog;

    StandUpCommand(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void execute() {
        dog.standUp();
    }

}

class User {
    Command lieDown;
    Command sitDown;
    Command standUp;

    User(Command lieDown, Command sitDown, Command standUp) {
        this.lieDown = lieDown;
        this.sitDown = sitDown;
        this.standUp = standUp;
    }

    void dogLieDown() {
        lieDown.execute();
    }

    void dogSitDown() {
        sitDown.execute();
    }

    void dogStandUp() {
        standUp.execute();
    }
}