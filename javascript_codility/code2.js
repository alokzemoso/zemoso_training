//task2 --> Starting Index of Largest Serial Sequence (O(N)).

var A = [4,5,6,7,1,2,3];
var index = 0, count = 1;
var temp_index = 0, temp_count = 1;
var slice_len,start_index;
var N = A.length;
    
for (var i =0; i<N-1; i++ ){
	if (A[i] < A[i+1]){
	        if(temp_count === 1){
	                temp_index = i;
	        }
    		temp_count++;
    	}
        else{
            if(temp_count > count){
                count = temp_count; 
                index = temp_index;
            }
	        temp_count = 1;
            temp_index = 0;
        }
}
if (temp_count > count){
	slice_len = temp_count;
        start_index = temp_index;
}else{
        slice_len = count;
        start_index = index;
}
console.log("Starting Index : "+start_index);
console.log("Slice Length   : "+slice_len);

