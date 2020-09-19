package homework.patternExamples.behavioral;

public class IteratorExample {
    public static void main(String[] args) {
        Tasks c = new Tasks();
        Iterator iterator = c.getIterator();

        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();

}

interface Container {
    Iterator getIterator();

}

class Tasks implements Container {
    private String[] tasks = {"Построить дом", "Посадить дерево", "Родить сына"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
