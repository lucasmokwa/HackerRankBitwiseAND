import java.util.*;

public class bitwiseAND {

    //Solution to HackerRank Bitwise AND Challange
    //Finds the max A&B thats lesser than k in a set 1,2,3...n

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] answers = new int[t];

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            
            answers[tItr] = findBit(k,n);
        }
        for(int i:answers){
            System.out.println(i);
        }

        scanner.close();
    }
    
    private static int[] generateArray(int n){
        int [] arr = new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1] = i;
        }
        
        return arr;
    }
    
    private static int findBit(int k,int n){
        int [] arr = generateArray(n);
        int max = Integer.MIN_VALUE;
        int j = 1;
        for(int i =0;i<arr.length;i++){
            while(j<arr.length){
                if((arr[i]&arr[j])>max && (arr[i]&arr[j])<k) {
                    max = arr[i]&arr[j];
                }
                j++;
            }
            j=i+2;
        }
        
        return max;
    }
}
