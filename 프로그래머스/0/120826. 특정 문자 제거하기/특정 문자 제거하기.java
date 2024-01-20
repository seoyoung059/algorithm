class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            if (my_string.charAt(i) != letter.charAt(0)) {
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}