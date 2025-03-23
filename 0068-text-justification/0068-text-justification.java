class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        int i=0;
        String line = new String();
        int spacePerHole =0;;
        int remaining =0;

        while(i<words.length)
        {
            int usedCharLength = words[i].length();
            int j = i+1;
            int noOfHoles = 0;
            while(j < words.length && words[j].length()+1+usedCharLength+noOfHoles <=maxWidth)
            {
                usedCharLength+= words[j].length();
                noOfHoles++;
                j++;
            }
                int remainingSpaces = maxWidth - usedCharLength;

                spacePerHole = noOfHoles==0?0:remainingSpaces / noOfHoles;
                remaining = noOfHoles==0?0:remainingSpaces%noOfHoles; 
                
                // last line
                if(j == words.length)
                {
                    spacePerHole = 1;
                    remaining = 0;
                }

                line = buildLine(i,j,spacePerHole,remaining,words,maxWidth,noOfHoles);
                ans.add(line);
                i = j;

        }
        
        return ans;
    }

    public String buildLine(int i, int j, int spacePerHole, int remaining, String[] words, int maxWidth, int noOfHoles)
    {
        String temp = new String();
        int curHoleCount=0;
        for(int k=i;k<j;k++)
        {
            temp+= words[k];
            if(temp.length()>=maxWidth)
                break;
            for(int x=0;x<spacePerHole;x++)
            {
                temp+=" ";
            }

            if(remaining > 0)
            {
                temp+=" ";
                remaining--;
            }
                
        }

        while(temp.length()<maxWidth)
            temp+=" ";


            return temp;



    }
}