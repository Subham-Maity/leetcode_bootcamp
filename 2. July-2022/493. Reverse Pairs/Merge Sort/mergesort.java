public class marge_sort {
    public static void conquer(int []arr , int startidx, int mid , int endidx ) {
        int[] merged = new int[endidx - startidx + 1];//last element
        int leftStart = startidx;
        int rightStart = mid + 1;
        int countOfMergedArray = 0;

        while (leftStart <= mid && endidx >= rightStart) {
            if (arr[leftStart] < arr[rightStart]) {
                merged[countOfMergedArray] = arr[leftStart];
                leftStart++;
            } else {
                merged[countOfMergedArray] = arr[rightStart];
                rightStart++;
            }
            countOfMergedArray++;
        }
        while (leftStart <= mid) {
            merged[countOfMergedArray] = arr[leftStart];
            leftStart++;
            countOfMergedArray++;
        }
        while (rightStart <= endidx) {
            merged[countOfMergedArray] = arr[rightStart];
            rightStart++;
            countOfMergedArray++;

        }
        for (int i = 0; i < merged.length; i++) {
            arr[startidx++] = merged[i];
        }
    }


    public static void divide(int arr[], int si, int ei) {
        if (si == ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }



    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        int n = arr.length;
        divide(arr, 0, n - 1);
        //
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + "");
        }
        System.out.println();

    }
}
