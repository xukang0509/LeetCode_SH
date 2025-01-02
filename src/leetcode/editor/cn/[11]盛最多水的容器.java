package leetcode.editor.cn;

/**
 * 盛最多水的容器
 * 2024-08-19 21:56:41
 */
@SuppressWarnings("all")
class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1;
            int maxArea = 0;
            while (i < j) {
                int min = Integer.min(height[i], height[j]);
                int area = (j - i) * min;
                maxArea = Integer.max(maxArea, area);
                while (i < j && height[i] <= min) {
                    i++;
                }
                while (i < j && height[j] <= min) {
                    j--;
                }
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}