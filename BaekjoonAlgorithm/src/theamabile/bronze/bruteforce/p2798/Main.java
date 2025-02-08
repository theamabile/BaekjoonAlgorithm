package theamabile.bronze.bruteforce.p2798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Number 
 *
 */
public class Main {
	private static int n = 0;	 		// 카드 개수
	private static int m = 0;   		// 기준값
	private static int[] cards = null;	// 입력 받은 카드 숫자
	private static int result = 0;
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		boolean lastInput = false;
		
		while( (input = br.readLine()) != null ) {
			if( !lastInput ) {
				String[] inputs = input.split(" ");
				n = Integer.parseInt(inputs[0]);
				m = Integer.parseInt(inputs[1]);
				lastInput = true;
			} else {
				String[] inputs = input.split(" ");					
				cards = new int[n];
				int i=0;
				for( String str : inputs ) {
					cards[i++] = Integer.parseInt(str);						
				}					
				break;
			}	
		}
		
		if( br != null)  br.close();
	}	
	
	public static void calc() {
		int num = 0;		// 반복 시 세 수의 합
		
		for( int i=0 ; i<n-2 ; i++ ) {   // 첫번째카드
			for( int j=i+1 ; j<n-1 ; j++ ) {    // 두번째카드
				for( int k=j+1 ; k<n ; k++ ) {   // 세번째카드
					num = cards[i] + cards[j] + cards[k];
					
					// 출력조건 : 첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
					if( num > m) {
						continue;
					} else {
						if( Math.abs(m-result) > Math.abs(m-num) ) {
							result = num;
						}
					}					
				}
			}
		}	
	}
	
	public static void main(String[] args) throws Exception {

		// 1. 입력값 초기화
		init();

		// 2. 완전 탐색으로 찾기
		calc();
	
		// 3. 출력
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		bw.write( String.valueOf(result) );
		bw.flush();
		if( bw != null)  bw.close();
	}
}
