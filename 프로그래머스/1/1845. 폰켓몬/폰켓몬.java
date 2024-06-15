import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], nums[i]);
        }
        int answer = 0;
        int numlen = nums.length/2;
        if(map.size()>numlen){
            answer = numlen;
        }else{
            answer = map.size();
        }
        return answer;
    }
}