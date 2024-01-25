class Solution {
    public int solution(int[] numbers) {
        int ans = 0;
        int[] num = new int[10]; // 0~9까지 배열을 만듦
        
        for(int i=0; i<numbers.length; i++){
            int n = numbers[i];
            num[n]++;
        }
        
        for(int i=0; i<10; i++){
            if(num[i]==0){
                ans += i;
            }
        }
        
        
        return ans;
    }
}