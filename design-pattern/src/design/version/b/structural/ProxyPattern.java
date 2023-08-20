package design.version.b.structural;

public class ProxyPattern {

  interface Image {

    void display();
  }

  // Real Subject
  class RealImage implements Image {

    private String filename;

    public RealImage(String filename) {
      this.filename = filename;
      loadFromDisk();
    }

    private void loadFromDisk() {
      System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
      System.out.println("Displaying image: " + filename);
    }
  }

  // Proxy
  // 외부의 요청은 ImageProxy를 사용하고 실제 처리는 RealImage에서 수행됩니다.
  class ImageProxy implements Image {

    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
      this.filename = filename;
    }

    @Override
    public void display() {
      if (realImage == null) {
        realImage = new RealImage(filename);
      }
      realImage.display();
    }
  }

  public void main() {
    Image image1 = new ImageProxy("image1.jpg");
    Image image2 = new ImageProxy("image2.jpg");

    // Image 로딩이 필요한 시점에서 실제 객체 생성
    image1.display();
    image2.display();
  }
}
