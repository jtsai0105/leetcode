class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        
        while (left <= right && top <= bottom) {
            // traverse top
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            
            // traverse right
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);
            }
            right--;
            
            // traverse bottom
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }
    
            // traverse left
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    res.add(matrix[j][left]);
                }
                left++;
            }
        }
        
        return res;
    }
}
