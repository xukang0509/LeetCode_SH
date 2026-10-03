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
            int[] hash1 = new int[size];
            int[] hash2 = new int[size];
            for (int num : nums1) hash1[num] = 1;
            for (int num : nums2) hash2[num] = 1;

            List<Integer> resList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (hash1[i] == 1 && hash2[i] == 1) {
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