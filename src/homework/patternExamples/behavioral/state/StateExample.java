package homework.patternExamples.behavioral.state;

public class StateExample {
    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}
//State
interface Station {
    void play();
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Радио 7 ...");
    }
}

class RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("Радио DFM ...");
    }
}

class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("Вести FM ...");
    }
}
//Context
class Radio {
    private Station station;

    void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else {
            if (station instanceof RadioDFM) {
                setStation(new VestiFM());
            } else {
                if (station instanceof VestiFM) {
                    setStation(new Radio7());
                }
            }
        }
    }

    void play() {
        station.play();
    }
}