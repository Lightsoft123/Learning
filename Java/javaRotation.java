/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    public void leftRotate(int arr[], int d, int n){
        for(int i=0;i<d;i++){
            rotateLeftByOne(arr, n);
        }
    }
    public void rotateLeftByOne(int arr[], int n){
        int temp = arr[0];
        for(int i=0;i<n-1;i++)
            arr[i] = arr[i+1];
        arr[n-1] = temp;
    }
    public void printArr(int arr[], int n){
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
	public static void main(String[] args) {
	    Main rot = new Main();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		rot.leftRotate(arr, 2, 7);
		rot.printArr(arr, 7);
	}
}

