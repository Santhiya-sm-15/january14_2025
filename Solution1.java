class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int i,n=A.length,cnt=0;
        int[] res=new int[n];
        Map<Integer,Integer> m=new HashMap<>();
        for(i=0;i<n;i++)
        {
            m.put(A[i],m.getOrDefault(A[i],0)+1);
            m.put(B[i],m.getOrDefault(B[i],0)+1);
            if(A[i]!=B[i])
            {
                if(m.containsKey(A[i]) && m.get(A[i])==2)
                    cnt++;
                if(m.containsKey(B[i]) && m.get(B[i])==2)
                    cnt++;
            }
            else
            {
                if(m.containsKey(A[i]) && m.get(A[i])==2)
                    cnt++;
            }
            res[i]=cnt;
        }
        return res;
    }
}