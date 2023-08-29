import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원 수
		
		// 학년별 성별 배열 만들기
		// 성별은 2가지(0:여, 1:남) 학년은 6가지
		int[][] arr = new int[2][7];
		
		
		// 해당 성별과 학년에 맞는 인덱스에 카운트 증가 
		for(int n=0; n<N; n++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			arr[gender][grade]++;
		}
		
		int res = 0;
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<7; j++) {
				res += (arr[i][j]+1)/2;
			}
		}
		
		System.out.println(res);
		
	}

}
