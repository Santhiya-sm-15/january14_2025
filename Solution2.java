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
        System.out.println(q);
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