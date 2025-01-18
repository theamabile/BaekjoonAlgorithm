package theamabile.silver.math.p21920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 서로소 평균, 실버 4
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		/**
		 * N : 입력될 수의 갯수
		 * 수열 자연수 N개
		 * X : 기준 숫자
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 숫자 갯수
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		// 수열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 서로소 비교 숫자
		int x = Integer.parseInt(br.readLine());

		double sum = 0;
		int cnt = 0;
		int gcdResult = 0;
		// 서로소 : 두 수의 최대공약수가 1인 수 >> a랑 b 나눴을 때 나눠지면 안됨		
		for(int i=0; i<arr.length ; i++) {
			gcdResult = gcd(arr[i], x);
			if( gcdResult == 1) {
				sum += arr[i];
				cnt++;
			} 
		}
		
		// 출력
		System.out.println(sum/cnt);
		
		if(br != null)  br.close();
		
	}
	
	// 최대 공약수
	public static int gcd(int x, int y) {
		int a = Math.max(x, y);
		int b = Math.min(x, y);
		
		if( a%b == 0 ) {
			return b;
		} else {
			return gcd(b, (a%b));
		}
	}
}
