import java.util.*;
public class Main
{
    //Swap 2 elements in array
    public static void swap(int arr[], int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    //Make a partition function to sort from low to high
    public int partition(int arr[], int low, int high){
        int i = low-1;
        int pivot = arr[high];
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1; //return the current step
        }
    public void quickSort(int arr[], int low, int high){
        if(low < high){
            int part = partition(arr, low, high);
            quickSort(arr, low, part-1);//quicksort array from low until partition-1
            quickSort(arr, part+1, high);//quicksort array from partition+1 until high
        }
    }
    public void printArr(int arr[], int sizeArr){
        for(int i=0; i<sizeArr; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main m = new Main();
        System.out.print("How Many Data : ");
        int N = scan.nextInt();
        int[] data = new int[N];
        for(int i = 0; i<N;i++){
            data[i] = scan.nextInt();
        }
        int data_length = data.length;
        m.quickSort(data, 0, data_length-1);
        m.printArr(data, data_length);
    }
}
