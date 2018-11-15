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
	private boolean ky;
	
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
		seed = (int)time % 100000;
		rnum = new Random(seed);
		
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
		ky = false;
	}
	
	public WordSearch(int rows, int columns, String fileN, int sd) throws FileNotFoundException{
		this(rows, columns, fileN);
		seed = sd;
		rnum = new Random(seed);
	}
	
	public WordSearch(int rows, int columns, String fileN, int sd, String key) throws FileNotFoundException{
		this(rows, columns, fileN);
		seed = sd;
		rnum = new Random(seed);
		ky = (key == "key");
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
	
	private boolean addWord(String w) {
		int rw = rnum.nextInt(rc);
		int cl = rnum.nextInt(cc);
		int x = rnum.nextInt(3) - 1;
		int y = rnum.nextInt(3) - 1;
		if(x == 0 && y == 0) {
			if(rnum.nextInt(2) == 0) {
				if(rnum.nextInt(2) == 0) {
					y++;
				}
				else {
					y--;
				}
			}
			else {
				if(rnum.nextInt(2) == 0) {
					x++;
				}
				else{x--;}
			}
		}
		if(rc <= w.length() + rw || cc <= w.length() + cl){return false;}
		int rco = rw;
		int cco = cl;
		for(int q = 0; q < w.length(); q++) {
			if(data[rco][cco] != '_') {
				if(data[rco][cco] == w.charAt(q)){q += 0;}
				else{return false;}
			}
			rco++;
			cco++;
		}
		int srco = rw;
		int scco = cl;
		for(int qe = 0; qe < w.length(); qe++) {
			data[srco][scco] = w.charAt(qe);
			srco++;
			scco++;
		}
		return true;
	}
	
	private String alSt(ArrayList<String> a) {
		String s = "";
		for(int q = 0; q < a.size(); q++) {
			s += a.get(q);
			s += ", ";
		}
		return s;
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
		s += "Words: " + alSt(wtu);
		s += "Seed: " + seed;
		return s;
	}
	
	public static void main(String[] args) {
		try {
			int argsl = args.length;
			if(argsl < 3){System.out.println("You must specify at least the number of rows, number of columns, and file name.");}
			Integer.parseInt(args[0]);
		}
		catch(Exception e) {System.out.println("Format should be: int, int, string,..."); System.exit(1);}
	}
	
	
}