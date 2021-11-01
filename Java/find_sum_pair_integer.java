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
    static int save_left, save_right;
    public void pairSum(int arr[], int n, int sum){
        int i;
        for(i = 0; i < n-1; i++)
            if(arr[i] > arr[i+1]) break;
            //this for is only for sorted and rotated data
            //i = 0 -> 11 > 15? no
            //i = 1 -> 15 > 26? no
            //i = 2 -> 26 > 38? no
            //i = 3 -> 38 > 9? yes, break
        int left = (i + 1) % n;//3+1 % 6 = 4
        int right = i;//4
        //save left variable and right variable if the sum value was found on sum of left and right variable
        save_left = -1;
        save_right = -1;
        while(left != right){
            if(arr[left] + arr[right] == sum){
                save_left = left;
                save_right = right;
                break;
            }
            if(arr[left] + arr[right] < sum){
                left = (left+1) % n;
            }
            else{
                right = (n + right - 1) % n;
            }
        }
    }
    public void printArr(int arr[], int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //sample data {11, 15, 26, 38, 9, 10}, sum = 35
        Scanner scan = new Scanner(System.in);
        Main m = new Main();
        System.out.print("How Many Data : ");
        int N = scan.nextInt();
        System.out.print("Input Sum : ");
        int sum = scan.nextInt();

