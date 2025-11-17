class Node{
    int price;
    int idx;
    Node (int price,int idx){
        this.price=price;
        this.idx=idx;
    }
}
class StockSpanner {

    Stack<Node> st;
    int idx;
    public StockSpanner() {
        st=new Stack<>();
        idx=-1;
    }
    
    public int next(int price) {
        idx++;
        // if(st.isEmpty()){
        //     st.push(new Node(price,idx));
        //     return 1;
        // }
        while(!st.isEmpty() && st.peek().price<=price){
            st.pop();
        }

        int ans=idx-(st.isEmpty()?-1:st.peek().idx);
        st.push(new Node(price,idx));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */