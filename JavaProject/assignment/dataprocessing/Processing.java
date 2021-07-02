package dataprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import dataprocessingutill.Fileroad;

public class Processing {

	private final static String PATH = "C:\\Users\\user\\Desktop\\학생공유\\데이터가공\\data.txt";

	public static void main(String[] args) {
		try {
			List<String> lines = Fileroad.getArryStringByFilePath(PATH);

			List<HashMap> hmList = new ArrayList<>();

			for (String line : lines) {
				boolean contain = false;
				for (HashMap hm : hmList) {
					if (hm.get("line").toString().equals(line)) {
						int count = Integer.valueOf(hm.get("count").toString());
						hm.put("count", ++count);
						contain = true;
						break;
					}
				}
				if (!contain) {
					HashMap hm = new HashMap<>();
					hm.put("count", 0);
					hm.put("line", line);
					hmList.add(hm);
				}
			}
			LinkedHashSet<String> hashSet = new LinkedHashSet<>();
			for (String overlap : lines) {
				hashSet.add(overlap);
			}

			Iterator it = hashSet.iterator();
			List<String> lineList = new ArrayList<String>();
			while (it.hasNext()) {
				lineList.add(it.next().toString());
			}

			for (int i = 0; i < lineList.size(); i++) {
				//int idx = lines.indexOf(";");
				//lines.set(i, lines.get(i).substring(0,idx));
				lines.set(i, lines.get(i).replaceAll("> _test_CTF_", ""));
				lines.set(i, lines.get(i).replaceAll("\s", ""));
			}

			for (int i = 0; i < lineList.size(); i++) {
				String txt = lineList.get(i);
				int count = countChar(txt, '1');
				String head = "";
				if (count % 2 == 1) {
					head = "a";
				} else if (count % 2 == 0) {
					head = "b";
				}
				String countStr = "";
				for (HashMap hm : hmList) {
					if (hm.get("line").toString().equals(txt)) {
						countStr = hm.get("count").toString().replace("0", "");
						break;
					}
				}
				System.out.println(head + countStr + " " + txt);
			}

		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int countChar(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

}
