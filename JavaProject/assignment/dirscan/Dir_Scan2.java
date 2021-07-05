package dirscan;

import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

public class Dir_Scan2 {
	private static int sNumber = 0;
	public static void findAllFilesInFolder(File folder) {
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				try {
					Scanner sc = new Scanner(file);
					while(sc.hasNext()) {
						sNumber += sc.nextInt();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				findAllFilesInFolder(file);
			}
		}
	}
	
	public static void main(String[] args) throws ParseException {
		File folder = new File("filepath");
		findAllFilesInFolder(folder);
		System.out.println("count : " + sNumber);
	
	}
}