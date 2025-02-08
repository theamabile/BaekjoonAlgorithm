package theamabile.silver.program.p10709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �Է�
		int n = Integer.parseInt(st.nextToken());		// ��
		int m = Integer.parseInt(st.nextToken());		// ��
		
		int[][] arr = new int[n][m]; 	
		
		char[] inputLine = null;
		char input;
		for(int i=0 ; i<n ; i++) {
			inputLine = br.readLine().toCharArray();
			for(int j=0 ; j<m ; j++) {
				input = inputLine[j];
				if( input == 'c') { // ó������ ������ �Է� �� ���
					arr[i][j] = 0;
				} else {
					arr[i][j] = -1;	// ������ ���� �ڸ��� �ƴϸ� -1�� ����
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
			arrTime = 0;	// ���ٸ��� �ʱ�ȭ
			for(int j=0 ; j<m ; j++) {
				if( arr[i][j] == 0 ) { // ���� �ڸ�
					if(arrTime != 1) {	// �̹� �ٿ��� ������ ó�� ����
						arrTime = 1;	
					} 
				} else if( arr[i][j] == -1 ) {
					if(arrTime >= 1) {  // �տ� ������ ���� �� ����. �ð� ����.
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
