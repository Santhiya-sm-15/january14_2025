# january14_2025
The problems that I solved today

1.You are given two 0-indexed integer permutations A and B of length n. A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B. Return the prefix common array of A and B. A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

Code:
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

2.You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded: Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell. Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board. To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Code:
class Solution {
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        char[][] res=new char[n][m];
        boolean[][] visited=new boolean[n][m];
        for(char[] x:res)
            Arrays.fill(x,'X');
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        Queue<int[]> q=new LinkedList<>();
        int i;
        for(i=0;i<n;i++)
        {
            if(board[i][0]=='O')
                q.add(new int[]{i,0});
            if(board[i][m-1]=='O')
                q.add(new int[]{i,m-1});
        }
        for(i=0;i<m;i++)
        {
            if(board[0][i]=='O')
                q.add(new int[]{0,i});
            if(board[n-1][i]=='O')
                q.add(new int[]{n-1,i});
        }
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            res[x[0]][x[1]]='O';
            visited[x[0]][x[1]]=true;
            for(int[] d:dir)
            {
                int nr=x[0]+d[0];
                int nc=x[1]+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc] && board[nr][nc]=='O')
                    q.add(new int[]{nr,nc});
            }
        }
        for(i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                board[i][j]=res[i][j];
        }
    }
}
