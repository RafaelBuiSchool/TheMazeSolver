
public class Main {
    public static void main(String[] args) {
        String[][] test = {{".","#","#","#"},
                {".","#","#","#"},
                {".",".",".","."},
                {"#","#","#","."},
                {"#","#","#","."},
                {"#","#","#","."},
                {"#","#","#","."}};
        MazeSolver test1 = new MazeSolver(test);
        System.out.println(test1.mazeAnswer());
    }
}