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
	 *  X의 주 대각선을 ((1,1), (2,2), …, (n, n)) 가운데 열  ((n+1)/2 번째 열)로 옮긴다.
		X의 가운데 열을 X의 부 대각선으로 ((n, 1), (n-1, 2), …, (1, n)) 옮긴다. 
		X의 부 대각선을 X의 가운데 행 ((n+1)/2번째 행)으로 옮긴다.
		X의 가운데 행을 X의 주 대각선으로 옮긴다.
		위 네 가지 경우 모두 원소의 기존 순서는 유지 되어야 한다.
		X의 다른 원소의 위치는 변하지 않는다.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * */
	
	/**
	 * 반시계방향(왼쪽)으로 45도 돌리는 메소드
	 * */
	public static void leftRotation() {
		
		int[][] result = new int[N][N];
		
		// \ 대각선(왼쪽 위->오른쪽 아래) > ㅡ 수평
		for(int i=0 ; i<N ; i++) {
			result[N/2][i] = arr[i][i];			
		}
		
		// / 대각선(오른쪽 위->왼쪽 아래) > | 수직
		for(int i=0 ; i<N ; i++) {
			result[i][N/2] = arr[i][N-1-i];
		}
		
		// | 수직 > \ 대각선(왼쪽 위->오른쪽 아래)
		for(int i=0 ; i<N ; i++) {
			result[i][i] = arr[i][N/2];
		}
		 
		// ㅡ 수평 > / 대각선(오른쪽 위->왼쪽 아래) 
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
	 * 시계방향(오른쪽)으로 45도 돌리는 메소드
	 * */
	public static void rightRotation() {
		int[][] result = new int[N][N];
		
		// \ 대각선(왼쪽 위->오른쪽 아래) > | 수직
		for(int i=0 ; i<N ; i++) {
			result[i][N/2] = arr[i][i];
		}
		
		// / 대각선(오른쪽 위->왼쪽 아래) > ㅡ 수평
		for(int i=0 ; i<N ; i++) {
			result[N/2][N-1-i] = arr[i][N-1-i];	
		}		
		
		// | 수직 > / 대각선(오른쪽 위->왼쪽 아래)
		for(int i=0 ; i<N ; i++) {
			result[i][N-1-i] = arr[i][N/2];
		}
		 
		// ㅡ 수평 > \ 대각선(왼쪽 위->오른쪽 아래)
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
	 * 배열 출력
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
