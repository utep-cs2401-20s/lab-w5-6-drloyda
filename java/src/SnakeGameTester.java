public class SnakeGameTester {
    public static void main(String[] args) {
        boolean[][] test = new boolean[][]{ {false, false, false, false, false, false, false, false},
                                            {false, false, false, false, false, false, false, false},
                                            {true, true, true, true, true, false, false, false},
                                            {true, false, false, false, true, false, false, false},
                                            {true, false, false, false, true, false, false, false},
                                            {true, false, false, false, true, false, false, false},
                                            {true, false, false, false, false, false, false, false},
                                            {true, false, false, false, false, false, false, false},};
        SnakeGame game = new SnakeGame(test,7,0);
//        game.findTailExhaustive();
//        game.findTailExhaustive();
//        game.print();
          game.findTailRecursive();
          game.print();


    }
}
