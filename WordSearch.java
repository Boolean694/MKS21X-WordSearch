public class WordSearch {
	private char[][] data;
	private int rc;
	private int cc;
	public WordSearch(int rows, int columns) {
		data = new char[rows][columns];
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				data[q][w] = '_';
			}
		}
		rc = rows;
		cc = columns;
	}
	
	private void clear() {
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				data[q][w] = '_';
			}
		}
	}
	
	public String toString() {
		String s = "";
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				s += data[q][w];
				s += " ";
			}
			s += "\n";
		}
		return s;
	}
	
	public boolean addWordHorizontal(int r, int c, String w) {
		if(r >= rc || c >= cc) {return false;}
		if(w.length() + c > cc) {return false;}
		for(int q = c; q < w.length() + c; q++) {
			if(data[r][q] != '_') {
				if(w.charAt(q - c) == data[r][q]) {
					q += 0;
				}
				else {
					return false;
				}
			}
		}
		for(int co = c; co < w.length() + c; co++) {
			data[r][co] = w.charAt(co - c);
		}
		return true;
	}
	
	public boolean addWordVertical(int r, int c, String w) {
		if(r >= rc || c >= cc) {return false;}
		if(w.length() + r > rc) {return false;}
		for(int q = r; q < w.length() + r; q++) {
			if(data[q][c] != '_') {
				if(w.charAt(q - r) == data[q][c]) {
					q += 0;
				}
				else {
					return false;
				}
			}
		}
		for(int ro = r; ro < w.length() + r; ro++) {
			data[ro][c] = w.charAt(ro - r);
		}
		return true;
	}
}