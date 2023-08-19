package design.version.a.decorator;

public class BufferedOut extends Decorator {

    private FileOut delegate;

    public BufferedOut(FileOut delegate) {
        super(delegate);
    }

    @Override
    public void write(byte[] data) {
        super.doDelegate(data);
    }
}
