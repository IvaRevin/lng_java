package homework.patternExamples.structural;

//VirtualProxy

public class ProxyExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("C:/revin/image/..");
        image.display();

    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String file;

    RealImage(String file) {
        this.file = file;
        load();
    }

    private void load() {
        System.out.println("Происходит загрузка " + file);
    }

    @Override
    public void display() {
        System.out.println("Просмотр " + file);
    }

}

class ProxyImage implements Image {

    private String file;
    private RealImage realImage;

    ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}
