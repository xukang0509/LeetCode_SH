package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * 2024-08-30 11:51:25
 */
@SuppressWarnings("all")
class MinStackDemo {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private final Deque<Data> stack;

        public MinStack() {
            stack = new LinkedList<>();
            stack.push(new Data(-1, Integer.MAX_VALUE));
        }

        public void push(int val) {
            stack.push(new Data(val, Math.min(val, stack.peek().min())));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value();
        }

        public int getMin() {
            return stack.peek().min();
        }

        private record Data(int value, int min) {
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}