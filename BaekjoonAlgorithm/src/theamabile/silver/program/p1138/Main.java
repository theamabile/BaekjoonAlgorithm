package theamabile.silver.program.p1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 1. 입력 받기
		 * */
		int n = Integer.parseInt( br.readLine() );				// 사람 수
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt( st.nextToken() );					// 최대 정원
		}

		// 출력 : 줄선 순서 배열
		int[] result = new int[n];

		int cnt = 0;
		for( int i=0 ; i<n ; i++) {
			cnt = 0;		// 사람 바뀔 때 마다 초기화		
			
			/**
			 *  5
			 *  cnt=1 / j=0 / i=1
			 *     1 2 3 4 5
				a: 2 1 0 1 0
				r: 0 2 1 0 0
								 
			 * */						
			for( int j=0 ; j<n ; j++) {
				if( arr[i] == cnt ) {  		// 1. 내 앞에 서있어야 하는 수가 모두 맞는지 확인(키큰 애들 다 카운팅 됐는지)						
					// 이미 줄 선 사람이 있으면 내가 뒤로간다(줄 선 사람보다 내가 더 큼)
					if( result[j] != 0 ) {
						continue;
					}
					
					result[j] = i+1;
					break;
				} else {  		//
					// 아직 키큰 사람이 셋팅이 안되어서 비교가 불가능 (result j번째가 0) 이거나
					// 자리에 선 사람이 나보다 키가 크면 cnt 증가
					if( result[j] == 0 || result[j] > (i+1) )
						cnt++;
				}				
			}			
		}		

		for( int i=0 ; i<n ; i++) {
			System.out.printf("%d ", result[i]);
		}
	}

}
