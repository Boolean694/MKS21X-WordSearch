public class WSDriver {
	public static void main(String[] args) {
		WordSearch nw = new WordSearch(5,6);
		System.out.println(nw.toString());
		System.out.println(nw.addWordHorizontal(3, 2, "WORD"));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical(0, 1, "FORT"));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical(1, 3, "TWO"));
		System.out.println(nw.toString());
		System.out.println(nw.addWordVertical(1, 4, "TWO"));
	}
}