class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                res[j] += res[j - 1];
            }
        }
        
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
