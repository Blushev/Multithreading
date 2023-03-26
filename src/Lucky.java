import java.util.concurrent.atomic.AtomicInteger;

public class Lucky {
    static AtomicInteger x = new AtomicInteger(0);
    static AtomicInteger count = new AtomicInteger(0);

    static class LuckyThread extends Thread {
        @Override
        public void run() {
            while (x.get() < 999999) {
                int value = x.incrementAndGet();
                if ((value % 10) + (value / 10) % 10 + (value / 100) % 10 == (value / 1000)
                        % 10 + (value / 10000) % 10 + (value / 100000) % 10) {
                    System.out.println(value);
                    count.incrementAndGet();
                }
            }
        }
    }
}