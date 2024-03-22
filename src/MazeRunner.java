public class MazeRunner {
    public static void main(String[] args){
        MazeSolver test = new MazeSolver("src/Data");
        System.out.println(test.solve());
    }

}
