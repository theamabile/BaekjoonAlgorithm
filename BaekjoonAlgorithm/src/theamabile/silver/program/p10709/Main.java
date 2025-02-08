package theamabile.silver.program.p10709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int n = Integer.parseInt(st.nextToken());		// 행
		int m = Integer.parseInt(st.nextToken());		// 열
		
		int[][] arr = new int[n][m]; 	
		
		char[] inputLine = null;
		char input;
		for(int i=0 ; i<n ; i++) {
			inputLine = br.readLine().toCharArray();
			for(int j=0 ; j<m ; j++) {
				input = inputLine[j];
				if( input == 'c') { // 처음부터 구름이 입력 된 경우
					arr[i][j] = 0;
				} else {
					arr[i][j] = -1;	// 구름이 들어온 자리가 아니면 -1로 셋팅
				}
			}	
		}

//		for(int i=0 ; i<n ; i++) {
//			for(int j=0 ; j<m ; j++) {
//				System.out.printf("%d ", arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("================");
	
		
		int arrTime = 0;
		for(int i=0 ; i<n ; i++) {
			arrTime = 0;	// 한줄마다 초기화
			for(int j=0 ; j<m ; j++) {
				if( arr[i][j] == 0 ) { // 구름 자리
					if(arrTime != 1) {	// 이번 줄에서 구름을 처음 만남
						arrTime = 1;	
					} 
				} else if( arr[i][j] == -1 ) {
					if(arrTime >= 1) {  // 앞에 구름을 만난 적 있음. 시간 셋팅.
						arr[i][j] = arrTime++;
					}
				}
			}	
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}
	}

}
