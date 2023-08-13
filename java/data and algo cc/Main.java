public class Main {
    public static void main(String[] args) {

        int arr[]={10,30,50,70,90,110,130,150};
System.out.println(binarySearch(arr,50));
              
    }
    public static int binarySearch(int []arr,int val){
    
      
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while (low<=high) {
            mid=(low+high)/2;
            if(arr[mid]==val){return val;}
            else if(arr[mid]<val){low=mid+1;}
            else if(arr[mid]>val){high=mid-1;}

        }
        return -1;
        
    }
    
}