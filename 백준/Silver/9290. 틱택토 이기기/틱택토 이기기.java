import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static String nam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken()); // 테케
        for(int t=0; t<tc; t++){

            map = new String[3][3];
            // O좌표 2개, X좌표 2개
            int oS = 0;
            int xS = 0;
            int[][] Opoint = new int[2][2];
            int[][] Xpoint = new int[2][2];


            // 현재 게임판
            for(int i=0; i<3; i++){
                String rline = br.readLine();
                String[] tokens = rline.split("");
                for(int j=0; j<3; j++){
                    map[i][j] = tokens[j];
                    if(map[i][j].equals("o")){
                        Opoint[oS][0] = i;
                        Opoint[oS++][1] = j;
                    }
                    if(map[i][j].equals("x")){
                        Xpoint[xS][0] = i;
                        Xpoint[xS++][1] = j;
                    }
                }
            }
            // 남규 말
            nam = br.readLine();
            
            int[][] Apoint = new int[2][2];
            if (nam.equals("o")){
                for(int i=0; i<2; i++){
                    for(int j=0; j<2; j++){
                        Apoint[i][j] = Opoint[i][j];
                    }
                }
            }else{
                for(int i=0; i<2; i++){
                    for(int j=0; j<2; j++){
                        Apoint[i][j] = Xpoint[i][j];
                    }
                }
            }
//            System.out.println(rD + " " + cD);

            // 케이스 나누기
            if(Apoint[0][0] == Apoint[1][0]){
                // 행이 같을 때
                int tmp = 3 - (Apoint[0][1] + Apoint[1][1]);
                map[Apoint[0][0]][tmp] = nam;

            }else if(Apoint[0][1] == Apoint[1][1]){
                // 열이 같을 때
                int tmp = 3 - (Apoint[0][0] + Apoint[1][0]);
                map[tmp][Apoint[0][1]] = nam;

            }else {
                // 대각선
                int tmp1 = 3 - (Apoint[0][0] + Apoint[1][0]);
                int tmp2 = 3 - (Apoint[0][1] + Apoint[1][1]);
                map[tmp1][tmp2] = nam;

            }

            PrintGraph(map, t+1);


        }// tc

    }

    public static void PrintGraph(String[][] graph, int t){
        System.out.println("Case " + t + ":");
        for (String[] row : graph) {
            for (String e : row) {
                System.out.print(e);
            }
            System.out.println();
        }

    }

}