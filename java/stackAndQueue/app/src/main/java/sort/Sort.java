package sort;

public class Sort {

    public void InsertionSort(int arr[]) {
        int length = arr.length;
        for (int i = 1; i < length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }
    // .......................... Merge Sort ........................
    public void mergeSort(int[] arr, int length) {
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            rightArr[i - mid] = arr[i];
        }
        mergeSort(leftArr, mid);
        mergeSort(rightArr, length - mid);

        merge(arr, leftArr, rightArr, mid, length - mid);

    }

    public void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0;
        while (i < left && j < right){
            if (leftArr[i] <= rightArr[j]) {
                arr[i + j] = leftArr[i];
                i++;
            } else {
                arr[i + j] = rightArr[j];
                j++;
            }
        }
        while (i < left) {
            arr[i + j] = leftArr[i];
            i++;
        }
        while (j < right) {
            arr[i + j] = rightArr[j];
            j++;
        }

    }

    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int j = (begin-1);

        for (int i = begin; i <=end ; i++) {

            if (arr[i]<pivot){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,end,j+1);
        return j+1;

    }
    public static void swap(int[] arr, int i, int low){
        int temp;

        temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }

}


