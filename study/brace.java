import java.util.*;
import java.lang.*;
class brace{
	public static void main(String[] args){
		String A = "(())))(";
		int l  = A.length();
		
		int i;
		for(i = 0; i<l-1 ; i++){
			char[] B = new char[i+1];
			char[] C = new char[l-i-1];
			int count1=0,count2=0;
			int p=0;
			for(int j = 0;j<=i;j++){
				B[j] = A.charAt(p);
				p++;
			}
			for(int j = 0;j<=i;j++){
				System.out.print(B[j]+" ");
			}
			System.out.println();
		
			int z=i+1;
			for(int k = 0;k<C.length;k++){
				
				C[k]=A.charAt(z);
				z++;
				
			}
			for(int j = 0;j<C.length;j++){
				System.out.print(C[j]+" ");
			}
			System.out.println("\n");
			for(int k=0;k<C.length;k++){			
				if(C[k]==')')
					count2++;
			}
			System.out.println(count2);
			for(int y=0;y<B.length;y++){
			if(B[y]=='(')
				count1++;
			}
			System.out.println(count1);
			if(count1==count2){
				break;
			}
						
		}
		System.out.println(i+1);
	}	
}	

