import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SnakeGameTester{

    //TEST CASE 1: Testing the findTailExhaustive method to see if the correct
    //tail position and length is returned
    @Test
    public void findTailExhaustive1(){
        //The game has the head at (1,1)
        boolean[][] test = new boolean[][]{ {false,false, false, false},
                                             {false,true, true, false},
                                             {false,false, true, false},
                                             {false,false, true, false}};

        //the tail is at (3,2) and the length of the snake is 4
        int [] expect = new int []{3,2,4};
        SnakeGame game = new SnakeGame(test,1,1);

        assertArrayEquals(expect, game.findTailExhaustive());
        //The test passed and (3,2,4) was returned
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 2: Testing the findTailExhaustive exhaustive checks counter, it should increment
    // the counter for each element it searches until it finds the tail
    @Test
    public void findTailExhaustive2(){
        //the game is 8x8 and the tail is at (7,6) and is the 63rd element
        boolean[][] test = new boolean[][]{ {false, false, false, false, true, true, true, false},
                                            {false, false, true, false, true, false, true, false},
                                            {false, false, true, false, true, false, true, false},
                                            {false, false, true, false, true, false, true, false},
                                            {false, false, true, true, true, false, true, false},
                                            {false, false, false, false, false, false, true, false},
                                            {false, false, false, false, false, false, true, false},
                                            {false, false, false, false, false, false, true, false},};

        //the exhaustive checks should be 63 for the given example
        int resultExpect = 63;
        SnakeGame game = new SnakeGame(test,1,2);
        game.findTailExhaustive();

        assertEquals(resultExpect, game.getExhaustiveChecks());
        //The test passed and 63 exhaustive checks were returned
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 3: (EDGE CASE) Testing how the method will handle a 2d that doesn't have the same number of rows ans columns
    @Test
    public void findTailExhaustive3(){
        //The head is at (3,0) and the board is 4x5
        boolean[][] test = new boolean[][]{ {true, true, true, true, true},
                                            {true, false, false, false, true},
                                            {true, false, false, false, true},
                                            {true, false, true, true, true}};


        //the tail should be at (3,2) and the length is 13
        int [] resultExpect = new int[] {3,2,13};
        SnakeGame game = new SnakeGame(test,3,0);

        assertArrayEquals(resultExpect, game.findTailExhaustive());
        //The test failed since the board was not a square and there was an array out of bound exception
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 4: Testing the classes default constructor that initlalizes a board[1][1]
    @Test
    public void findTailExhaustive4(){
        //The board should be null since there is no snake within it

        SnakeGame game = new SnakeGame();

        assertArrayEquals(null, game.findTailExhaustive());
        //The test passed and the contents of the board are null
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 5: Testing when the head and tail are next to each other

    @Test
    public void findTailExhaustive5(){
        //The head is at (3,0) and the board is 4x5
        boolean[][] test = new boolean[][]{ {false, false, false},
                                            {false, true, true},
                                            {false, false, false}};

        //i excpect null since there is no body between the head and the snake
        SnakeGame game = new SnakeGame(test,1,1);

        assertArrayEquals(null, game.findTailExhaustive());
        //The test passed and null was returned
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 1: Testing the findTailRecursive method to see if the correct
    //tail position and length is returned
    @Test
    public void findTaiRecursive1(){
        //The game has the head at (2,0)
        boolean[][] test = new boolean[][]{ {false,false, false, false, false},
                                            {false,false, false, false, false},
                                            {true,true, true, true, false},
                                            {false,false, false, true, false},
                                            {false,false, false, true, false}};

        //the tail is at (4,3) and the length of the snake is 6
        int [] expect = new int []{4,3,6};
        SnakeGame game = new SnakeGame(test,2,0);

        assertArrayEquals(expect, game.findTailRecursive());
        //The test passed and (4,3,6) was returned
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 2: Testing the classes default constructor that initlalizes a board[1][1]
    @Test
    public void findTailRecursive2(){
        //The board should be null since there is no snake within it

        SnakeGame game = new SnakeGame();

        assertArrayEquals(null, game.findTailRecursive());
        //The test failed and the contents of the board are null
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 3: (EDGE CASE) Testing how the method will handle a 2d that doesn't have the same number of rows ans columns
    @Test
    public void findTailRecursive3(){
        //The head is at (3,0) and the board is 4x5
        boolean[][] test = new boolean[][]{ {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, false, false, true},
                {true, false, true, true, true}};


        //the tail should be at (3,2) and the length is 13
        int [] resultExpect = new int[] {3,2,13};
        SnakeGame game = new SnakeGame(test,3,0);

        assertArrayEquals(resultExpect, game.findTailRecursive());
        //The test failed since the board was not a square and there was an array out of bound exception
    }
    //------------------------------------------------------------------------------------------------------------

    //TEST CASE 4: Checking the methods recursive checks counter
    @Test
    public void findTailRecursive4(){
        //the game is 8x8 and the tail is at (7,6) and the length is 19
        boolean[][] test = new boolean[][]{ {false, false, false, false, true, true, true, false},
                {false, false, true, false, true, false, true, false},
                {false, false, true, false, true, false, true, false},
                {false, false, true, false, true, false, true, false},
                {false, false, true, true, true, false, true, false},
                {false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, true, false},};

        //the exhaustive checks should be 19 for the given example
        int resultExpect = 19;
        SnakeGame game = new SnakeGame(test,1,2);
        game.findTailRecursive();

        assertEquals(resultExpect, game.getRecursiveChecks());
        //The test passed and 19 recursive checks were returned
    }
    //----------------------------------------------------------------------------------------------------------

    //TEST CASE 5: Testing when the head and tail are next to each other

    @Test
    public void findTailRecursive5(){
        //The head is at (3,0) and the board is 4x5
        boolean[][] test = new boolean[][]{ {false, false, false},
                                            {false, true, true},
                                            {false, false, false}};

        //The tail should be at (1,2)
        int [] resultExpect = new int[] {1,2,2};
        SnakeGame game = new SnakeGame(test,1,1);


        assertArrayEquals(resultExpect, game.findTailRecursive());
        //The test passed and (1,2,2) was returned
    }


}
