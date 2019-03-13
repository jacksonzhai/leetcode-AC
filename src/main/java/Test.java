public class Test {
    public static void main(String[] args) {

        int i = 0xFFFFFFFF;

        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i).length());
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        int q = 1<<31;
        System.out.println(Integer.toBinaryString(q));
        System.out.println(Integer.toHexString(q));
        System.out.println(Integer.toBinaryString(q).length());
        System.out.println(q);
        while (q!=1){
            q >>>= 1;
            System.out.println(Integer.toBinaryString(q));


        }


    }
}
