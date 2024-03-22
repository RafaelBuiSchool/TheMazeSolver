import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class MazeSolver {
    String[][] maze;
    int rowCount;
    int colCount;
    public MazeSolver(String fileName){
       this.maze = getMaze(fileName);
    }

    public String solve(){
        boolean[][] visited = new boolean[rowCount][colCount];
        return solveSolution(0,0,"",visited);
    }

    private String solveSolution(int row, int col, String solution, boolean[][] visited) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || maze[row][col].equals("#") || visited[row][col]) {
            return null;
        }
        if (row == rowCount - 1 && col == colCount - 1) {
            return solution + "(" + row + ", " + col + ")";
        }

        visited[row][col] = true;

        String goLeft = solveSolution(row, col - 1, solution + "(" + row + ", " + col + ") ---> ", visited);
        String goRight = solveSolution(row, col + 1, solution + "(" + row + ", " + col + ") ---> ", visited);
        String goUp = solveSolution(row - 1, col, solution + "(" + row + ", " + col + ") ---> ", visited);
        String goDown = solveSolution(row + 1, col, solution + "(" + row + ", " + col + ") ---> ", visited);

        visited[row][col] = false;

        if (goLeft != null || goRight != null || goUp != null || goDown != null) {
            if (goLeft != null && (goRight == null || goLeft.length() + 1 > goRight.length()) && (goUp == null || goLeft.length() + 1 > goUp.length()) && (goDown == null || goLeft.length() + 1 > goDown.length())) {
                return goLeft;
            } else if (goRight != null && (goUp == null || goRight.length() + 1 > goUp.length()) && (goDown == null || goRight.length() + 1 > goDown.length())) {
                return goRight;
            } else if (goUp != null && (goDown == null || goUp.length() + 1 > goDown.length())) {
                return goUp;
            } else {
                return goDown;
            }
        } else {
            return null;
        }
    }
    private String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        rowCount = fileData.size();
        colCount = fileData.get(0).length();

        String[][] maze = new String[rowCount][colCount];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;
    }
}