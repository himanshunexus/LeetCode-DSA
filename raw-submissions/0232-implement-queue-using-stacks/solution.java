class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> helper;
    public MyQueue() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(stack.size()>1){
            helper.push(stack.pop());
        }
        int front = stack.pop();
        while(helper.size()>0){
            stack.push(helper.pop());
        }
        return front;

    }
    
    public int peek() {
        while(stack.size()>1){
            helper.push(stack.pop());
        }
        int front = stack.peek();
        while(helper.size()>0){
            stack.push(helper.pop());
        }
        return front;
    }
    
    public boolean empty() {
        return stack.isEmpty();
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
