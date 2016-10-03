import java.util.*;
import java.io.*;

public class sudoku{

	
	// For reading sudoku grids from text file
	public static int[][] readSudoku(int nextVal){	
		int[][] arr = new int[10][10];
		try{
			Scanner in = new Scanner(new FileReader("grid.txt"));
		
			int j=0;	
			while(nextVal>0){
				in.nextLine();
				nextVal--;
			}
			int num_lines = 10;		
			while(num_lines>1){
				String a=in.nextLine();
				if(a.startsWith("Gri")){
					continue;
				}
				else{
					int[] resultArray = new int[32];
					int i;

					//Spliting the read line and adding it to an integer array
				   	 String[] temp = a.split("");
				  	 i = 0;
					 for(String s: temp) {
					 	resultArray[i] = Integer.parseInt(s);
						i++;
					 }	
					 int n = i;
					
					 // converting the sudoku read to a 2d array
					 for (i = 0; i < n; i++) {
			   		 	arr[j][i]=resultArray[i];
			   		 }
				    	 j++;
				}
				num_lines--;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return arr;	
	}	

	public static int sum=0;
        public static void main(String[] args)throws IOException{

		//Number of sudokus to solve
    		int numberOfSudoku=50;
		for(int nextVal=0;nextVal<numberOfSudoku;nextVal++){
			System.out.println("Solution:Grid-"+(nextVal+1));
    			int[][] arr;
			arr = readSudoku(nextVal*10);
   			if (!solve(arr)){
                        	System.out.println("No Solution");
			}else{
				//To print solved sudoku				
				for(int j=0;j<9;j++){
					for(int k=0;k<9;k++){
						System.out.print(arr[j][k]+" ");
					}
					System.out.println();
				}
			}
			System.out.println();
			sum+=arr[0][0]*100+arr[0][1]*10+arr[0][2]*1;
		}
		System.out.println("Total Sum:"+sum);
	}
	
	public static boolean isValid(int i, int j, int v, int[][] arr){

		//Row
		for (int k = 0; k < 9; k++){
        	    if (v == arr[i][k]){
        	        return false;
		    }
		}

		//Coloumn
        	for (int k = 0; k < 9; k++){ 
        	    if (v == arr[k][j]){
        	        return false;
		    }
		}
 
        	int r = (i / 3) * 3;
        	int c = (j / 3) * 3;
		
		//3*3 matrix
        	for (int k = 0; k < 3; ++k){ 
        	    for (int m = 0; m < 3; ++m){
        	        if (v==arr[r + k][c+m]){
        	            return false;
			}
		    }
        	}
        	return true;
    	}
 
   	public static boolean solve(int[][] arr){
    		for (int i = 0; i < 9; i++){
        	    for (int j = 0; j < 9; j++){

			//If value already exists continue
        	        if (arr[i][j] != 0)
        	            continue;
        	        for (int v = 1; v <= 9; v++){
        	            if (isValid(i, j, v, arr)){
        	                arr[i][j] = v;
        	                if (solve(arr))
        	                    return true;
        	            }
        	        }
        	        arr[i][j] = 0; 
        	        return false;
        	    }
        	}
        	return true;
    	}




			
}

		

