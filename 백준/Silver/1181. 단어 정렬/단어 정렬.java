import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 단어 개수
		
		HashSet<String> set = new HashSet<>(); // 중복 단어 제거하기 위해 set 선언
		
		for(int i=0; i<N; i++) {
			// set에 단어 추가
			set.add(sc.next());
		}
		
		// set을 list로 변경 
		List<String> list = new ArrayList<String>(set);
		
		// 리스트를 배열로 만들기
		String[] arr = new String[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			arr[i] = list.get(i);
		}
		
		// 정렬하기
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어의 길이가 같을 경우
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}else {
					return s1.length() - s2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);	
		
		
		
	}//main

}