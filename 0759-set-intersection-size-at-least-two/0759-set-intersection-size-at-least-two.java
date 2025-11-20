class Solution {
    public int intersectionSizeTwo(int[][] iv) {
        Arrays.sort(iv, (o1,o2)->(o1[1]!=o2[1]? o1[1]-o2[1]:o1[0]-o2[0]));
        int a=0;
        int b1=-1, b2=-1;
        for(int[] i:iv){
            if(i[0]>b1){
                a+=2;
                b1=i[1]; b2=i[1]-1;
            }else if(i[0]>b2){
                a++;
                if(i[1]==b1){
                    b2=b1-1;
                }else{
                    b2=b1; b1=i[1];
                }
            }
        }
        return a;
    }
}