public class SnakeGame {
    private boolean[][] game;
    private int [] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    private int [] result; // i made to print the result

    //Default constructor assigns game board of one element
    SnakeGame(){
        game = new boolean[1][1];
    }

    //Constructor that initializes gameboard and headPosition
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
        int tailRow = 0;
        int tailCol = 0;
        int length = 0;

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                exhaustiveChecks++;
                if (game[i][j]){
                    length++;
                    if (neighbors(game,i,j) == 1 && (game[i] != game[headPosition[0]]) && (game[i] != game[headPosition[0]])  ){
                        tailRow = i;
                        tailCol = j;
                    }
                }
            }
        }
        result = new int [] {tailRow,tailCol,length};
        return result;
    }
//    public int [] findTailRecursive(){
//        if(game[headPosition[0] + 1][headPosition[1]])
//
//
//    }
    public void print(){
        System.out.println("Head position: (" + headPosition[0] + ", " + headPosition[1] + ")");
        System.out.println("Tail position: (" + result[0] + ", " + result[1] + ")");
        System.out.println("Length: " + result[2]);
        System.out.println("Exhaustive Checks: " + exhaustiveChecks);
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

    public int neighbors(boolean [][] game, int row, int col){
//        boolean right = (game[row][col +1]);
//        boolean left = (game[row][col -1]);
//        boolean down = (game[row + 1][col]);
//        boolean up = (game[row -1][col]);

        int neighbors = 0;

        if(row == 0 && col == 0){
            if(game[row][col +1])
                neighbors++;
            if(game[row + 1][col])
                neighbors++;
        }

        if(row == game.length-1 && col == game.length -1){
            if((game[row][col -1]))
                neighbors++;
            if(game[row -1][col])
                neighbors++;
        }

        if(row == 0 && col != game.length-1){
            if((game[row][col -1]))
                neighbors++;
            if(game[row][col +1])
                neighbors++;
            if(game[row + 1][col])
                neighbors++;
        }
        if(col == 0 && row != game.length-1 ){
            if(game[row][col +1])
                neighbors++;
            if((game[row - 1][col]))
                neighbors++;
            if(game[row + 1][col])
                neighbors++;
        }

        if(row != 0 && row != game.length-1 && col != 0 && col!= game.length-1){
            if(game[row][col +1])
                neighbors++;
            if((game[row][col -1]))
                neighbors++;
            if(game[row + 1][col])
                neighbors++;
            if(game[row -1][col])
                neighbors++;
        }
        return neighbors;
    }




}
