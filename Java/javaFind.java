/* Find element in rotated array with pivot and binary search
    Note :
    * This algorithm is work when the data is sorted or sorted and rotated
*/
import java.util.*;
public class Main
{
    public int findPivot(int arr[], int low, int high){
        if(high < low) return -1;
        if(low == high) return -1;
        int mid = (low+high)/2;
        if(mid < high && arr[mid] > arr[mid+1]) return mid;
        if(mid > low && arr[mid] < arr[mid-1]) return mid-1;
        if(arr[low] >= arr[mid]) return findPivot(arr, low, mid-1);
        return findPivot(arr, mid+1, high);
        
    }
    public int binarySearch(int arr[], int low, int high, int key){
        if(high < low) return -1;
        int mid = (low+high)/2;
        if(arr[mid] == key) return mid;
        if(key > arr[mid]) binarySearch(arr, mid+1, high, key);
        return binarySearch(arr, low, mid-1, key);
    }
    public int pivotedBinarySearch(int arr[], int arr_length, int key){
        int pivot = findPivot(arr, 0, arr_length-1);
        if(pivot == -1) return binarySearch(arr, 0, arr_length-1, key);
        if(arr[pivot] == key) return pivot;
        if(arr[0] <= key) return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, arr_length-1, key);
    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Main m = new Main();
		System.out.print("How Many Data : ");
		int N = scan.nextInt();
	    System.out.print("Which data to find : ");
		int key = scan.nextInt();
		int[] data = new int[10005];
	    for(int i = 0; i<N;i++){
	        data[i] = scan.nextInt();
	    }
	    int data_length = data.length;
	    if(m.pivotedBinarySearch(data, data_length, key) > -1) System.out.println("Index of the element " + key + " is " + m.pivotedBinarySearch(data, data_length, key));
	    else System.out.println("Index of the element " + key + " is Not Found");
	    System.out.println("Index of the element " + key + " is " + m.pivotedBinarySearch(data, data_length, key));
	}
}

