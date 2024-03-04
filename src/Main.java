
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
        String[][] testPart2 = {{".","#","#","."},
                {".","#","#","."},
                {".",".",".","."},
                {".","#","#","."},
                {".","#","#","."},
                {".","#","#","."},
                {"#","#","#","."}};
        MazeSolver test2 = new MazeSolver(testPart2);
        System.out.println(test2.mazeAnswerPartTwo());
    }
}