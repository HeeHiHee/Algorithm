import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int[] num = new int[2];
        char before = S.charAt(0);
        num[before-'0']++;
        for(int i=1; i<S.length(); i++){
            char ch = S.charAt(i);
            if(before!=ch){
                before = ch;
                num[ch-'0']++;
            }
        }
        System.out.println(Math.min(num[0], num[1]));
    }
}