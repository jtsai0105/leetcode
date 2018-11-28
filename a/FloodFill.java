class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return image;
        int sColor = image[sr][sc];
        helper(image, sr, sc, sColor, newColor);
        return image;
    }
    
    private void helper(int[][] image, int sr, int sc, int sColor, int newColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if(image[sr][sc] != sColor || image[sr][sc] == newColor) return;
        image[sr][sc] = newColor;
        helper(image, sr, sc+1, sColor, newColor);
        helper(image, sr, sc-1, sColor, newColor);
        helper(image, sr+1, sc, sColor, newColor);
        helper(image, sr-1, sc, sColor, newColor);
    }
}
