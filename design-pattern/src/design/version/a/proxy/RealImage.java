package design.version.a.proxy;

public class RealImage {

    private String path;

    public RealImage(String path) {
        this.path = path;
    }

    public void draw() {
        System.out.println(path);
    }
}
