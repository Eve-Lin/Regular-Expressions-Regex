import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Task3 {
     public static void main(String[] args) throws IOException {

          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

          String[] userNames = reader.readLine().split(", ");


         Pattern regex = Pattern.compile("^[\\w\\-]{3,16}$");


         for (int i = 0; i < userNames.length; i++) {

             String userName = userNames[i];
             Matcher matcher = regex.matcher(userName);
             while (matcher.find()){
                 String matcherGroup = matcher.group();
                 System.out.println(matcherGroup);
             }

         }
      }
}
