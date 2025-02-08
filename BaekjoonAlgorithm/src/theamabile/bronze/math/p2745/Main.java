package theamabile.bronze.math.p2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String input = st.nextToken();			// 10진법으로 변환할 숫자
		double beforeFormat = Double.parseDouble(st.nextToken());	// 변환 전 진법
				
		char num;
		int sum = 0;
		double value = 0;	// 자리수 보정을 위한 변수
		
		int digit = 0;
		for( int i=0 ; i<input.length() ; i++) {
			num = input.charAt(input.length()-1-i);
			if( Character.isDigit(num) ) {		
				digit = Integer.parseInt( String.valueOf(num) ); // 숫자가 입력됨
			} else {	
				digit = (int)num - 55;  // 문자가 입력됨. 문자의 아스키코드에서=12=55를 빼면됨	
			}
			
			value = Math.pow(beforeFormat, i);		// 자리수 보정값			
			sum += (int)(digit * value);
		}
		System.out.println( sum );
		
		if(br != null) br.close();
	}

}