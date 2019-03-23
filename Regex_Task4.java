import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Task4 {
     public static void main(String[] args) throws IOException {

          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

          String input = reader.readLine();

          Pattern regex = Pattern.compile("(^|(?<=\\s))(([a-zA-Z0-9]+)([\\.\\-_]?)([A-Za-z0-9]+)(@)([a-zA-Z]+([\\.\\-_][A-Za-z]+)+))(\\b|(?=\\s))");


             Matcher matcher = regex.matcher(input);
             while(matcher.find()){
                 String email = matcher.group();
                 System.out.println(email);
             }

         }
      }

