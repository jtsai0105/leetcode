class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
            }
            j++;
        }
        
        if (i < name.length()) {
            return false;
        }
        
        while (j < typed.length()) {
            if (name.charAt(i - 1) != typed.charAt(j)) {
                return false;
            }
            j++;
        }
        
        return true;
    }
}
