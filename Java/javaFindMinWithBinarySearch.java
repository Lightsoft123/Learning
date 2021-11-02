import java.util.*;

public class Main
{
    static int binarySearch(int arr[], int low, int high){
        if(low > high) return 0;//if start index > end index, then return 0 (means, the min index is on 1st index
        if(low == high) return low;//if start index equals end index, then return start index as return index
        
        int mid = (low+high)/2;//get mid index
        if(mid < high && arr[mid] > arr[mid+1]) return mid+1; //if mid index < high index and data from index mid > index mid+1, then return index mid+1
        if(mid > low && arr[mid-1] > arr[mid]) return mid; //if mid index > low index and data from index mid < index mid-1, then return index mid
        if(arr[high] > arr[mid]) return binarySearch(arr, low, mid-1); //if data from index high > index mid, then return binarySearch function (it means call back itself function)
        return binarySearch(arr, mid+1, high); //return binarySearch function with parameter data, index mid+1, index high
    }
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int length_data = scan.nextInt();
	    int[] data = new int[length_data];
	    for(int i = 0; i < length_data; i++){
	        data[i] = scan.nextInt();
	    }
	    System.out.println(data[binarySearch(data, 0, length_data-1)]); //index found, then print data with the index of binarySearch function return
	}
}

