public class SnakeGame {
    private boolean[][] game;
    private int [] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    private int [] resultExh; // i made to te be able to print the exhaustive result
    private int [] resultRec;// i made to te be able to print the recursive result

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
        //check first cell
        //is part of snake? if no move to next
        //if yes, check how many neighbors are apart of snake and add to length
        //if only one neighbor then at the tail or head
        //if two or more neighbors then move to next cell
        //return array[3] (tail position [x,y] and length)

        resetCounters();
        int tailRow = 0;
        int tailCol = 0;
        int length = 0;

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++){
                if (game[i][j]){
                    length++;
                    if (neighbors(i,j) == 1 && (game[i] != game[headPosition[0]]) && (game[i] != game[headPosition[0]])){
                        tailRow = i;
                        tailCol = j;
                        resultExh = new int [] {tailRow,tailCol,length};
                    }
                }
            }
        }

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++){
                if(i == tailRow && j == tailCol){
                    exhaustiveChecks++;
                    return resultExh;

                }else{
                    exhaustiveChecks++;
                }
            }
        }

        resultExh = new int [] {tailRow,tailCol,length};
        return resultExh;
    }

    //---------------------------------------------------------------------------------------------------------------

    public int [] findTailRecursive(){
       // result = new int [] {tailRow,tailCol,length};
        resetCounters();
        int length = 1;

        recursiveChecks++;
        return findTailRecursive(headPosition,headPosition, length);
    }

    //---------------------------------------------------------------------------------------------------------------

    private int [] findTailRecursive(int [] currentPosition, int [] previousPosition, int length){
        int [] next = new int[2]; //will act as the new currentPosition

        //checks the top of element (i = -1), then skips over element (i+2) to check the bottom (i = 1)
        //checks the left of the element (i = -1), then skips the element (i+2) and checks the right (i = 1)
        for(int i = -1; i<=1; i = i + 2){

            //checks if the future row index is within bounds of array and whether it is true
            if(currentPosition[0] + i >= 0  && currentPosition[0] + i < game.length && game[currentPosition[0] + i][currentPosition[1]]) {
//                recursiveChecks++;
                //checks to make sure that the future element is not the previous one
                if(currentPosition[0] + i != previousPosition[0]){
                    recursiveChecks++;
                    length++;
                    next[0] = currentPosition[0] + i;
                    next[1] = currentPosition[1];
                }

            }
            //checks if the future col index is within bounds of array and whether it is true
            if(currentPosition[1] + i >= 0  && currentPosition[1] + i < game.length && game[currentPosition[0]][currentPosition[1] + i]) {
//                recursiveChecks++;
                //checks to make sure that the future element is not the previous one
                if(currentPosition[1] + i != previousPosition[1]){
                    recursiveChecks++;
                    length++;
                    next[0] = currentPosition[0];
                    next[1] = currentPosition[1] + i;
                }
        }
        // Base Case: if there are no neighbors left except for the previous element, then current element is the tail
        }if(next[0] == 0 && next[1] ==0){
            return resultRec = new int [] {currentPosition[0], currentPosition[1],length};
        }
        //next acts as  the current position and currentPosition acts as the previous position
        findTailRecursive(next,currentPosition,length);
        return resultRec;
    }
    //---------------------------------------------------------------------------------------------------------------

    public void printExh(){
        System.out.println("Tail: (" + resultExh[0] + "," + resultExh[1] + "), Length: " + resultExh[2] + ", Checks: " + exhaustiveChecks);
    }

    //---------------------------------------------------------------------------------------------------------------

    public void printRec(){
        System.out.println("Tail: ("+resultRec[0] +"," + resultRec[1] + "), Length: " + resultRec[2] + ", Checks: " + recursiveChecks);
    }
    //---------------------------------------------------------------------------------------------------------------
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }
    //---------------------------------------------------------------------------------------------------------------
    static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
    //---------------------------------------------------------------------------------------------------------------
    static int getRecursiveChecks(){
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
}
