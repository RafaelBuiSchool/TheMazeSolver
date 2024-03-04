public class MazeSolver {
    private String [][] arr;
    public MazeSolver(String[][] arr){
        this.arr = arr;
    }
    //Use this method for part one of the Project
    public String mazeAnswerPartOne(){
        String result = "";
        for(int row = 0; row < arr.length;row++){
            for(int col = 0; col < arr[0].length;col++){
                if(arr[row][col].equals(".")){
                    if(row == arr.length-1 && col == arr[0].length-1){
                        result+= "("+row + ", " + col + ")";
                    }
                    else{
                        result+= "("+row + ", " + col + ") ---> ";
                    }
                }
            }
        }
        return result;
    }
    public String mazeAnswerPartTwo(){

    }
}
