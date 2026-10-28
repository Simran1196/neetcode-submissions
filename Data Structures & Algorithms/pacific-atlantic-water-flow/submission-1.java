class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {   
        Queue<Pair> q = new LinkedList<>();

        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i<heights[0].length; i++)
        {   
            q.add(new Pair(0,i));
        }
        for(int i = 1; i<heights.length; i++)
        {   
            q.add(new Pair(i,0));
        }
        
        boolean vis[][] = new boolean[heights.length][heights[0].length];
        while(!q.isEmpty())
        {
            Pair tmp = q.poll();
            vis[tmp.x][tmp.y] = true;
            for(int i=0;i<4;i++)
            {
                int x = tmp.x + dir[i][0];
                int y = tmp.y + dir[i][1];

                if(x>=0 && y>=0 && x<heights.length && y<heights[0].length && 
                heights[tmp.x][tmp.y]<=heights[x][y] && !vis[x][y])
                {
                    q.add(new Pair(x,y));
                }
            }
        }

        q = new LinkedList<>();
        for(int i = 0; i<heights[0].length; i++)
        {   
            q.add(new Pair(heights.length-1,i));
            //System.out.println(heights.length-1 + " "  + i);
        }
        for(int i = heights.length-2; i>=0; i--)
        {   
            q.add(new Pair(i,heights[0].length-1));
            //System.out.println(i + " " + (heights[0].length-1));
        }

        boolean vis1[][] = new boolean[heights.length][heights[0].length];
        while(!q.isEmpty())
        {
            Pair tmp = q.poll();
            vis1[tmp.x][tmp.y] = true;
            for(int i=0;i<4;i++)
            {
                int x = tmp.x + dir[i][0];
                int y = tmp.y + dir[i][1];

                if(x>=0 && y>=0 && x<heights.length && y<heights[0].length && 
                heights[tmp.x][tmp.y]<=heights[x][y] && !vis1[x][y])
                {
                    q.add(new Pair(x,y));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<heights.length; i++)
        {
            for(int j = 0; j<heights[0].length; j++)
            {
                System.out.println(i + " " + j + " - " + vis[i][j] + " " + vis1[i][j]);
                
                if(vis[i][j] && vis1[i][j])
                {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);

                    ans.add(l);
                }
            }
        }
        return ans;
    }


}
class Pair
{
    int x;
    int y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

