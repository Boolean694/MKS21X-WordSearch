import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Random;

public class WordSearch {
	
	private char[][] data;
	private int rc;
	private int cc;
	private String file;
	private String fileName;
	private int seed;
	private Random rnum;
	private ArrayList<String> wtu;
	private ArrayList<String> wau;
	
	public WordSearch(int rows, int columns, String fileN) throws FileNotFoundException{
		data = new char[rows][columns];
		long time = System.currentTimeMillis();
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				data[q][w] = '_';
			}
		}
		rc = rows;
		cc = columns;
		fileName = fileN;
		File f = new File(fileN);
		Scanner in = new Scanner(f);
		file = "";
		String l = "";
		while(in.hasNext()) {
			l = in.nextLine();
			file += l;
			file += "\n";
		}
		seed = (int)time;
		rnum = new Random(time);
		
		wau = new ArrayList<String>();
		wtu = new ArrayList<String>();
		String fplhc = "";
		for(int qwert = 0; qwert < file.length(); qwert++) {
			if(file.charAt(qwert) == '\n'){
				wtu.add(fplhc);
				fplhc = "";
			}
			else {
				fplhc += String.valueOf(file.charAt(qwert));
			}
		}
	}
	
	public WordSearch(int rows, int columns, String fileN, int sd) throws FileNotFoundException{
		this(rows, columns, fileN);
		seed = sd;
		rnum = new Random(sd);
	}
	
	public void printFile() {
		System.out.println(file);
	}
	
	public void clear() {
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				data[q][w] = '_';
			}
		}
	}
	
	
	public String toString() {
		String s = "";
		for(int q = 0; q < data.length; q++) {
			s += "|";
			for(int w = 0; w < data[q].length; w++) {
				s += data[q][w];
				s += " ";
			}
			s += "|";
			s += "\n";
		}
		return s;
	}
	
	public boolean addWordHorizontal(String w, int r, int c) {
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
	
	public boolean addWordVertical(String w, int r, int c) {
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
	
	public boolean addWordDiagonal(String w, int r, int c) {
		if(r >= rc || c >= cc) {return false;}
		
		if(w.length() + r > rc || w.length() + c > cc) {return false;}
		int lrc = r;
		int lcc = c;
		for(int q = 0; q < w.length(); q++) {
			if(data[lrc][lcc] != '_') {
				if(w.charAt(q) == data[lrc][lcc]) {
					q += 0;
				}
				else {
					return false;
				}
			}
			lrc++;
			lcc++;
		}
		int slrc = r;
		int slcc = c;
		for(int a = 0; a < w.length(); a++) {
			data[slrc][slcc] = w.charAt(a);
			slrc++;
			slcc++;
		}
		return true;
	}
	
	
}