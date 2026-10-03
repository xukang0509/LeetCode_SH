package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 两个数组的交集 II
 * @author: xu
 * @date: 2026-10-03 10:56:27
 */
@SuppressWarnings("all")
class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int size = 1001;
            int[] hash1 = new int[size];
            int[] hash2 = new int[size];
            for (int i : nums1) hash1[i]++;
            for (int i : nums2) hash2[i]++;

            List<Integer> resList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (hash1[i] != 0 && hash2[i] != 0) {
                    int numSize = Math.min(hash1[i], hash2[i]);
                    for (int j = 0; j < numSize; j++) {
                        resList.add(i);
                    }
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