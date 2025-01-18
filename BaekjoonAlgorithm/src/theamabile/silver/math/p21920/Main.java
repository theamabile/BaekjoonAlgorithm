package theamabile.silver.math.p21920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// ���μ� ���, �ǹ� 4
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �Է�
		/**
		 * N : �Էµ� ���� ����
		 * ���� �ڿ��� N��
		 * X : ���� ����
		 * */



		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� ����
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		// ���� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���μ� �� ����
		int x = Integer.parseInt(br.readLine());

		double sum = 0;
		int cnt = 0;
		int gcdResult = 0;
		// ���μ� : �� ���� �ִ������� 1�� �� >> a�� b ������ �� �������� �ȵ�		
		for(int i=0; i<arr.length ; i++) {
			gcdResult = gcd(arr[i], x);
			if( gcdResult == 1) {
				sum += arr[i];
				cnt++;
			} 
		}
		
		// ���
		System.out.println(sum/cnt);
		
		if(br != null)  br.close();
		
	}
	
	// �ִ� �����
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
