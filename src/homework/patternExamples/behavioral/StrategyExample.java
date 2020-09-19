package homework.patternExamples.behavioral;

import java.util.Arrays;

public class StrategyExample {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] mas0 = {1,6,36,2,1};
        c.setStrategy(new SelectionsSort());
        c.executeStrategy(mas0);

        int[] mas1 = {5,2453,35,2,6,2};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(mas1);

        int[] mas2 = {6,3,9,2,10,67,46,35,8};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(mas2);
    }
}

//Context
class StrategyClient {
    private Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting {
    void sort(int[] arr);
}

//Bubble sort Strategy
class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка пузырьком");
        for (int barier = arr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}

//Selections sorting Strategy
class SelectionsSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка вставками");
        for (int barier = 0; barier < arr.length - 1; barier++) {
            for (int i = barier + 1; i < arr.length; i++) {
                if (arr[i] < arr[barier]) {
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

//Inserting sorting Strategy
class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка выборками");
        for (int barier = 1; barier < arr.length; barier++) {
            int index = barier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}