public class IslandCounterDFS {
    int diff[][]={{0,-1},{0,1},{-1,0},{1,0}};

    private void dfs(char grid[][],int r,int c,int row,int col){
        grid[row][col]='0';
        for(int i=0;i<4;i++){
            int ar=row+diff[i][0],ac=col+diff[i][1];
            if(ar>=0 && ar<r && ac>=0 && ac<c && grid[ar][ac]=='1'){
                dfs(grid,r,c,ar,ac);
            }
        }
    }
    public int numIslands(char[][] grid) {
       int r=grid.length;
       int c=grid[0].length;
       int count=0;
       for(int row=0;row<r;row++){
        for(int col=0;col<c;col++){
            if(grid[row][col]=='1'){
                count++;
                dfs(grid,r,c,row,col);
            }
        }
       }
       return count; 
    }
}
