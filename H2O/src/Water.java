import java.util.Random;
import java.util.StringJoiner;

public class Water {
    private int el;
    private int elOxygen = 0;
    private int elHydrogen = 0;
    private Random random = new Random();
    private StringJoiner res = new StringJoiner("");

    public Water (int el) {
        this.el = el;
    }
    public StringJoiner result() {
        String input = "OH";
        while (elHydrogen < el/3*2 || elOxygen < el/3) {
            char element = input.charAt(random.nextInt(2));
            switch (element) {
                case 'H':
                    if (elHydrogen < (el/3*2)) {
                        res.add(Character.toString(el));
                        elHydrogen++;
                    }
                    break;
                case 'O':
                    if (elOxygen < (el/3)) {
                        res.add(Character.toString(el));
                        elOxygen++;
                    }
                    break;
            }
        }
        return res;
    }
}
