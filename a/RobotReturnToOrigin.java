class Solution {
    public boolean judgeCircle(String moves) {
        int[] count = new int[4];
        for (char c : moves.toCharArray()) {
            switch(c) {
                case 'U':
                    count[0]++;
                    break;
                case 'D':
                    count[1]++;
                    break;
                case 'L':
                    count[2]++;
                    break;
                case 'R':
                    count[3]++;
                    break;
                default:
                    break;
            }
        }
        return count[0] - count[1] == 0 && count[2] - count[3] == 0;
    }
}
