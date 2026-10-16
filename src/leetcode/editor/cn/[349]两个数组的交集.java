package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 两个数组的交集
 * @author: xu
 * @date: 2026-10-03 10:33:14
 */
@SuppressWarnings("all")
class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int size = 1001;
            boolean[] hash1 = new boolean[size];
            boolean[] hash2 = new boolean[size];
            for (int num : nums1) hash1[num] = true;
            for (int num : nums2) hash2[num] = true;

            List<Integer> resList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (hash1[i] && hash2[i]) {
                    resList.add(i);
                }
            }
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}