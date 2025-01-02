package leetcode.editor.cn;

/**
 * 用栈实现队列
 * 2024-06-03 14:13:59
 */
class ImplementQueueUsingStacks {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        private ArrayStack<Integer> stack1;
        private ArrayStack<Integer> stack2;

        public MyQueue() {
            stack1 = new ArrayStack<>(100);
            stack2 = new ArrayStack<>(100);
        }

        public void push(int x) {
            stack2.push(x);
        }

        public int pop() {
            if (stack1.isEmpty()) move();
            return stack1.pop();
        }

        public int peek() {
            if (stack1.isEmpty()) move();
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public void move() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        static class ArrayStack<E> {
            private final E[] array;
            private int top;

            public ArrayStack(int capacity) {
                this.array = (E[]) new Object[capacity];
                this.top = 0;
            }

            public boolean push(E value) {
                if (isFull()) return false;
                array[top++] = value;
                return true;
            }

            public E pop() {
                if (isEmpty()) return null;
                return array[--top];
            }

            public E peek() {
                if (isEmpty()) return null;
                return array[top - 1];
            }

            public boolean isEmpty() {
                return top == 0;
            }

            public boolean isFull() {
                return top == array.length;
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}