class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) 
            dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] img, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= img.length || c < 0 || c >= img[0].length || img[r][c] != oldColor) 
            return;
        img[r][c] = newColor;
        dfs(img, r + 1, c, oldColor, newColor);
        dfs(img, r - 1, c, oldColor, newColor);
        dfs(img, r, c + 1, oldColor, newColor);
        dfs(img, r, c - 1, oldColor, newColor);
    }
}
