package theamabile.silver.program.p1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 1. �Է� �ޱ�
		 * */
		int n = Integer.parseInt( br.readLine() );				// ��� ��
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt( st.nextToken() );					// �ִ� ����
		}

		// ��� : �ټ� ���� �迭
		int[] result = new int[n];

		int cnt = 0;
		for( int i=0 ; i<n ; i++) {
			cnt = 0;		// ��� �ٲ� �� ���� �ʱ�ȭ		
			
			/**
			 *  5
			 *  cnt=1 / j=0 / i=1
			 *     1 2 3 4 5
				a: 2 1 0 1 0
				r: 0 2 1 0 0
								 
			 * */						
			for( int j=0 ; j<n ; j++) {
				if( arr[i] == cnt ) {  		// 1. �� �տ� ���־�� �ϴ� ���� ��� �´��� Ȯ��(Űū �ֵ� �� ī���� �ƴ���)						
					// �̹� �� �� ����� ������ ���� �ڷΰ���(�� �� ������� ���� �� ŭ)
					if( result[j] != 0 ) {
						continue;
					}
					
					result[j] = i+1;
					break;
				} else {  		//
					// ���� Űū ����� ������ �ȵǾ �񱳰� �Ұ��� (result j��°�� 0) �̰ų�
					// �ڸ��� �� ����� ������ Ű�� ũ�� cnt ����
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
