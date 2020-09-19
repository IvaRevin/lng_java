package homework.patternExamples.creational.singleton;

//not synchronized singleton

public class SingletonExample {
    public static void main(String[] args) throws Exception {
        final int SIZE = 1000;
        Singleton[] array = new Singleton[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = Singleton.getInstance();
        }
        System.out.println(Singleton.count);
    }
}

class Singleton {
    public static int count = 0;
    private static Singleton instance;

    private Singleton() {
        count++;
    }

    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
