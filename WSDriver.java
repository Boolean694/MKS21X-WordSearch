import java.io.FileNotFoundException;


public class WSDriver {
	public static void main(String[] args) {
		try{
			WordSearch nw = new WordSearch(5,6,"words.txt");
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found: " /* + nw.printFileN()*/);
			System.exit(1);
		}
	}
}