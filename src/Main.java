import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/Data");
        String result = "";
        boolean mazeCompleted = false;
        int row = 0;
        int col = 0;
        boolean moveLeft = true;
        boolean moveRight = true;
        boolean moveDown = true;
        boolean moveUp = true;
        while (mazeCompleted == false) {
            if(gameWon(row,col,maze) == true){
                mazeCompleted = true;
                result += "(" + row + ", " + col + ")";
            }
            else if(goLeft(row,col,maze) == true && moveLeft == true){
                result += "(" + row + ", " + col + ") ---> ";
                col-=1;
                moveRight = false;
                moveLeft = true;
                moveDown = true;
                moveUp = true;
            }
            else if(goRight(row,col,maze) == true && moveRight == true){
                result += "(" + row + ", " + col + ") ---> ";
                col+=1;
                moveRight = true;
                moveLeft = false;
                moveDown = true;
                moveUp = true;
            }
            else if(goDown(row,col,maze)==true && moveDown == true){
                result += "(" + row + ", " + col + ") ---> ";
                row+=1;
                moveRight = true;
                moveLeft = true;
                moveDown = true;
                moveUp = false;
            }
            else if(goUp(row,col,maze)==true && moveUp == true){
                result += "(" + row + ", " + col + ") ---> ";
                row-=1;
                moveRight = true;
                moveLeft = true;
                moveDown = false;
                moveUp = true;
            }
            else{
                maze[row][col] = "#";
                row = 0;
                col = 0;
                result = "";

            }
        }
        System.out.println(result);
    }
    public static boolean gameWon(int row, int col, String[][] maze){
        if(row == maze.length-1 && col == maze[0].length-1 ){
            return true;
        }
        return false;
    }
    public static boolean goLeft(int row, int col, String[][] maze){
        try{
            if (maze[row][col-1].equals(".")){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }
    public static boolean goRight(int row, int col, String[][] maze){
        try{
            if (maze[row][col+1].equals(".")){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }
    public static boolean goDown(int row, int col, String[][] maze){
        try{
            if (maze[row+1][col].equals(".")){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }
    public static boolean goUp(int row, int col, String[][] maze){
        try{
            if (maze[row-1][col].equals(".")){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }
}