public class Main {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6};
 int[] result = insertShiftArray(a,5);
        for (int num : result) {
            System.out.print(num + " ");
        }
        
                System.out.println(" ");

    
        int b[] = {1, 2,15 ,3,10, 4, 5, 6};
        int[] result2 = deleteShiftArray(b);
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
    public static int[] insertShiftArray(int[]array,int x){
        int length=array.length;
        int position=length/2;//middle index
        int newArr[]=new int[length+1];//newArr
        for (int i = 0; i < position; i++) {
            newArr[i]=array[i];            
        }
        newArr[position]=x;
        for (int i= position+1; i < newArr.length; i++) {

            newArr[i]=array[i-1];
        }
        return newArr;
    }
public static int[] deleteShiftArray(int array[]) {
    int length = array.length;
    int position = length / 2; // middle index
    int newArr[] = new int[length - 1]; // newArr

    for (int i = 0; i < position; i++) {
        newArr[i] = array[i];
    }

    for (int i = position; i < newArr.length; i++) {
        newArr[i] = array[i + 1];
    }
    return newArr;
}
}