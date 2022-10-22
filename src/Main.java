import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger3 = new AtomicInteger();
        AtomicInteger atomicInteger4 = new AtomicInteger();
        AtomicInteger atomicInteger5 = new AtomicInteger();
        ConditionChecking checker = new ConditionChecking();
        String[] checked = GenerateRandomText.generateNames(100000, "abc");
        Thread thread1 = new Thread(() -> {
            for (String name : checked) {
                if (name.length() == 3 && checker.palindrome(name) && !checker.single(name)) {
                    atomicInteger3.incrementAndGet();
                }
                if (name.length() == 4 && checker.palindrome(name) && !checker.single(name)) {
                    atomicInteger4.incrementAndGet();
                }
                if (name.length() == 5 && checker.palindrome(name) && !checker.single(name)) {
                    atomicInteger5.incrementAndGet();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (String name : checked) {
                if (name.length() == 3 && checker.single(name)) {
                    atomicInteger3.incrementAndGet();
                }
                if (name.length() == 4 && checker.single(name)) {
                    atomicInteger4.incrementAndGet();
                }
                if (name.length() == 5 && checker.single(name)) {
                    atomicInteger5.incrementAndGet();
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for (String name : checked) {
                if (name.length() == 3 && checker.sortedName(name) && !checker.sortedName(name)) {
                    atomicInteger3.incrementAndGet();
                }
                if (name.length() == 4 && checker.sortedName(name) && !checker.sortedName(name)) {
                    atomicInteger4.incrementAndGet();
                }
                if (name.length() == 5 && checker.sortedName(name) && !checker.sortedName(name)) {
                    atomicInteger5.incrementAndGet();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();


        System.out.println("Красивых слов с длиной 3 : " + atomicInteger3 + " шт.");
        System.out.println("Красивых слов с длиной 4 : " + atomicInteger4 + " шт.");
        System.out.println("Красивых слов с длиной 5 : " + atomicInteger5 + " шт.");

    }
}