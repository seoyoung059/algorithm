class Solution {
    public String solution(String my_string) {
        String answer = "";
        int length = my_string.length();
        
        while(length-- > 0)
            answer += my_string.charAt(length);
        return answer;
    }
}