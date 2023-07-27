import java.util.concurrent.CountDownLatch;

public class Main
{
    public static void main(String[] args)
    {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ThreadClass threadClass = new ThreadClass(countDownLatch);
        Thread thread = new Thread(threadClass);
        thread.start();
    }
}
