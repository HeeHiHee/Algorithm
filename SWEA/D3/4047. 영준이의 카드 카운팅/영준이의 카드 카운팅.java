import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int[] space = new int[14];
			int[] dia = new int[14];
			int[] heart = new int[14];
			int[] clob = new int[14];
			
			boolean bool = true;
			
			String str = sc.next(); // 문자열 입력받기
			int N = (str.length()+1)/3;
			
			for(int i=0; i<N; i++) {
				int tmp = i*3;
				
				char pat = str.charAt(tmp);   // 모양
				char fir = str.charAt(tmp+1); // 첫번째 숫자
				char sec = str.charAt(tmp+2); // 두번째 숫자 
				int card;
				
				// 카드 번호 int로 바꾸기 
				if(fir == '0') {
					card = sec - '0';
				}else {
					card = (fir-'0')*10 + (sec-'0');
				}
				
				// 모양에 따라 배열의 값 ++ 해주기
				// 해당 카드 숫자의 배열의 값이 0일때만 ++
				if(pat == 'S') {
					if(space[card]==0) {
						space[card]++;
					}else {
						bool = false;
					}
				}else if(pat == 'D') {
					if(dia[card]==0) {
						dia[card]++;
					}else {
						bool = false;
					}
				}else if(pat == 'H') {
					if(heart[card]==0) {
						heart[card]++;
					}else {
						bool = false;
					}
				}else if(pat == 'C') {
					if(clob[card]==0) {
						clob[card]++;
					}else {
						bool = false;
					}
				}
				
				
			}// N
			
			int ss = 13;
			int ds = 13;
			int hs = 13;
			int cs = 13;
			
			if(bool==false) {
				System.out.println("#" + tc + " " + "ERROR");
			}else {
				for(int i=0; i<14; i++) {
					ss -= space[i];
					ds -= dia[i];
					hs -= heart[i];
					cs -= clob[i];
				}
				System.out.printf("#%d %d %d %d %d\n", tc, ss, ds, hs, cs);
			}
		
			
		}//tc
		
		
	}

}
