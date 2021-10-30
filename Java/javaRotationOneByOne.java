public class Main
{
    public void leftRotate(int arr[], int d, int n){
        for(int i=0;i<d;i++)
            rotateLeftByOne(arr, n);
	/* Explanation :
	 * Looping for d times to call rotateLeftByOne with 2 parameters (arr, n)
	 */
    }
    public void rotateLeftByOne(int arr[], int n){
        int temp = arr[0];
        for(int i=0;i<n-1;i++)
            arr[i] = arr[i+1];
        arr[n-1] = temp;
	//this algorithm works like rotate first value into the last array value. so, when leftRotate function is looping to call rotateLeftByOne, array of leftRotate will be rotate from first index into last index
	/* Explanation :
	 * Looping for n times and move from arr[index+1] to arr[index]. then, add temp value into arr[n-1]
	 */
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
/* This algorithm has :
 * Time complexity : O(n * d)
 * Auxiliary Space : O(1)
 */

