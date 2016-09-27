import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.*; 

public class zalgebra{
	public static void main(String[] args) {
		
		//ZDigit
		ZDigit zd = new ZDigit('0');
		System.out.println();
		
		//ZNumber - Constructor 1
		ZNumber zn = new ZNumber('A','B','C','D');
		System.out.println("toString:"+zn+"\n");

		//ZNumber - Constructor 2
		ZNumber zn1 = new ZNumber("AB");
		System.out.println("toString:"+zn1+"\n");
		//ZNumber - Constructor 3		
		ArrayList<Character> array=new ArrayList<Character>();
		array.add('A');
		array.add('B');
		array.add('C');
		ZNumber zn2 = new ZNumber(array);
       		System.out.println("toString:"+zn2+"\n");
	
		System.out.println(zn1);
       		System.out.printf("%.0f\n",zn1.toDecimal());
		System.out.println(zn);
		System.out.printf("%.0f\n",zn.toDecimal());
		System.out.println(zn2);
       		System.out.printf("%.0f\n",zn2.toDecimal());
		System.out.println();
		
		System.out.println("Get Digits:");
       		ZDigit[] z=zn.getDigits("ABCab");
	}
}

class ZDigit{
	
	ZDigit(char x){
		String p="[A-Z0]";
		Pattern r=Pattern.compile(p);
		Matcher m =r.matcher(Character.toString(x));
		if(m.find()){
			System.out.println(x +"--> Character Accepted");
		}
		else{
			throw new IllegalArgumentException("Not ZDigit");
		}

	}
}


class ZNumber{

	StringBuilder sb = new StringBuilder("");
	
	//Constructor 1
	ZNumber(char... c){
		for(char i:c){
			ZDigit z=new ZDigit(i);
			sb.append(i);	
		}
	}

	//Constructor 2
	ZNumber(String c){
		for(int i=0;i<c.length();i++){
			ZDigit z=new ZDigit(c.charAt(i));
			sb.append(c.charAt(i));	
		}
	}

	//Constructor 3
	ZNumber(ArrayList<Character> c){
		for(char i:c){
			ZDigit z=new ZDigit(i);
			sb.append(i);	
		}
	}

	
	//Method to Override toString()
        @Override
	public String toString(){
 	   	return sb.substring(0);
        }

	//Method to return A as 1, B as 2...etc    	
	int value(char a){
	    	if(a=='0')
	    		return 0;
	    	else
		    	return (int)a-64;
	}

	//Method to output Decimal Value of ZNumber
	double toDecimal(){
	    	double d=0;
	    	for(int i=sb.length()-1,j=0;i>=0;i--,j++){
	    		d=d+Math.pow(26,i)*value(sb.charAt(j));
	    	}
	    	return d;
	}
	
	public ZDigit[] getDigits(String s){
	    	int p=s.length();
	    	ZDigit[] z=new ZDigit[p]; 
	    	for(int i=0;i<s.length();i++){
	    		try{
	    			ZDigit zt=new ZDigit(s.charAt(i));
	    			z[i]=zt;
	    		}
	    		catch(Exception e){
	    			continue;
	    		}
	    	}
	    	return z;
	}
}
