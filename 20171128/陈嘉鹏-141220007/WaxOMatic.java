
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-10
 */
class Car {
    private boolean waxOn = true;
    private final Object bufferedLock = new Object();
    private final Object waxedLock = new Object();
    private final Object OnlyOneCanRun = new Object();
    private boolean running = false;

    public synchronized void waxed() throws InterruptedException {
        waxOn = true; // Ready to buff
        synchronized (bufferedLock) {
            bufferedLock.notifyAll();
        }
    }

    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        synchronized (OnlyOneCanRun) {
            running = false;
            OnlyOneCanRun.notifyAll();
        }
        synchronized (waxedLock) {
            waxedLock.notifyAll();
        }
    }

    public void waitForWaxing()
            throws InterruptedException {
        synchronized (bufferedLock){
            if(!this.waxOn)
                bufferedLock.wait();

        }
    }

    public void waitForBuffing()
            throws InterruptedException {
        synchronized (waxedLock){
            if (this.waxOn)
                waxedLock.wait();
        }
        synchronized (OnlyOneCanRun){
            while (running)
                OnlyOneCanRun.wait();
            running = true;
        }
    }
}


class WaxOn implements Runnable {
    private Car car;
    private Integer id;

    public WaxOn(Car c, Integer id) {
        car = c;
        this.id = id;
    }

    public void run() {

        try {
            while (!Thread.interrupted()) {
                car.waitForBuffing();
                System.out.println("WaxOn" + id + ": Wax On! \n");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax" + id + " On task");
    }

}
class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax Off! \n");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
                car.waitForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car, 1));
        exec.execute(new WaxOn(car, 2));
        TimeUnit.SECONDS.sleep(10); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}