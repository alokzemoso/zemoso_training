//Equi-pairs in complexity O(N)

import java.util.*;
import java.io.*;

class pair{
	public static void main(String[] args){
		
		//test cases-
		int[] A = {4,3,1,1,1,1,5,3,1};
		//int[] A = {4,1,5,5,6,3,2};
		//int[] A = {8,3,5,2,10,6,7,9,5,2};
		//int[] A = {1,2,3,4,3,2,1};
		//int[] A = {1,2,3,3,6,2,2,3};
		//int[] A = {1,1,1,1,1};

		int N = A.length;
		int i = 0;
		int j = N-1;
		
		//to calculate cumilative sum from top
		float Top = A[i++]; 
		
		// to calculate cumilative sum from bottom
		float Bottom = A[j--]; 
		
		//To find sum of array
		float sumArray= 0;
		for(int a = 0; a<A.length; a++){
			sumArray+=A[a];
		}
		
		float maxSumPair = sumArray/3;
		int count =0;
		
		while((j-i)>1){
			if(Top == Bottom){
				if((Top + A[i] > maxSumPair) || (Bottom + A[j] > maxSumPair)){
					break;
				}else{
					Top += A[i];
			                Bottom += A[j];
              				i++;
              				j--;
				}
			}else if(Top < Bottom){
				Top += A[i];
			        i++;
			}else{
				Bottom += A[j];
			        j--;
			}
		}
		
		if(Top == sumInnerSet(A,i,j)){
			count++;
		}
		if(count>0){
			System.out.println("Yes,Count  :  "+count);
			System.out.println("Equipair   : ("+i+","+j+")");
			System.out.println("Pairs are  : (0,"+(i-1)+"),("+(i+1)+","+(j-1)+"),("+(j+1)+","+(N-1)+")");
		}else{
			System.out.println("No Equi - Pair!");
		}
	}
	
	// To calculate sum of innerset (i+1 to j-1)
	public static float sumInnerSet(int[] A, int i , int j){
		int sum = 0;
		for(int k = i+1; k<=j-1; k++){
			sum+=A[k];
		}
		return sum;
	}
}	
