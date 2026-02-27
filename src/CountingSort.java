public class CountingSort {

    public static void countSort(char[] arr) {
        int[] count=new int[26];  // already initialized to 0

        for(char c: arr) {
            count[c-'A']++;
        }

        int i=0, j=0;

        while(i<count.length) {
            if(count[i]>0) {
                arr[j++]=(char)(i+'A');
                count[i]--;
            }
            else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        char[] arr={'A', 'A', 'Z', 'B', 'H', 'K', 'L', 'Z', 'W', 'X', 'P'};

        countSort(arr);

        for(char c: arr) {
            System.out.println(c+ " ");
        }
    }
}
