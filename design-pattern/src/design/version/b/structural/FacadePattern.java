package design.version.b.structural;

public class FacadePattern {

  // Subsystem class 1
  class CPU {

    public void start() {
      System.out.println("CPU is starting");
    }

    public void stop() {
      System.out.println("CPU is stopping");
    }
  }

  // Subsystem class 2
  class Memory {

    public void load() {
      System.out.println("Memory is loading data");
    }

    public void unload() {
      System.out.println("Memory is unloading data");
    }
  }

  // Subsystem class 3
  class HardDrive {

    public void read() {
      System.out.println("Hard Drive is reading data");
    }

    public void write() {
      System.out.println("Hard Drive is writing data");
    }
  }

  // Facade
  // 복잡한 내부 시스템을 간단히 이용할 수 있게 만드는 인터페이스 역할을 갖는 퍼사드 클래스
  class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
      cpu = new CPU();
      memory = new Memory();
      hardDrive = new HardDrive();
    }

    public void start() {
      System.out.println("Starting computer...");
      cpu.start();
      memory.load();
      hardDrive.read();
      System.out.println("Computer started");
    }

    public void stop() {
      System.out.println("Shutting down computer...");
      cpu.stop();
      memory.unload();
      hardDrive.write();
      System.out.println("Computer shut down");
    }
  }

  public void main() {
    ComputerFacade computer = new ComputerFacade();

    // Starting computer
    computer.start();

    System.out.println();

    // Stopping computer
    computer.stop();
  }
}
