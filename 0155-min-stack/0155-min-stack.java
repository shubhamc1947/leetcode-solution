class MinStack {
    private Stack<Integer> arr;
    private Stack<Integer> minTrack;

    public MinStack() {
        this.arr = new Stack<>();
        this.minTrack = new Stack<>();
    }

    public void push(int val) {
        arr.push(val);
        if (minTrack.isEmpty() || val <= minTrack.peek()) {
            minTrack.push(val);
        }
    }

    public void pop() {
        if (arr.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        int val = arr.pop();
        if (val == minTrack.peek()) {
            minTrack.pop();
        }
    }

    public int top() {
        if (arr.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return arr.peek();
    }

    public int getMin() {
        if (minTrack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return minTrack.peek();
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