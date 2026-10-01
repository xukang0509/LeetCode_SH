package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 水果成篮
 * @author: xu
 * @date: 2026-09-29 21:13:05
 */
@SuppressWarnings("all")
class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            int max = Integer.MIN_VALUE;
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0;
            for (int right = 0; right < fruits.length; right++) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                while (map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if (map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                    }
                    left++;
                }
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}