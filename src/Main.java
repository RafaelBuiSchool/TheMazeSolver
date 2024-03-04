
public class Main {
    public static void main(String[] args) {
        //PartOneTest
        String[][] test = {{".","#","#","#"},
                {".","#","#","#"},
                {".",".",".","."},
                {"#","#","#","."},
                {"#","#","#","."},
                {"#","#","#","."},
                {"#","#","#","."}};
        MazeSolver test1 = new MazeSolver(test);
        System.out.println(test1.mazeAnswerPartOne());
        //PartTwoTest

    }
}