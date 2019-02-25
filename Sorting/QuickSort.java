

// Time: On average = O(n log(n)) but on worst case = O(n^2)
// Memory: O(logn) --> which is used for the recursion stack memory
// Description: Pick pivot and swap elements that are smaller than pivot and largers than pivot. Eventually it will be sorted


class QuickSort
{
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
  
        quickSort(arr, 0, arr.length - 1);
    }

    // Main function that sorts arr[l..r] using
    static void quickSort(int arr[], int left, int right)
    {
    	int index = partition(arr, left, right);

    	// Sort left side
        if (left < index -1) 
        {
        	quickSort(arr, left, index - 1);
        }

        // Sort right side
        if(right > index)
        {
        	quickSort(arr, index, right);
        }
    }


    // find pivot and swap accordingly 
    static int partition(int arr[],, int left, int right)
    {
        /* find a pivot */
        int piv = arr[(right + left) / 2];
        
        while(left < right){
        	// Find element on left that should be swapped
	 		while(arr[left] < piv)
	 			left++;

	 		// Find element on right that should be swapped
	 		while(arr[right] > piv)
	 			right--;

	 		if(left < right){
	 			// Swap left with right
		 		// int temp = arr[right];
		 		// arr[right] = arr[left]
		 		// arr[left] = temp;
		 		swap(arr, left, right);
		 		right--;
		 		left++;
	 		}
	 		
        }

        return left;  // Return the diving index. the index that splits left and right
 		
    }

}
