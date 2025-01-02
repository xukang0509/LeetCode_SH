package leetcode.editor.cn;

/**
 * 接雨水
 * 2024-08-20 16:47:09
 */
@SuppressWarnings("all")
class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 输入：height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        public int trap(int[] height) {
            int res = 0;
            int length = height.length;
            int left = 0, leftMax = height[0];
            int right = length - 1, rightMax = height[length - 1];
            while (left < right) {
                if (height[left] < height[right]) {
                    res += leftMax - height[left];
                    leftMax = Integer.max(leftMax, height[++left]);
                } else {
                    res += rightMax - height[right];
                    rightMax = Integer.max(rightMax, height[--right]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}