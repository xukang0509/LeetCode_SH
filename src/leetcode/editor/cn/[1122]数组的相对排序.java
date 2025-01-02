package leetcode.editor.cn;

/**
 * 数组的相对排序
 * 2024-07-17 14:00:30
 */
@SuppressWarnings("all")
class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        solution.relativeSortArray(arr1, arr2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] counting = new int[1001];
            for (int n : arr1) {
                counting[n]++;
            }
            int idx = 0;
            for (int num : arr2) {
                while (counting[num] > 0) {
                    arr1[idx++] = num;
                    counting[num]--;
                }
            }
            for (int i = 0; i < counting.length; i++) {
                while (counting[i] > 0) {
                    arr1[idx++] = i;
                    counting[i]--;
                }
            }
            return arr1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}