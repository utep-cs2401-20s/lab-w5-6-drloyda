public class SnakeGame {
    private boolean[][] game;
    private int [] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    private int [] result; // i made to print the result
    private int [] resultRec;

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
    //---------------------------------------------------------------------------------------------------------------
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
                    if (neighbors(i,j) == 1 && (game[i] != game[headPosition[0]]) && (game[i] != game[headPosition[0]])  ){
                        tailRow = i;
                        tailCol = j;
                    }
                }
            }
        }
        result = new int [] {tailRow,tailCol,length};
        return result;
    }
    //---------------------------------------------------------------------------------------------------------------
    public int [] findTailRecursive(){
       // result = new int [] {tailRow,tailCol,length};
        resetCounters();

        return findTailRecursive(headPosition,headPosition);
    }
    //---------------------------------------------------------------------------------------------------------------
    private int [] findTailRecursive(int [] currentPosition, int [] previousPosition){
        int [] next = new int[2];
        int neighbors = 0;

        for(int i = -1; i<=1; i = i + 2){

            if(currentPosition[0] + i > 0  && currentPosition[0] + i < game.length && game[currentPosition[0] + i][currentPosition[1]]) {
                if(currentPosition[0] + i != previousPosition[0]){
                    next[0] = currentPosition[0] + i;
                    next[1] = currentPosition[1];
                }

            }
            if(currentPosition[1] + i > 0  && currentPosition[1] + i < game.length && game[currentPosition[0]][currentPosition[1] + i]) {
                if(currentPosition[1] + i != previousPosition[1]){
                    next[0] = currentPosition[0];
                    next[1] = currentPosition[1] + i;
                }
            }if(next[0] == 0 && next[1] ==0){
                return resultRec = new int [] {currentPosition[0], currentPosition[1]};
            }


        }



        previousPosition [0] = currentPosition[0];
        previousPosition [1] = currentPosition[1];
//        System.out.print(previousPosition[0]);
//        System.out.println(previousPosition[1]);

        currentPosition[0] = next[0];
        currentPosition[1] = next [1];
//        System.out.print(next[0]);
//        System.out.println(next[1]);


        findTailRecursive(currentPosition,previousPosition);

        return resultRec = new int []{currentPosition[0], currentPosition[1]};
    }
    //---------------------------------------------------------------------------------------------------------------
    public void print(){
//        System.out.println("Head position: (" + headPosition[0] + ", " + headPosition[1] + ")");
//        System.out.println("Tail position: (" + result[0] + ", " + result[1] + ")");
//        System.out.println("Length: " + result[2]);
//        System.out.println("Exhaustive Checks: " + exhaustiveChecks);
          System.out.println(resultRec[0] +"," + resultRec[1]);
    }
    //---------------------------------------------------------------------------------------------------------------
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }
    //---------------------------------------------------------------------------------------------------------------
    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
    //---------------------------------------------------------------------------------------------------------------
    private static int getRecursiveChecks(){
        return recursiveChecks;
    }
    //---------------------------------------------------------------------------------------------------------------
    public int neighbors(int row, int col){

        int neighbors = 0;

        for(int i = -1; i<=1; i = i + 2){
            if(row + i > 0  && row + i < game.length && game[row + i][col]) {
                neighbors++;
            }
            if(col + i > 0  && col + i < game.length && game[row][col + i]) {
                neighbors++;
            }
        }
        return neighbors;
    }
    //---------------------------------------------------------------------------------------------------------------





}
