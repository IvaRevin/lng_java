package homework.patternExamples.structural;

public class FacadeExample {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

//Facade
class Computer {
    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {
    void on() {
        System.out.println("Включили питание");
    }

    void off() {
        System.out.println("Выключили питание");
    }
}

class DVDRom {
    private boolean data = false;

    boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            System.out.println("Происходит копирование");
        } else {
            System.out.println("Вставте диск с данными");
        }
    }
}

