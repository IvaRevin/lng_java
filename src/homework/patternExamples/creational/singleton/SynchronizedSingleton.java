package homework.patternExamples.creational.singleton;

//synchronized singleton

public class SynchronizedSingleton {
    public static void main(String[] args) throws Exception {
        final int size = 1000;

        Thread t[] = new Thread[size];

        for (int i = 0; i < size; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < size; i++) {
            t[i].join();
        }
        System.out.println(SynchSingleton.count);
    }
}

class R implements Runnable {
    @Override
    public void run() {
        SynchSingleton.getInstance();
    }
}

class SynchSingleton {
    public static int count = 0;
    private static SynchSingleton instance;

    private SynchSingleton() {
        count++;
    }

//    static SynchSingleton getInstance() {
//        return instance;
//    }
// not lazy


    //    lazy
    static synchronized SynchSingleton getInstance() {
        if (instance == null) {
            instance = new SynchSingleton();
        }
        return instance;
    }
}
