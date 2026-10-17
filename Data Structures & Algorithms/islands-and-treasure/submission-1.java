class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j = 0; j<grid[0].length ; j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty())
        {
            Pair tmp = q.poll();
            int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};

            for(int p=0;p<4;p++)
            {
                int x = tmp.x + dir[p][0];
                int y = tmp.y + dir[p][1];

                if(x>=0 && x<grid.length && y>=0 && y<grid[0].length
                && grid[x][y]==2147483647)
                {
                    grid[x][y] = grid[tmp.x][tmp.y]+1;
                    //System.out.println( grid[x][y]); 
                    q.add(new Pair(x,y));
                }
            }
        }
    }
}
class Pair
    {
        int x,y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
