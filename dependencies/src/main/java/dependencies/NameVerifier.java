package dependencies;


import org.apache.commons.lang3.StringUtils;

/**
 * Klasa testowa
 * @author Pawel
 */
public class NameVerifier {
    public static void main(String[] args) {
        String name = "Maciek";
        System.out.println(StringUtils.isAlpha(name));
    }

    /**
     * Metoda dodająca dwie liczby
     * @param a
     * @param b
     * @return suma parametrów
     */
    public int add(int a, int b) {
        return a + b;
    }
}
