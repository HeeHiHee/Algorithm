import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                list.add(i);
                if(i != n/i){
                    list.add(n/i);
                }
                
            }
        }
        
        Collections.sort(list);
        
        int[] res = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
        
    }
}