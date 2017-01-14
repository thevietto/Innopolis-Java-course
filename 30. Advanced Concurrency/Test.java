package inno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

import static inno.Test.PHASER;

/**
 * Created by vietto on 22.12.16.
 */
public class Test {

    ExecutorService fixedThreadPool;
    static final Semaphore SEMAPHORE = new Semaphore(5);
    static final Phaser PHASER = new Phaser(1);

    @PostConstruct
    public void create() {
        fixedThreadPool = Executors.newFixedThreadPool(3);
    }

    @PreDestroy
    public void destroy() {
        fixedThreadPool.shutdown();
        fixedThreadPool.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {

        //        Lock lock = new ReentrantLock(true);
//
//        lock.lock();
//        try {
//            // Код
//        } finally {
//            lock.unlock();
//        }
//
//        if (lock.tryLock()) {
//            // делаем дело
//        } else {
//            // делаем что-то другое
//        }
//
//        new Thread(new SomeRunnable(lock));


//        AtomicInteger integer = new AtomicInteger(10);
//        integer.addAndGet(11); // +=
//        integer.getAndAdd(11); // сначала =, а потом +
//        integer.incrementAndGet();
//
//        AtomicBoolean b = new AtomicBoolean();
//
//        int i = integer.get();
//        integer.compareAndSet(i, 20);

//        Callable<String> callable = new Callable<String>() {
//            public String call() throws Exception {
//                Thread.sleep(2000);
//                return "gotha";
//            }
//        };
//
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<String> submit = executor.submit(callable);
//
//        try {
//            System.out.println(submit.get(1, TimeUnit.MINUTES));
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(() -> {
            System.out.println("Haha");
        });
        singleThreadExecutor.shutdown();
//
//        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        ReentrantReadWriteLock.ReadLock lock1 = lock.readLock();
//        ReentrantReadWriteLock.WriteLock lock2 = lock.writeLock();
//        lock2.lock();
//        lock1.lock();

//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

//        for (int i = 0; i < 100; i++) {
//            fixedThreadPool.submit(() -> {
//                System.out.println("Выполняюсь");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//
//                }
//            });
//        }

//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 100; i++) {
//            cachedThreadPool.submit(() -> {
//                System.out.println("Выполняюсь");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//
//                }
//            });
//        }
//        cachedThreadPool.shutdown();

//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
//        executorService.schedule(() -> {
//            System.out.println("test");
//        }, 5, TimeUnit.SECONDS);
//
//        executorService.scheduleAtFixedRate(() -> {
//            System.out.println("test");
//        }, 3, 2, TimeUnit.SECONDS);
//        executorService.shutdown();
//

        // Синхронизаторы
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
//
//        FutureTask task = new FutureTask(() -> {
//            System.out.println("test");
//            return true;
//        });
//        task.
//        executorService.submit(task);

//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                try {
//                    SEMAPHORE.acquire(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Выполняюсь");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                SEMAPHORE.release();
//            }).start();
//        }
//
//        try {
//            Thread.sleep(3000);
//            SEMAPHORE.release(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        CountDownLatch latch = new CountDownLatch(10);
//        new Thread(() -> {
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Поехали!");
//        }).start();
//        for (int i = 10; i > 0; i--) {
//            System.out.println(i);
//            Thread.sleep(1000);
//            latch.countDown();
//        }

//        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("МЕНЯ СЛОМАЛИ!!!"));
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                try {
//                    barrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Выполняюсь!");
//            }).start();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        barrier.reset();

//        Exchanger<String> exchanger = new Exchanger<>();
//        new Thread(() -> {
//            System.out.println("Грузовик А везет груз");
//            try {
//                Thread.sleep(1000);
//                String s = exchanger.exchange(null);
//                System.out.println("Грузовик А получил Груз " + s);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            System.out.println("Грузовик B везет груз");
//            try {
//                Thread.sleep(3000);
//                String s = exchanger.exchange("B");
//                System.out.println("Грузовик B получил Груз " + s);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();


//        List<Passenger> passengers = new ArrayList<>();
//        passengers.add(new Passenger(1, 3));
//        passengers.add(new Passenger(2, 5));
//        passengers.add(new Passenger(4, 5));
//        passengers.add(new Passenger(3, 4));
//
//        for (int i = 0; i < 7; i++) {
//            if (i == 0) {
//                System.out.println("Автобус выехал за пассажирами");
//                PHASER.arrive();
//            } else if (i == 6) {
//                System.out.println("Автобус закончил движение");
//                PHASER.arriveAndDeregister();
//            } else {
//                int stop = PHASER.getPhase();
//                System.out.println("Остановка " + stop);
//                for (Passenger passenger : passengers) {
//                    if (passenger.getDeparture() == stop) {
//                        PHASER.register();
//                        new Thread(passenger).start();
//                    }
//                }
//                PHASER.arriveAndAwaitAdvance();
//            }
//        }

//        List<String> a = new ArrayList<>();
//        List<String> a2 = Collections.synchronizedList(a);
//        for (String s : a2) {
//
//        }
//
//        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
//        list.get(30); // быстро
//        list.add(new Object()); // очень долго

//        ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();

//        ConcurrentHashMap<String, String>

    }


//    public void m() {
//        fixedThreadPool.submit(() -> {
//            // code
//        });
//    }
}

class Passenger implements Runnable {

    private int departure;
    private int arrival;

    public Passenger(int departure, int arrival) {
        this.departure = departure;
        this.arrival = arrival;
        System.out.println(this + " ждет на остановке " + departure);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " садится в автобус");
            while (PHASER.getPhase() < arrival) {
                PHASER.arriveAndAwaitAdvance();
            }
            Thread.sleep(100);
            System.out.println(this + " вышел из автобуса");
            PHASER.arriveAndDeregister();
        } catch (InterruptedException e) {

        }
    }
}
