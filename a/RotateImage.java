class Solution {
    public void rotate(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < i; j++) {
                swap(i, j, matrix);
            }
        }
    }
    
    private void swap(int i, int j, int[][] matrix) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
}


