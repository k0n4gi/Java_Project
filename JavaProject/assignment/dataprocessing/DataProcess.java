package dataprocessing;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataProcess {
	private static final String PATH = "C:\\Users\\user\\Desktop\\학생공유\\데이터가공\\data.txt";

	
	/**
	 * 1. file list<string>으로 불러오기
	 * 2. 불러온 text의 정보를 저장할 객체 리스트를 생성
	 * 3. 불러온 text list를 검사한 뒤 새로운 값이면 객체를 리스트에 추가
	 * 4. 불러온 값이 이미 있으면 카운트를 증가
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> fileTxtList = new ArrayList<String>();
		try {
			fileTxtList = getArrayStringByFilePath(PATH);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		ArrayList<Data> dataList = new ArrayList<Data>();
		for(String txt : fileTxtList) {
			int idx = txt.indexOf(";");
			String re = txt.substring(0,idx).replaceAll("(> _test_CTF_)", "").replaceAll("\s","");
			boolean contain = false;
			for(Data data : dataList) {
				if(data.getTxt().equals(re)) {
					data.setCount(data.getCount() + 1);
					contain = true;
					break;
				}
			}
			
			if(!contain) {
				Data data = new Data();
				data.setCount(0);
				data.setTxt(re);
				String head = "a";
				int count = 0;
				for(int i = 0; i < txt.length() ; i++) {
					if(txt.charAt(i) == '1' ){
						count++;
					}
				}
				if(count % 2 == 0) {
					head = "b";
				}
				data.setHead(head);
				dataList.add(data);
			}
		}

		for(Data data : dataList) {

			System.out.println(data.getHead() + (data.getCount() > 0 ? data.getCount() : "") + " " + data.getTxt());
		}
	}
	
	public static ArrayList<String> getArrayStringByFilePath(String path) throws Exception{
		ArrayList<String> resultList = new ArrayList<String>();
		File file = new File(path);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			resultList.add(sc.nextLine());
		}
		return resultList;
	}
}
