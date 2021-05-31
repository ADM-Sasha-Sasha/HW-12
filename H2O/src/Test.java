

public class Test {
    public static void main(String[] args) {
        final Runnable releaseHydro = () -> System.out.print("H");
        final Runnable releaseOxy = () -> System.out.print("O");

        String input = "OOOOOOHHHHHOHHHOOHH";

        Creator h2O = new Creator();

        for (char el : input.toCharArray()) {
            if (el == 'H') {
                new Thread(() -> h2O.hydrogen(releaseHydro)).start();
            }
            if (el == 'O') {
                new Thread(() -> h2O.oxygen(releaseOxy)).start();
            }
        }
    }
}
