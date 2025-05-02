class MyStack {
    private Queue<Integer> pQueue;
    private Queue<Integer> sQueue;
    public MyStack() {
        pQueue=new LinkedList<>();
        sQueue=new LinkedList<>();            
    }
    
    public void push(int x) {
        sQueue.add(x);
        while(!pQueue.isEmpty()){
            sQueue.add(pQueue.remove());
        }

        Queue<Integer> temp=pQueue;
        pQueue=sQueue;
        sQueue=temp;
    }
    
    public int pop() {
        return pQueue.remove();
    }
    
    public int top() {
        return pQueue.peek();
    }
    
    public boolean empty() {
        return pQueue.isEmpty();
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