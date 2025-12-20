class MedianFinder {
    PriorityQueue<Integer> maxi;
    PriorityQueue<Integer> mini;

    public MedianFinder() {
        this.maxi=new PriorityQueue<>((a,b)-> b-a);    
        this.mini=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxi.isEmpty() || num <= maxi.peek()){
            maxi.add(num);
        }else{
            mini.add(num);
        }
        if(maxi.size()>mini.size()+1){
            mini.add(maxi.remove());
        }
        if(mini.size()>maxi.size()+1){
            maxi.add(mini.remove());
        }
    }
    
    public double findMedian() {
        if(maxi.size()==mini.size()){
            return (double)(maxi.peek()+mini.peek())/2;
        }else if(maxi.size()>mini.size()){
            return maxi.peek();
        }else{
            return mini.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */