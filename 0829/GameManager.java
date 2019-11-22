public class GameManager{
  private int[][]grid;
  public GameManager(int[][]grid){
    this.grid = grid;

  }

  //grid has values of 1 or 2 depending on turn

  public void enter(int r, int c, int turn){
    grid[r][c] = turn;
  }

  public void print(){
    for(int r=0; r<grid.length; r++){
      for(int c=0; c<grid[r].length; c++){
        if(grid[r][c] == 1)
          System.out.print("X" + "\t");
      	else if(grid[r][c] == 2)
          System.out.print("O" + "\t");
        else
          System.out.print("-"+ "\t");
      }
      System.out.println();
    }
  }

  public boolean taken(int r, int c){
    if(grid[r][c]!=0)
      return true;
    else
      return false;
  }

  public boolean checkWin(int turn)
  {
    //top row
    if(grid[0][0]==turn&&grid[0][1]==turn&&grid[0][2]==turn)
    {
      return true;
		}
    //left most column
    else if(grid[0][0]==turn&&grid[1][0]==turn&&grid[2][0]==turn)
    {
      return true;
		}
    //middle column
    else if(grid[0][1]==turn&&grid[1][1]==turn&&grid[2][1]==turn)
    {
      return true;
		}
    //rightmost column
     else if(grid[0][2]==turn&&grid[1][2]==turn&&grid[2][2]==turn)
    {
       return true;
		}
    //middle thing
    else if(grid[0][0]==turn&&grid[1][1]==turn&&grid[2][2]==turn)
    {
      return true;
		}
    //middle row
    else if(grid[1][0]==turn&&grid[1][1]==turn&&grid[1][2]==turn)
    {
      return true;
		}
    //bottom row
    else if(grid[2][0]==turn&&grid[2][1]==turn&&grid[2][2]==turn)
    {
      return true;
		}
    //bottom row
    else if(grid[0][2]==turn&&grid[1][1]==turn&&grid[2][0]==turn)
    {
      return true;
		}
    return false;

	}
}
