
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Wax
{
    public static void main(String []args)throws InterruptedException
    {
        Car car=new Car();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new WaxOn(car,1));
        executorService.execute(new WaxOn(car,2));
        executorService.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        //executorService.shutdown();
        executorService.shutdownNow();
    }
}
class Car
{
    private boolean waxed=false;
    public synchronized void waxit()
    {
        waxed=true;
        notifyAll();
    }
    public synchronized void unwaxit()
    {
        waxed=false;
        notifyAll();
    }
    public synchronized void waitForWaxing()throws InterruptedException
    {
        while(waxed==false)
            wait();
    }
    public synchronized void watiForUnwaxing()throws InterruptedException
    {
        while(waxed==true)
            wait();
    }

}
class WaxOn implements Runnable
{
    private Car car;
    private int id;
    private Lock lock=new ReentrantLock();
    WaxOn(Car c,int id)
    {
        car=c;
        this.id=id;
    }
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                synchronized (car)
                {
                    car.watiForUnwaxing();
                    System.out.println("Wax On " + id + " Waxing...");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxit();
                }
            }
        }
        catch (InterruptedException ex)
        {

        }

        System.out.println("Waxing Done "+id);
    }
}
class WaxOff implements Runnable
{
    private Car car;
    WaxOff(Car c)
    {
        car=c;
    }
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                car.waitForWaxing();
                System.out.println("Waxing off...");
                TimeUnit.MILLISECONDS.sleep(200);
                car.unwaxit();

            }
        }
        catch (InterruptedException ex)
        {

        }
        System.out.println("Wax off done");
    }
}