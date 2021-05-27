import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Water {

    private static final String HYDROGEN = "H", OXYGEN = "O";
    public static void main(String[] args) {
        HashMap<String, Integer> molecule = new HashMap<String, Integer>(2) {
            {
                put(OXYGEN, 1);
                put(HYDROGEN, 2);
            }
        };
        new Creator (molecule).create(getSource(3));
    }
    private static List<String> getSource(int numberOfMolecules) {
        return Stream.generate(() -> Stream.of(HYDROGEN, HYDROGEN, OXYGEN)).limit(numberOfMolecules)
                .flatMap(s -> s).collect(Collectors.toList());
    }
}
