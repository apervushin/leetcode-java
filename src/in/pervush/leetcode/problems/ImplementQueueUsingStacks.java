package in.pervush.leetcode.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {

    private static class MyQueue {

        private Stack<Integer> first = new Stack<>();
        private Stack<Integer> second = new Stack<>();

        /** Push element x to the back of queue. */
        public void push(int x) {
            first.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (second.empty()){
                moveFirstToSecond();
            }
            return second.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (second.empty()){
                moveFirstToSecond();
            }
            return second.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return second.empty() && first.empty();
        }

        private void moveFirstToSecond() {
            while (!first.empty()) {
                second.push(first.pop());
            }
        }
    }


}
