class Solution {
    public double separateSquares(int[][] squares) {
        double start=0,end=2e9;
        while((end-start)>1e-5){
            double mid=(start+end)/2.0;
            int temp=helper(squares,mid);
            if(temp==1){
                start=mid;

            }else{
                end=mid;
            }
        }
        return Math.round(end*1e5)/1e5;
    }
    public int helper(int squares[][],double mid){
        double upper=0.0,lower=0.0;
        for(int []sq:squares){
            int x=sq[0],y=sq[1],l=sq[2];
            if(y>mid){
                upper+=1.0*l*l;
                
            }else if(y+l<=mid){
                lower+=1.0*l*l;
            }else{
                double cut=mid-y;
                lower+=(mid-y)*l;
                upper+=(l-(mid-y))*l;
            }

        }
        if (Math.abs(upper - lower) < 1e-6) return 0;
        return upper>lower?1:-1;
    }
}