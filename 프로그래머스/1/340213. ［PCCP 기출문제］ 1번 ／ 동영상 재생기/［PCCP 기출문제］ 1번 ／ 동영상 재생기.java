class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // 비디오 길이 분리
        String[] video = video_len.split(":");
        int vmm = Integer.parseInt(video[0]);
        int vss = Integer.parseInt(video[1]);
        int v = (60*vmm)+vss;
        // 현재 위치 분리
        String[] pos1 = pos.split(":");
        int posmm = Integer.parseInt(pos1[0]);
        int posss = Integer.parseInt(pos1[1]);
        int p = (60*posmm)+posss;
        // 오프닝 시작 분리
        String[] ops = op_start.split(":");
        int osmm = Integer.parseInt(ops[0]);
        int osss = Integer.parseInt(ops[1]);
        int os = (60*osmm)+osss;
        // 오프닝 끝 분리
        String[] ope = op_end.split(":");
        int oemm = Integer.parseInt(ope[0]);
        int oess = Integer.parseInt(ope[1]);
        int oe = (60*oemm)+oess;

        // 현재 위치가 오프닝인지 확인
        if(p>=os && p<=oe){p = oe;}
        System.out.println(String.format("%02d:%02d", p/60, p%60));

        for(int i=0; i<commands.length; i++){
            String cmd = commands[i];
            // 커맨드가 next인 경우
            if(cmd.equals("next")){
                // 남은 시간이 10초 미만일 경우 영상 끝으로 이동
                if(v-p<10){
                    p=v;
                }
                else{
                    p += 10;
                }
            }
            // 커맨드가 prev인 경우
            else if(cmd.equals("prev")){
                // 현재 시간이 10초 미만일 경우 처음 위치로 이동
                if(p<10){
                    p=0;
                }
                else{
                    p -= 10;
                }
            }
            // 현재 위치가 오프닝인지 확인
            if(p>=os && p<=oe){p = oe;}
        }
        
        answer = String.format("%02d:%02d", p/60, p%60);
        return answer;
    }
}