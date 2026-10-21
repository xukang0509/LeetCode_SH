package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 2024-06-03 15:22:22
 */
@SuppressWarnings("ALL")
class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new ImplementStackUsingQueues().new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("myStack.top() = " + myStack.top()); // 返回 2
        System.out.println("myStack.pop() = " + myStack.pop()); // 返回 2
        System.out.println("myStack.empty() = " + myStack.empty()); // 返回 False
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            reBuild();
            return queue.poll();
        }

        public int top() {
            reBuild();
            int top = queue.poll();
            queue.offer(top);
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }

        private void reBuild() {
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.poll());
            }
        }
    }


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}