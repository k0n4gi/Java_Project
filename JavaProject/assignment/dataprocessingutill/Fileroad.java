package dataprocessingutill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;

public class Fileroad {
	public static ArrayList<String> getArryStringByFilePath(String path) throws Exception {
		// file 객체 생성
		File file = new File(path);
		// 생성된 파일 읽는 객체 생성
		FileReader file_reader = new FileReader(file);
		// 읽는 파일 객체를 담을 버퍼 생성
		BufferedReader buffer_reader = new BufferedReader(file_reader);
		// ArrayList<String>으로 받을 lines 객체 생성
		ArrayList<String> lines = new ArrayList<String>();
		String line = "";

		// 버퍼로 받은 값이 없을때까지 반복
		while ((line = buffer_reader.readLine()) != null) {
			// lines에 값을 삽입
			lines.add(line);
		}
		// 버퍼를 닫기
		buffer_reader.close();
		// 받은 lines값을 반환
		return lines;
	}

}
