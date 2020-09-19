package homework.patternExamples.creational.singleton;

//lazy synchronized best singleton

public class AnotherSynchronizedSingleton {
    public static void main(String[] args) throws Exception {
        final int size = 1000;

        Thread t[] = new Thread[size];

        for (int i = 0; i < size; i++) {
            t[i] = new Thread(new Run());
            t[i].start();
        }
        for (int i = 0; i < size; i++) {
            t[i].join();
        }
        System.out.println(SynchSingleton2.count);
    }
}

class Run implements Runnable {
    @Override
    public void run() {
        SynchSingleton2.getInstance();
    }
}

class SynchSingleton2 {
    public static int count = 0;
    private static volatile SynchSingleton2 instance;

    private SynchSingleton2() {
        count++;
    }


    public static SynchSingleton2 getInstance() {
        if (instance == null) {

            synchronized (SynchSingleton2.class) {
                if (instance == null)
                    instance = new SynchSingleton2();
            }
        }
        return instance;
    }
}
