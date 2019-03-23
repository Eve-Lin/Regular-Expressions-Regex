import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Task {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        int count = 0;
        String decryptedMessage = "";
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        Pattern pattern = Pattern.compile("(.*(?<planet>(?<=@)[A-Z][a-z]+)[^@\\-!:>]*:[0-9]+[^@\\-!:>]*!(?<attack>[AD])![^@\\-!:>]*->[0-9]+)");

        for (int i = 0; i < num; i++) {
            String input = reader.readLine();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 's' || input.charAt(j) == 't' || input.charAt(j) == 'a' || input.charAt(j) == 'r' || input.charAt(j) == 'S' || input.charAt(j) == 'T' || input.charAt(j) == 'A' || input.charAt(j) == 'R') {
                    count += 1;
                }
            }
            for (int j = 0; j < input.length(); j++) {
                char inputChar = input.charAt(j);
                if (inputChar >= count) {
                    decryptedMessage += (char) (inputChar - count);
                } else {
                    inputChar = input.charAt(127 - (count - input.charAt(i)));
                    decryptedMessage += inputChar;
                }
            }

            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String attack = matcher.group("attack");
                if (attack.equals("A")) {
                    attackedPlanets.add(matcher.group("planet"));
                } else if(attack.equals("D")){
                    destroyedPlanets.add(matcher.group("planet"));
                }
            }
               decryptedMessage = "";
            count = 0;
        }
        System.out.println(String.format("Attacked planets: %d", attackedPlanets.size()));
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(e -> System.out.println(String.format("-> %s", e)));

        System.out.println(String.format("Destroyed planets: %d", destroyedPlanets.size()));
Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(e -> System.out.println(String.format("-> %s", e)));
    }
}

