class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j));
                }
            }
        }

        int t = -1;
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int s=0;s<size;s++)
            {
                Pair tmp = q.poll();
                //System.out.println(tmp.x+" "+tmp.y);
                for(int i=0;i<4;i++)
                {
                    int x = dir[i][0] + tmp.x;
                    int y = dir[i][1] + tmp.y;

                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && 
                    grid[x][y]==1)
                    {
                        grid[x][y]=2;
                        q.add(new Pair(x,y));
                    }
                }    
            }
            t++;
            //System.out.println("-------");
        }

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
            }
        }

        return t==-1?0:t;
    }
}
class Pair
{
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
