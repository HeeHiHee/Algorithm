class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int len1 = str1.length();
        int len2 = str2.length();
        // 두 문자열중 더 길이가 긴만큼 for문 반복
        int len = 0;
        if(len1<=len2){
            len = len2;
        }else{
            len = len1;
        }
        // charAt이 빈 값인지 확인하려면 0인지 판별하면됨 
        for(int i=0; i<len; i++){
            if(str1.charAt(i)==0){
                continue;
            }else{
                sb.append(str1.charAt(i));
            }
            
            if(str2.charAt(i)==0){
                continue;
            }else{
                sb.append(str2.charAt(i));
            }            
            
        }
        return sb.toString();
    }
}