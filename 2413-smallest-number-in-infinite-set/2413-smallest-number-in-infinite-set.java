class SmallestInfiniteSet {
    int [] nums = new int [1000];
    int i = 0;
    public int popSmallest() {
        i = 0;
        while (nums[i] == 1){
            i++;
        }
        nums[i] = 1;
        return i + 1;
    }

    public void addBack(int num) {
        nums[num - 1] = 0;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */