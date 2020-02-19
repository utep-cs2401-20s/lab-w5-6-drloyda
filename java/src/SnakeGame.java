public class SnakeGame {
    private boolean[][] game;
    private int [] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Default constructor
    SnakeGame(){
        game = new boolean[1][1];
    }

    SnakeGame(boolean[][] board, int x, int y){
        game = new boolean[board.length][board.length];
        headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;

        for(int i = 0 ; i < board.length;i++ ){
            for(int j = 0; j < board[i].length; j++){
                game[i][j] = board[i][j];
            }
        }
    }
    public int[] findTailExhaustive() {
        //reset counter
        //increases check counter each time
        //check fisrt cell
        //is part of snake? if no move to next
        //if yes, check how many neighbors are apart of snake and add to length
        //if only one neighbor then at the tail or head
        //if two or more neighbors then move to next cell
        //return array[3] (tail position [x,y] and length
        resetCounters();

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j]) {)
                    if (neighbors(game,i,j) == 1 && (game[i] = headPosition[0]) && (game[j] = headPosition[1])){
                    }

                }
            }
        }
        return
    }
    public int neighbors(boolean [][] game, int row, int col){
        int neighbors = 0;
        if(game[row][col +1])//checks right
            neighbors++;
        if(game[row][col -1])//checks left
            neighbors++;
        if(game[row + 1][col])//checks down
            neighbors++;
        if(game[row -1][col])//checks up
            neighbors++;

        return neighbors;
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;

    }
    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
    private static int getRecursiveChecks(){
        return recursiveChecks;
    }


}
