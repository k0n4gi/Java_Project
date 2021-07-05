package dirscan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class Dir_Scan {
	// 전역 변수로 생성
	private static int result = 0;
	public static void main(String[] args) {
		// 경로 지정
		String strDirPath = "filepath";

		// 함수로 보내기
		ListFile(strDirPath);
		System.out.println(result);

	}

	private static void ListFile(String strDirPath) {
		
		// 경로를 받은 객체 생성
		File path = new File(strDirPath);
		// 객체를 배열로 받기
		File[] fList = path.listFiles();

		//int result = 0; > 재귀함수인데 값을 초기화해서 디렉토리가 끝나면서 값을 더 더하지않음
		// 파일리스트 길이만큼 반복
		for (int i = 0; i < fList.length; i++) {
			
			
			// 파일이라면 파일로 출력
			if (fList[i].isFile())
							
			try
			{
				// aReader은 fList의 경로를 받아 파일 읽기
				FileReader aReader = new FileReader(fList[i].getAbsolutePath());
				// aReader에서 읽은 경로를 버퍼에 담기
				BufferedReader aBufReader = new BufferedReader(aReader);
				
				// 버퍼에 담은 경로를 배열로 나열하기
				List<String> aLines = new ArrayList<String>();
				
				String aLine = "";
				
				// 버퍼안의 내용이 없을때까지 진행
				while((aLine = aBufReader.readLine()) !=null)
				{
					// 내용만 추가
					aLines.add(aLine);
				}
				// 버퍼 닫기
				aBufReader.close();
				
				
				
				// 해당 경로에 맞는 파일 값을 출력
				for(int j = 0; j < aLines.size(); j++)					
				{
					// 해당 경로와 해당 경로안의 값을 출력
					System.out.println(fList[i] + " > " + aLines.get(j));
					
					result += Integer.valueOf(aLines.get(j));
										
				}				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			// 디렉토리라면 파일을 호출하기 위해 재귀함수로 호출
			else if (fList[i].isDirectory())
				ListFile(fList[i].getPath()); 
		}
		//List<String> sum2 = new ArrayList<String>();
		
		//Integer.valueOf(sum2).add(sum);
		//System.out.print(result); > 디렉토리안에서 합한 값만 나옴
	}
}
