package cn.acvrock;

import java.util.ServiceLoader;

public class JavaSPITest {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

    public interface Robot {
        void sayHello();
    }

    public static class OptimusPrime implements Robot {

        @Override
        public void sayHello() {
            System.out.println("Hello, I am Optimus Prime.");
        }
    }

    public static class Bumblebee implements Robot {

        @Override
        public void sayHello() {
            System.out.println("Hello, I am Bumblebee.");
        }
    }
}
