
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nanZangE= new int[9];
		
		// 배열에 9명 키 넣기
		for(int i=0; i<nanZangE.length; i++) {
			nanZangE[i] = sc.nextInt();
		}
		
		// 9명 키 합을 구하기
		int sum=0;
		for(int i=0; i<nanZangE.length; i++) {
			sum += nanZangE[i];
		}
		
		// 찐 아닌 난쟁이 애들 키 2개
		int exp1 = 0;
		int exp2 = 0;
		
		// 난쟁이 2명의 키의 합이 sum-100을 만족하는 걸 찾기		
		loopOut: // 2명 찾으면 이중포문 탈출
		for(int i=0; i<nanZangE.length-1; i++) {
			for(int j=1; j<nanZangE.length; j++) {
				if(nanZangE[i] + nanZangE[j] == sum-100) {
					exp1 = nanZangE[i];
					exp2 = nanZangE[j];
					
					break loopOut;
				}
			}
		}
		
		
		// 찐 난쟁이들 7명만 골라서 zzin 배열에 담기
		int[] zzin = new int[7];
		int index=0;
		for(int i=0; i<nanZangE.length; i++) {
			if(nanZangE[i] == exp1 || nanZangE[i] == exp2) {
				continue;				
			}
			zzin[index] = nanZangE[i];	
			index++;
			
		}
		
		// 정렬
		Arrays.sort(zzin);
		
		// 출력
		for(int i=0; i<zzin.length; i++) {
			System.out.println(zzin[i]);
		}
	}
}
