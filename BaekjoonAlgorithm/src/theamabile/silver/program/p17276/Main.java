package theamabile.silver.program.p17276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcaseCnt = Integer.parseInt( br.readLine() );	
		
		int angle = 0;
		int rotationCnt = 0;
		for( int i=0 ; i<testcaseCnt ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt( st.nextToken() );	
			angle = Integer.parseInt( st.nextToken() );	

			arr = new int[N][N];
			for(int j=0 ; j<N ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0 ; k<N ; k++) {
					arr[j][k] = Integer.parseInt( st.nextToken() );	
				}
			}
									
			rotationCnt = 0;
			
			if(angle < 0) {
				rotationCnt = (angle * -1)/45;
				for(int k=0 ; k<rotationCnt ; k++) {
					leftRotation();
				}
			} else if( angle != 360 ) {
				rotationCnt = angle/45;
				for(int k=0 ; k<rotationCnt ; k++) {
					rightRotation();
				}
			}
			
			printArr();
						
		}
	}
	

	/**
	 *  X�� �� �밢���� ((1,1), (2,2), ��, (n, n)) ��� ��  ((n+1)/2 ��° ��)�� �ű��.
		X�� ��� ���� X�� �� �밢������ ((n, 1), (n-1, 2), ��, (1, n)) �ű��. 
		X�� �� �밢���� X�� ��� �� ((n+1)/2��° ��)���� �ű��.
		X�� ��� ���� X�� �� �밢������ �ű��.
		�� �� ���� ��� ��� ������ ���� ������ ���� �Ǿ�� �Ѵ�.
		X�� �ٸ� ������ ��ġ�� ������ �ʴ´�.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * */
	
	/**
	 * �ݽð����(����)���� 45�� ������ �޼ҵ�
	 * */
	public static void leftRotation() {
		
		int[][] result = new int[N][N];
		
		// \ �밢��(���� ��->������ �Ʒ�) > �� ����
		for(int i=0 ; i<N ; i++) {
			result[N/2][i] = arr[i][i];			
		}
		
		// / �밢��(������ ��->���� �Ʒ�) > | ����
		for(int i=0 ; i<N ; i++) {
			result[i][N/2] = arr[i][N-1-i];
		}
		
		// | ���� > \ �밢��(���� ��->������ �Ʒ�)
		for(int i=0 ; i<N ; i++) {
			result[i][i] = arr[i][N/2];
		}
		 
		// �� ���� > / �밢��(������ ��->���� �Ʒ�) 
		for(int i=0 ; i<N ; i++) {
			result[N-1-i][i] = arr[N/2][i];			
		}	
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if( result[i][j] == 0) {
					result[i][j] = arr[i][j];
				}
			}
		}
		
		arr = result;
	}
	
	/**
	 * �ð����(������)���� 45�� ������ �޼ҵ�
	 * */
	public static void rightRotation() {
		int[][] result = new int[N][N];
		
		// \ �밢��(���� ��->������ �Ʒ�) > | ����
		for(int i=0 ; i<N ; i++) {
			result[i][N/2] = arr[i][i];
		}
		
		// / �밢��(������ ��->���� �Ʒ�) > �� ����
		for(int i=0 ; i<N ; i++) {
			result[N/2][N-1-i] = arr[i][N-1-i];	
		}		
		
		// | ���� > / �밢��(������ ��->���� �Ʒ�)
		for(int i=0 ; i<N ; i++) {
			result[i][N-1-i] = arr[i][N/2];
		}
		 
		// �� ���� > \ �밢��(���� ��->������ �Ʒ�)
		for(int i=0 ; i<N ; i++) {
			result[i][i] = arr[N/2][i];			
		}	

		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if( result[i][j] == 0) {
					result[i][j] = arr[i][j];
				}
			}
		}
		arr = result;
	}
	
	
	/**
	 * �迭 ���
	 */
	public static void printArr() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				sb.append(arr[i][j]).append(" ");
				//System.out.printf("%d ",arr[i][j]);
			}
			//System.out.println();
			if( i<N-1 ) {
				sb.append("\n");				
			}
		}
		System.out.println(sb.toString());
	}
}
