import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class ThreadClass extends Thread
{
    private CountDownLatch countDownLatch;

    public ThreadClass(CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run()
    {
        System.out.println("Введите 5 чисел");
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++)
        {
            list.add(scanner.nextInt());
            countDownLatch.countDown();
        }
        try
        {
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        for (int i:list)
        {
            System.out.println(i/2);
        }
    }
}
