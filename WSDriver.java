public class WSDriver {
	public static void main(String[] args) {
		WordSearch nw = new WordSearch(5,6);
		System.out.println(nw.toString());
		System.out.println(nw.addWordHorizontal("WORD", 3, 2));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical("FORT", 0, 1));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical("TWO", 1, 3));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical("TWO", 1, 4));
		nw.clear();
		System.out.println(nw.addWordHorizontal("FORTNITE", 0, 0));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical("TOKYO", 0, 4));
		System.out.println(nw.addWordDiagonal("METRO", 0, 0));
		System.out.println(nw.toString());
	}
}