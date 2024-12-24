import java.util.Scanner;

public class Main {
    static int[][] map = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            String s = sc.next();
            for(int j=0; j<9; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        sdk(0);
    }
    public static boolean sdk(int dep){
        if(dep==81){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return true;
        }
        int r = dep/9;
        int c = dep%9;
        if(map[r][c] != 0) return sdk(dep+1);
        else{
            for(int i=1; i<=9; i++){
                if(!check(r,c,i)) continue;
                map[r][c] = i;
                if(sdk(dep+1)) return true;
                map[r][c] = 0; // 백트래킹
            }
        }
        return false;
    }
    public static boolean check(int r, int c, int value){
        // 행, 열 확인
        for(int i=0; i<9; i++){
            if(map[r][i]==value || map[i][c]==value) return false;
        }
        // 3*3 확인
        r = (r/3)*3;
        c = (c/3)*3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(map[i][j]==value) return false;
            }
        }
        return true;
    }
}