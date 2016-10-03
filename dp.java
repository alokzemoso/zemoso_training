import java.util.*;
import java.lang.*;
import java.io.*;

class dp{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n for square matrix:");
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		System.out.println("Enter elements:");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=in.nextInt();
			}
		}
		display(arr);
		System.out.println(Arrays.deepToString(arr));
		int[][] dp = new int[n+1][n+1];
		dp[0][0]=arr[0][0];
		for(int i=1; i<n; i++){
			dp[i][0] = dp[i-1][0]+arr[i][0];
			//System.out.println("Row1:"+dp[i][0]);
		}
		for(int j=1; j<n; j++){
			dp[0][j] = dp[0][j-1]+arr[0][j];
			//System.out.println("Col1"+dp[0][j]);
		}
		for(int i=1; i<n;i++){
			for(int j=1; j<n; j++){
				dp[i][j] = arr[i][j]+min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
				//System.out.println("A-->"+ dp[i][j]);
			}
		}
		System.out.println("Minimum Cost Path:"+ dp[n-1][n-1]);	
	}
	public static int[][] display(int[][] A){
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A.length; j++){
				System.out.print("|"+A[i][j]+" ");
			}
			System.out.println();
		}
		return A;
	}
	public static int min(int a, int b, int c){
		return Math.min(a,Math.min(b,c));
	}
}
