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
	
	public WordSearch(int rows, int columns, String fileN, int sd, String key) throws FileNotFoundException{
		data = new char[rows][columns];
		long time = System.currentTimeMillis();
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				data[q][w] = ' ';
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
		if(sd == 0) {seed = (int)time % 100000;} else{seed = sd;}
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
		ky = (key.equals("key"));
		this.addAllWords();
	}
	
	public void clear() {
		for(int q = 0; q < data.length; q++) {
			for(int w = 0; w < data[q].length; w++) {
				data[q][w] = ' ';
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
		
		if(rw + (w.length() * x) < 0 || rw + (x * w.length()) >= rc || cl + (y * w.length()) < 0 || cl + (y * w.length()) >= cc) {return false;}
		int rco = rw;
		int cco = cl;
		for(int q = 0; q < w.length(); q++) {
			if(data[rco][cco] != ' ') {
				if(data[rco][cco] == w.charAt(q)){q += 0;}
				else{return false;}
			}
			rco += x;
			cco += y;
		}
		int srco = rw;
		int scco = cl;
		for(int qe = 0; qe < w.length(); qe++) {
			data[srco][scco] = w.charAt(qe);
			srco += x;
			scco += y;
		}
		return true;
	}
	
	private void addAllWords() {
		String wd = "";
		while(wtu.size() > 0) {
			wd = wtu.remove(rnum.nextInt(wtu.size()));
			wau.add(wd);
			int cnt = 0;
			boolean tempb = false;
			while(cnt < 2000 && !tempb) {
				tempb = this.addWord(wd);
				cnt++;
			}
			if(!tempb) {
				while(cnt < 2000 && !tempb) {
					tempb = this.addWord(wd);
					cnt++;
				}
			}
		}
		if(!ky) {
			for(int q = 0; q < data.length; q++) {
				for(int qe = 0; qe < data[q].length; qe++) {
					if(data[q][qe] == ' ') {
						data[q][qe] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(rnum.nextInt(26));
					}
					else{
						q += 0;
					}
				}
			}
		}
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
		s += "Words: " + alSt(wau);
		s += "Seed: " + seed;
		return s;
	}
	
	public static void main(String[] args) {
		try {
			int argsl = args.length;
			int thisr = Integer.parseInt(args[0]);
			int thisc = Integer.parseInt(args[1]);
			String thisfile = args[2];
			WordSearch nws;
			if(argsl == 3) {
				nws = new WordSearch(thisr, thisc, thisfile, 0, "a");
			}
			else if(argsl == 4) {
				nws = new WordSearch(thisr, thisc, thisfile, Integer.parseInt(args[3]), "a");
			}
			else if(argsl == 5) {
				nws = new WordSearch(thisr, thisc, thisfile, Integer.parseInt(args[3]), args[4]);
			}
			else {
				int sfsdfsdfsdfsdfd = Integer.parseInt("b");
				nws = new WordSearch(1, 1, "whatever", 0, "");
			}
			
			System.out.println(nws.toString());
		}
		catch(Exception e) {System.out.println("Format should be: int NumberOfRows, int NumberOfColumns, String FileName, optional stuff"); System.exit(1);}
	}
	
	
}