import java.util.Scanner;
public class Runner{
  public static void main(String[] args){
    int[][] grid = new int[3][3];
    int x=0;
    for(int r=0; r<grid.length; r++){
      for(int c=0; c<grid[r].length; c++){
        grid[r][c] = 0;
      }
    }
  int turn = 1;
    Scanner sc = new Scanner(System.in);
    GameManager gm = new GameManager(grid);
    while(x==0){
      gm.print();
      System.out.println("Row: ");
      int r = sc.nextInt()-1;
      System.out.println("Column: ");
      int c = sc.nextInt()-1;
      gm.enter(r,c,turn);
      if(turn ==1){
        if(gm.checkWin(turn)){
          gm.print();
          System.out.println("X WINS");
          x++;
        }
        turn++;
      } else if(turn == 2){
       if(gm.checkWin(turn)){
          gm.print();
          System.out.println("O WINS");
          x++;
        }
        turn--;
    }



  }
}
}
