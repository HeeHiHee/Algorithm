import java.util.Scanner;

public class Main {
    static int[][] able = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        boolean B = true;

        while (B){
            String game = sc.next();
            if(game.equals("end")){B=false; break;} // 입력 끝
            int nX=0, nO=0, rSum=0, cSum=0; // X말 개수, O말 개수, 행 합계, 열 합계
            char[] map = new char[9];
            for(int i=0; i<9; i++){
                map[i] = game.charAt(i);
                if(map[i]=='X') nX++;
                if(map[i]=='O') nO++;
            }

            // 1. X말 개수와 O말 개수 차이 확인
            if(nX-nO!=0 && nX-nO!=1) {sb.append("invalid").append("\n"); continue;}

            // 2. 승리한 사람이 있는지 확인
            boolean Xwin = Win(map, 'X');
            boolean Owin = Win(map, 'O');
            if(Xwin && Owin) {sb.append("invalid").append("\n"); continue;}
            if(Xwin && !Owin && nX>nO) {sb.append("valid").append("\n"); continue;}
            if(Owin && !Xwin && nX==nO) {sb.append("valid").append("\n"); continue;}
            if(Owin && !Xwin && nX>nO) {sb.append("invalid").append("\n"); continue;}

            // 3. 1,2단계를 다 통과하고, 모든 말이 다 찼으면 valid
            if(nX+nO==9) {sb.append("valid").append("\n"); continue;}

            // 4. 그 외 나머지는 invalid
            sb.append("invalid").append("\n");

        }// while

        System.out.println(sb);
    }

    public static boolean Win(char[] map, char h){
        for(int[] idx : able){
            if(map[idx[0]]==h && map[idx[1]]==h && map[idx[2]]==h){
                return true;
            }
        }
        return false;
    }
}