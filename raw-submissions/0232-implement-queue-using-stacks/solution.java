class MyQueue {
    Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(stack.isEmpty())
            return -1;
        int top = stack.pop();
        if(stack.isEmpty()){
            return top;
        }
        int res = pop(); 
        stack.push(top);   
        return res;

    }
    
    public int peek() {
        if(stack.isEmpty())
            return -1;
        int top = stack.pop();
        if(stack.isEmpty()){
            stack.push(top);
            return top;
        }
        int res = peek();
        stack.push(top);
        return res;
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
