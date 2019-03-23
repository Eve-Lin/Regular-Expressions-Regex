import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Task2 {
     public static void main(String[] args) throws IOException {

          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

          String input = "";
          double sum =0;
         List<String> products = new ArrayList<>();

         Pattern regex = Pattern.compile(">>(?<product>[A-Z{0,}a-z]+)+<<(?<price>\\d+\\.?\\d+)+!(?<quantity>[\\d+]+)\\b");

          while(!"Purchase".equals(input = reader.readLine())){

              Matcher matcher = regex.matcher(input);
              if(matcher.find()){
                  String product = matcher.group("product");
                  double price = Double.parseDouble(matcher.group("price"));
                  double quantity = Double.parseDouble(matcher.group("quantity"));
                  products.add(product);
                  sum +=(price * quantity);
              }



          }
         System.out.println("Bought furniture:");

          products.forEach(e -> System.out.println(e));
         System.out.println(String.format("Total money spend: %.2f", sum));
      }
}
