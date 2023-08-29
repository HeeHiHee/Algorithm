import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sen = sc.nextLine();
		sc.close();
		
		StringTokenizer st = new StringTokenizer(sen, "<|>| ", true);
		StringBuilder sb = new StringBuilder();
		
		int cnt = st.countTokens();
        
		String cram = "0";
        
		for(int i=0; i<cnt; i++) {
			String nt = st.nextToken().toString();
			// 꺽쇠 있을 때
			if(nt.equals("<")) {
				sb.append(nt);
				cram = "1";
				continue;
			}else if(nt.equals(">")) {
				sb.append(nt);
				cram = "0";
				continue;
			}else {
				// 꺽쇠 없을 때
				if(cram.equals("1")) {
					sb.append(nt);
				}else {
					StringBuilder sb2 = new StringBuilder();
					String neww = sb2.append(nt).reverse().toString();
					sb.append(neww);
				}
			}
			
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
