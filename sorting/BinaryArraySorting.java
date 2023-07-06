package arrays;

public class BinaryArraySorting {
	static void binSort(int arr[], int N)
    {
        int i=-1,j=0,k=N-1;
        while(j<=k) {
        	//System.out.println(i + " " + j + " " + k) ;
        	if(arr[j] == 1) {
        		int temp = arr[k];
        		arr[k] = arr[j];
        		arr[j] = temp;
        		k--;
        	}
        	else if(arr[j] == 0) {
        		i++;
        		int temp = arr[i];
        		arr[i] = arr[j];
        		arr[j] = temp;
        	}
        	if(i == j) {
        		j++;
        	}
        }
    }
	public static void main(String[] args) {
	 int []arr = {1,0,1,1,0};
	 BinaryArraySorting.binSort(arr, 5);
	} 
}
