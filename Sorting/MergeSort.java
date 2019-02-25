// Time: O(nlog(n))
// Space: O(n) used for helper array
// Description: Divide arary in halves and then merge (sort) from bottom up. 

class MergeSort
{
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int[] helper = new int[arr.length];
  
        mergeSort(arr, helper, 0, arr.length-1);
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int helper[] int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            mergeSort(arr, helper, l, m);
            mergeSort(arr , helper, m+1, r);
 
            // Merge the sorted halves
            merge(arr, helper, l, m, r);
        }
    }


     // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int helper[], int l, int m, int r)
    {
        /*Copy data to helper arrays*/
        for(int i = l, i < r; i++){
            helper[i] = arr[i];
        }
 
        /* Merge the arrays */
 
        // Initial indexes of first and second subarrays
        int index = l;
        int leftIndex = l;
        int rightIndex = m + 1;

        // Initial index of merged subarry array
        int k = l;
        while (leftIndex <= m && rightIndex <= r)
        {
            if (helper[leftIndex] <= helper[rightIndex])
            {
                arr[index] = helper[leftIndex++];
            }
            else
            {
                arr[index] = helper[rightIndex++];
            }
            index++;
        }
 
        /* Copy remaining elements of left side ONLY 
            [1, 4, 5 || 2, 8 , 9]
            in the example above, the right number don't have to be moved again!
        */
        int remaining = middle - leftIndex;
        for(int i = 0; i <= remaining; i++){
            arr[index + i] = helper[leftIndex + i];
        }

        // or can do this way. 
        // for(int j = leftIndex; i < m; i++){
        //     arr[index++] = helper[leftIndex++];
        }
    }

    // This method will take more space but easier to understand
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int helper[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];

        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i++];
            }
            else
            {
                arr[k] = R[j++];
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k++] = L[i++];
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k++] = R[j++];
        }
    }
}
