package interview;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/6 0006 20:46
 * @modified By:
 */
public class QuickerSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 6, 7, 8};
        int[] ints = quickerSort(arr, 0, 5);
        System.out.println(ints.toString().toCharArray());

    }

    public static int[] quickerSort(int [] arr,int left,int right) {
        int l = left;
        int r = right;
        int mid = (left + right)/2;
        while (l<r) {
            while (arr[l] <= arr[mid]) {
                l++;
            }
            while (arr[r] > arr[mid]) {
                r--;
            }
            //这里
            if (l == r) {
                break;
            }
            swap(arr,l,r);
            if (arr[l] == arr[mid] ) {
                r--;
            }
            if (arr[r] == arr[mid]) {
                l++;
            }
        }
        if (l==r) {
            l++;
            r--;
        }
        //问题就在这里
        if (left<r) {
            quickerSort(arr, mid, r);
        } else if (l<right){
            quickerSort(arr, l, mid);
        }
        return arr;
    }



    public static void swap(int[] arr, int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }
}
