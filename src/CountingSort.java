public class CountingSort {

    // Function to perform counting sort on an array to sort it
    public static void countSort(char[] arr) {

        // Frequency array auto initialized with zeros
        int[] freq=new int[26];

        // Iterate through the input array, and put count of each element, using the element as index number
        for(char c: arr) {
            freq[c-'A']++;
        }

        // Print the frequency array after counting
        System.out.println("The frequency array after counting:");
        for(int x: freq) {
            System.out.print(x+ " ");
        }
        System.out.println();

        // Cumulative count array to find positions
        int[] cumCount=new int[26];

        // First element of cumCount will be the same as that of freq
        cumCount[0]=freq[0];

        // Find the position for each element
        for(int i=1; i<freq.length; i++) {
            cumCount[i]=cumCount[i-1]+freq[i];
        }

        // Print the cumulative count array
        System.out.println("The cumulative count array:");
        for(int x: cumCount) {
            System.out.print(x+ " ");
        }
        System.out.println();

        // Create a new array b
        char[] b=new char[arr.length];

        // Find an elements correct position, and put it in b
        for(int i=arr.length-1; i>=0; i--) {
            b[--cumCount[arr[i]-'A']]=arr[i];
        }

        // Copy all elements from b to arr
        for(int i=0; i<arr.length; i++) {
            arr[i]=b[i];
        }
    }

    public static void main(String[] args) {

        // Input array to sort
        char[] arr={'A', 'A', 'Z', 'B', 'H', 'K', 'L', 'Z', 'W', 'X', 'P'};

        // Calling the function to sort the input array
        countSort(arr);

        // Print the sorted array
        System.out.println("Sorted array:");
        for(char c: arr) {
            System.out.print(c+ " ");
        }
    }
}
