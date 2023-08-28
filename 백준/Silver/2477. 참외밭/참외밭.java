import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cham = sc.nextInt(); // 참외 수
		
		int[][] arr = new int[6][2];
		
		// 2차원 배열에 값 넣기
		for(int r=0; r<6; r++) {
			arr[r][0] = sc.nextInt();
			arr[r][1] = sc.nextInt();
		}
		
		// 가로, 세로 최댓값 찾기
		int max1 = 0;
		int max2 = 0;
		
		int idx1 = 0;
		int idx2 = 0;
		
		for(int r=0; r<6; r++) {
			if(r%2 == 0) {
				if(arr[r][1] > max1) {
					max1 = arr[r][1];
					idx1 = r;
				}
			}else {
				if(arr[r][1] > max2) {
					max2 = arr[r][1];
					idx2 = r;
				}
			}
		}
		
		int min1 = 0;
		int min2 = 0;
		
		min1 = arr[(idx1+3)%6][1];
		min2 = arr[(idx2+3)%6][1];

		
		int area = (max1*max2)-(min1*min2);
		System.out.println(area*cham);

		
	}

}
