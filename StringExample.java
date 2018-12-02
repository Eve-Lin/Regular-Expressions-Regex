
public class StringExample {
public static void main(String args[]) {
	
	String s1 = "apple, apple, and orange please";
	
	String[] parts = s1.split("\\b");
	
	System.out.println(parts[0]);

	for(String thePart:parts)
		
		if(thePart.matches("\\w+")){
			
			System.out.println(thePart);
		}
}
}
