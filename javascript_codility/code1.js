//task 1--> Minimum Absolute Diff of Adjacent Pairs 

var A = [1,3,3,11,2,1,7,5];
A.sort();//[1,1,2,3,3,5,7,11]
var N = A.length;
var min = Math.abs(A[0]-A[N-1]);

if(A.length === 1){
    min=-2;
}else{
	for(var i=0; i<N; i++){
    		if(Math.abs(A[i]-A[i+1]) < min){
        		min=Math.abs(A[i]-A[i+1]);
        	}
	}
}

if(min>100000000){
	min=-1;
}

console.log("Minimum Abs Diff:"+min);


