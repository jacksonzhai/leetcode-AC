import java.util.Map;

public class Test {
    public static void main(String[] args) {
        long start =  System.nanoTime();
        System.out.println(fb(50));
        System.out.println(System.nanoTime()-start);
        long start1=  System.nanoTime();
        System.out.println(fbDP(50));
        System.out.println(System.nanoTime()-start1);


    }
    public static long fb(int n){
        if(n ==1 || n==2){
            return 1;
        }else{
            return fb(n-1)+ fb(n-2);
        }

    }
    public static long fbDP(int n){
        long[] a = new  long[n];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2;i<n;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }

}
