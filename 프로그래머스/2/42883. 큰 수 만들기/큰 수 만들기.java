class Solution {
    
    public String solution(String number, int k) {
        int len = number.length();
        int[] arr = new int[len];
        
        for(int i=0; i<len; i++){
            arr[i] = number.charAt(i)-'0';
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 뽑은 자리의 index를 저장
        int idx = 0;
        // 숫자의 자리수만큼 for문 돌리기 
        for(int i=0; i<len-k; i++) {
            int max = 0;
            for(int j=idx; j<=i+k; j++) {
                if(max < arr[j]){
                max = arr[j];
                idx = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
        
    }//solution
    
    
}