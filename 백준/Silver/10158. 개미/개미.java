import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt(); // 가로
		int H = sc.nextInt(); // 세로
		int x = sc.nextInt(); // 출발 x
		int y = sc.nextInt(); // 출발 y
		int t = sc.nextInt(); // 시간
		
		int R;
		int C;
		
		// t시간 후 x 찾기
		int tmpX = x + t%(2*W);
		
		if(tmpX>=0 && tmpX<=W) {
			R = tmpX;
		}else if(tmpX>W && tmpX<=2*W) {
			R = 2*W - tmpX;
		}else {
			R = tmpX % (2*W);
		}
		
		
		// t시간 후 y 찾기
		int tmpY = y + t%(2*H);
		
		if(tmpY>=0 && tmpY<=H) {
			C = tmpY;
		}else if(tmpY>H && tmpY<=2*H) {
			C = 2*H - tmpY;
		}else {
			C = tmpY % (2*H);
		}
		
		System.out.printf("%d %d", R, C);
		
	
	}

}
