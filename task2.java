import java.util.*;

class task2{
	public static void main(String[] args){

		//testcase1
		int[] A = {4,3,1,1,1,1,5,3,1};
		int N = A.length, count = 0;
		for(int i = 0; i<N; i++){
			for(int j=i+2;j<N;j++){
				int slice_A,slice_B,slice_C;
				slice_A = slice(A,0,i-1);
				slice_B = slice(A,i+1,j-1);
				slice_C = slice(A,j+1,N-1);
				//System.out.println(slice_A);
				//System.out.println(slice_B);
				//System.out.println(slice_C);
				if(slice_A == slice_B){
					if(slice_B == slice_C){
						count++;
					}
				}
				else continue;
			}
		}
		if(count>0){
			System.out.println("Total Count:"+count);
		}else{
			System.out.println("Not found");
		} 
	}
	public static int slice(int[] A,int i,int j){
		int sum = 0;
		while(i<=j){
			sum+=A[i];
			i++;
		}
		return sum;
	}
}
			
