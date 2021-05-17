import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    public CustomThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        if (command != null) {
            Class<? extends Runnable> runnableClass = command.getClass();
            Repeat repeat = runnableClass.getAnnotation(Repeat.class);
            for (int i = 0; i < (repeat != null ? repeat.value() : 1); i++) {
                super.execute(command);
            }
        }
    }

}