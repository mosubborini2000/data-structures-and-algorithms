public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        rev(arr);
        System.out.println("----");
        
        int[] arr2 = {1, 2, 3, 4, 5};
        rev2(arr2);
    }
    
    public static void rev(int[] a) {

        
        int n = a.length;
        int[] b = new int[n];
        int j = n;

        
        
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        
        for (int k = 0; k < n; k++) {
            System.out.println(b[k]);
        }
    }

    public static void rev2(int[] array) {
        for (int i = array.length - 1; i > -1; i--) {
            System.out.println(array[i]);
        }
    }
}