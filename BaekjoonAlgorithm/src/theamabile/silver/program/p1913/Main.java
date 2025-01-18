package theamabile.silver.program.p1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이, 실버 3
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
		 * 좌표 x,y 선언
		 * 
		 * 아래>오른쪽>위>왼쪽의 반복
		 * 회전 회차 선언
		 * 회전 회차가 1(아래), 2(오른쪽), 3(위), 4(왼)
		 *  - 1(아래) : x고정, y증가 --> y<n일때까지
		 *  - 2(오른쪽) : y고정, x증가  --> x<n일때까지
		 *  - 3(위) : x고정, y감소  --> y>=0일때까지
		 *  - 4(왼) : y고정, x감소  --> x>=0일때까지
		 * 
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 입력
		int n = Integer.parseInt(br.readLine());		// 전구 갯수
		int m = Integer.parseInt(br.readLine());		// 명령어 갯수
		
		int square = n*n;
		int[][] arr = new int[n][n]; 
		
		// 특정 숫자 위치(결과값)
		int rX = 0;
		int rY = 0;		

		// 연산을 위한 변수 선언ㄴ
		int direction = 1;
		int x=0;
		int y=0;
		
		// 회차가 지날 수록 꼭지점 포지션이 계속 바뀌니까.
		int startX = 0;
		int endX = n-1;
		int startY = 0;
		int endY = n-1;
		
		for(int i=square ; i>0 ; i--) {	
			if(i == m) {
				rY = y;
				rX = x;
			}
			arr[y][x] = i; 		
			
			switch(direction) {
			case 1:   /** 1(아래) : x고정, y증가 --> y<n일때까지 **/		
				// 마지막꺼까지 넣고 디렉션을 바꿔주면, 디렉션 바꿔줄때 좌표 보정 해줘야함
				if( y == endY) {
					direction = (direction%4)+1;
					x++;			// 다음 방향이 오른쪽이라서 오른쪽 시작 인덱스로 보정해줌
					startX += 1;	// 왼쪽 한줄이 사라졌으니까
				} else {
					y++;
				}
				break;
			case 2:   /** 2(오른쪽) : y고정, x증가  --> x<n일때까지 **/
				// 마지막꺼까지 넣고 디렉션을 바꿔주면, 디렉션 바꿔줄때 좌표 보정 해줘야함
				if( x == endX) {
					direction = (direction%4)+1;
					y--;			// 다음 방향이 위쪽이라서 위쪽 시작 인덱스로 보정해줌
					endY -= 1; 		// 아래쪽 한줄이 사라졌으니까
				} else {
					x++;
				}
				break;
			case 3:   /** 3(위) : x고정, y감소  --> y>=0일때까지 **/				
				// 마지막꺼까지 넣고 디렉션을 바꿔주면, 디렉션 바꿔줄때 좌표 보정 해줘야함
				if( y == startY) {
					direction = (direction%4)+1;
					x--;			// 다음 방향이 왼쪽이라서 왼쪽 시작 인덱스로 보정해줌
					endX -= 1;		// 오른쪽 한줄이 사라졌으니까
				} else {
					y--;
				}
				break;
			case 4:   /** 4(왼) : y고정, x감소  --> x>=0일때까지 **/	
				// 마지막꺼까지 넣고 디렉션을 바꿔주면, 디렉션 바꿔줄때 좌표 보정-1 해줘야함
				if( x == startX) {
					direction = (direction%4)+1;
					y++;			// 다음 방향이 왼쪽이라서 왼쪽 시작 인덱스로 보정해줌
					startY += 1;    // 위쪽 한줄이 사라졌으니까
				} else {
					x--;
				}
				break;
			}
			
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for( int i=0 ; i<n ; i++) {
			for( int j=0 ; j<n ; j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
			}			
			if(i < n-1) {
				sb.append("\n");
			}
		}
		
		// 특정숫자 위치 출력
		System.out.println(sb.toString());
		System.out.printf("%d %d", (rY+1), (rX+1));
	}
}
