class Solution {
    public int solution(String[][] board, int h, int w) {
        int len = board.length;        
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};
        
        int cnt = 0;
        for(int d=0; d<4; d++){
            int nr = h + dr[d];
            int nc = w + dc[d];
            
            if(nr>=0 && nr<len && nc>=0 && nc<len && board[h][w].equals(board[nr][nc])){
                cnt++;
            }
        }
        
        return cnt;
    }
}