class Main{
    public void reverseArr(int arr[], int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void leftRotate(int arr[], int d){
        reverseArr(arr, 0, d-1);
        reverseArr(arr, d, arr.length-1);
        reverseArr(arr, 0, arr.length-1);
    }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;
        Main m = new Main();
        m.leftRotate(arr, d);
        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }
}
