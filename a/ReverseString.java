class Solution {
    public String reverseString(String s) {
       
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
        }
        
        return sb.reverse().toString();
        
    }
}
