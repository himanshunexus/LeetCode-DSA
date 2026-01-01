class Solution {
    public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()){
        if(!stack.isEmpty()&& stack.peek()==c){
            stack.pop();
        }
        else{
            stack.push(c);
        } 
    }
    StringBuilder sb = new StringBuilder();
    for(char ch : stack){
        sb.append(ch);
    }
    return sb.toString();
  }
}
