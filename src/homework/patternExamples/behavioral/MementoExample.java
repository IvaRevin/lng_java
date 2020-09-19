package homework.patternExamples.behavioral;

public class MementoExample {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("Level_1", 24935930);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("Level_2", 535892584);
        System.out.println(game);

        game.load(file.getSave());
        System.out.println(game);
    }
}

class Game {
    private String level;
    private int ms;

    void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }

    Save save() {
        return new Save(level, ms);
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}

class Save {
    private final String level;
    private final int ms;

    Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    String getLevel() {
        return level;
    }

    int getMs() {
        return ms;
    }
}

class File {
    private Save save;

    Save getSave() {
        return save;
    }

    void setSave(Save save) {
        this.save = save;
    }
}
