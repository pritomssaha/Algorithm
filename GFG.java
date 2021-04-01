import java.util.Arrays;

class GFGP{

    public static void main(String[] args){
        int[] arr={1,20,6,4,5};
        System.out.println(sortandcount(arr,0 , arr.length-1));
    }


    private static int sortandcount(int[] arr, int l, int r) {
        int count=0;
        if(l==r)
            return 0;
        else {
            int mid = (l + r) / 2;
            count += sortandcount(arr, l, mid);
            count += sortandcount(arr, mid + 1, r);
            count += mergeandcount(arr, l, mid, r);
        }

        return  count;

    }

    private static int mergeandcount(int[] arr, int l, int mid, int r) {
        int[] left= Arrays.copyOfRange(arr,l,mid+1);
        int[] right=Arrays.copyOfRange(arr, mid+1, r+1);

        int i=0, j=0, k=l, swap=0;

        while (i<left.length && j<right.length){
            if(left[i]<right[j]){
                arr[k++]=left[i++];
            }
            else{
                arr[k++]=right[j++];
                swap+=(mid+1)-(l+i);
            }
        }
        while (i<left.length)
            arr[k++]=left[i++];

        while (j<right.length)
            arr[k++]=right[j++];

        return swap;
    }

}