import lombok.SneakyThrows;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.StreamSupport;

public class Creator {
    private final Map<String, Semaphore> semaphore;
    private final CiclicBarrier barrier;
    public Creator(HashMap<String, Integer> numberOfAtom) {
        semaphore = numberOfAtom.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> new Semaphore(v.getValue())));
        barrier = new CiclicBarrier(numberOfAtom.values().stream().mapToInt(i -> i).sum());
    }

    public void create(Iterable<String> atomList) {
        String finalString = StreamSupport.stream(atomList.spliterator(),false).collect(Collectors.joining());
        System.out.println("Ввод: " + finalString + "\nВывод: ");
        atomList.forEach(e -> new Thread(() -> atom(semaphore.get(e), e)).start());
    }
    @SneakyThrows
    private void atom(Semaphore semaphore, String sym) {
        semaphore.acquire();
        barrier.await();
        System.out.println(sym);
        semaphore.release();
    }
}
