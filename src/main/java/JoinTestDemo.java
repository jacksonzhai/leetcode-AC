import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bzwm
 *
 */
class CustomThread1 extends Thread {
    public CustomThread1(int i) {
        super("[CustomThread"+ i +"] Thread");
    };
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
//class CustomThread extends Thread {
//    CustomThread1 t1;
//    public CustomThread(CustomThread1 t1) {
//        super("[CustomThread] Thread");
//        this.t1 = t1;
//    }
//    public void run() {
//        String threadName = Thread.currentThread().getName();
//        System.out.println(threadName + " start.");
//        try {
//            t1.join();
//            System.out.println(threadName + " end.");
//        } catch (Exception e) {
//            System.out.println("Exception from " + threadName + ".run");
//        }
//    }
//}
public class JoinTestDemo {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        List<CustomThread1> runers = new ArrayList<>();
        CustomThread1 t1 = new CustomThread1(1);
        CustomThread1 t2 = new CustomThread1(2);
        CustomThread1 t3 = new CustomThread1(3);
        CustomThread1 t4 = new CustomThread1(4);
        CustomThread1 t5 = new CustomThread1(5);
        runers.add(t1);
        runers.add(t2);
        runers.add(t3);
        runers.add(t4);
        runers.add(t5);
        for(CustomThread1 thread: runers){
            try {
                thread.start();
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        try {
            runers.get(1).join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(threadName + " end!");
    }
}