import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        long start =  System.nanoTime();
//        System.out.println(fb(50));
//        System.out.println(System.nanoTime()-start);
//        long start1=  System.nanoTime();
//        System.out.println(fbDP(50));
//        System.out.println(System.nanoTime()-start1);
//        long l = 10006L;
//        Long pp = 10006L;
//        Object obj = l;
//        System.out.println(pp.equals(l));
//        System.out.println(obj instanceof Long);
//
//        coffe a[] = new coffe[10];
//        MochaCoffee b[] = new MochaCoffee[10];
//        a = b;
//        coffe c[] = new MochaCoffee[10];
//        c[0] = new coffe();
        int low = Integer.MAX_VALUE -4;
        int high = Integer.MAX_VALUE;
        System.out.println(low);
        System.out.println(high);
        System.out.println((low+high)/2);
        System.out.println(low+(high-low)/2 );
        System.out.println((low+high)>>1);
        System.out.println((low+high)>>>1);

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
