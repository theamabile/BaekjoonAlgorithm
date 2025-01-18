package theamabile.silver.program.p1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ������, �ǹ� 3
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
		 * ��ǥ x,y ����
		 * 
		 * �Ʒ�>������>��>������ �ݺ�
		 * ȸ�� ȸ�� ����
		 * ȸ�� ȸ���� 1(�Ʒ�), 2(������), 3(��), 4(��)
		 *  - 1(�Ʒ�) : x����, y���� --> y<n�϶�����
		 *  - 2(������) : y����, x����  --> x<n�϶�����
		 *  - 3(��) : x����, y����  --> y>=0�϶�����
		 *  - 4(��) : y����, x����  --> x>=0�϶�����
		 * 
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// �Է�
		int n = Integer.parseInt(br.readLine());		// ���� ����
		int m = Integer.parseInt(br.readLine());		// ��ɾ� ����
		
		int square = n*n;
		int[][] arr = new int[n][n]; 
		
		// Ư�� ���� ��ġ(�����)
		int rX = 0;
		int rY = 0;		

		// ������ ���� ���� ����
		int direction = 1;
		int x=0;
		int y=0;
		
		// ȸ���� ���� ���� ������ �������� ��� �ٲ�ϱ�.
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
			case 1:   /** 1(�Ʒ�) : x����, y���� --> y<n�϶����� **/		
				// ������������ �ְ� �𷺼��� �ٲ��ָ�, �𷺼� �ٲ��ٶ� ��ǥ ���� �������
				if( y == endY) {
					direction = (direction%4)+1;
					x++;			// ���� ������ �������̶� ������ ���� �ε����� ��������
					startX += 1;	// ���� ������ ��������ϱ�
				} else {
					y++;
				}
				break;
			case 2:   /** 2(������) : y����, x����  --> x<n�϶����� **/
				// ������������ �ְ� �𷺼��� �ٲ��ָ�, �𷺼� �ٲ��ٶ� ��ǥ ���� �������
				if( x == endX) {
					direction = (direction%4)+1;
					y--;			// ���� ������ �����̶� ���� ���� �ε����� ��������
					endY -= 1; 		// �Ʒ��� ������ ��������ϱ�
				} else {
					x++;
				}
				break;
			case 3:   /** 3(��) : x����, y����  --> y>=0�϶����� **/				
				// ������������ �ְ� �𷺼��� �ٲ��ָ�, �𷺼� �ٲ��ٶ� ��ǥ ���� �������
				if( y == startY) {
					direction = (direction%4)+1;
					x--;			// ���� ������ �����̶� ���� ���� �ε����� ��������
					endX -= 1;		// ������ ������ ��������ϱ�
				} else {
					y--;
				}
				break;
			case 4:   /** 4(��) : y����, x����  --> x>=0�϶����� **/	
				// ������������ �ְ� �𷺼��� �ٲ��ָ�, �𷺼� �ٲ��ٶ� ��ǥ ����-1 �������
				if( x == startX) {
					direction = (direction%4)+1;
					y++;			// ���� ������ �����̶� ���� ���� �ε����� ��������
					startY += 1;    // ���� ������ ��������ϱ�
				} else {
					x--;
				}
				break;
			}
			
		}
		
		// ���
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
		
		// Ư������ ��ġ ���
		System.out.println(sb.toString());
		System.out.printf("%d %d", (rY+1), (rX+1));
	}
}
