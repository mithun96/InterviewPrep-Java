// search for element in sorted array but checking mid and then dividing left and right


class BinarySearch{

	public static void main(String args[]){


        int arr[] = {1, 5, 13, 33, 64, 76};
        int x = 3;

        search(arr, x);
  
	}

	// Recursion 
	public int search(int arr[], int left, int right, int x){
		if(left > right){
			return -1;   // ERROR!!
		}
		int mid = (right + left) / 2;

		if(x < arr[mid]){ // check left
			search(arr, left, mid - 1, x);
		}
		else if(){
			search(arr, mid + 1, rigth, x);
		}
		else{
			return mid;   // Return FOUND index
		}

	}
}