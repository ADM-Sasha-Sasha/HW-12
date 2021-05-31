import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

import java.util.concurrent.CyclicBarrier;


public class Creator {

    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(1);
    CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println());

    @SneakyThrows
    public void hydrogen(Runnable releaseHydrogen) {
        hydrogen.acquire();
        barrier.await();
        releaseHydrogen.run();
        hydrogen.release();
    }
    @SneakyThrows
    public void oxygen(Runnable releaseOxygen) {
        oxygen.acquire();
        barrier.await();
        releaseOxygen.run();
        oxygen.release();
    }
}
