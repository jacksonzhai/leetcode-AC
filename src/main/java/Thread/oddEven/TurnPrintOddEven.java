package Thread.oddEven;

public class TurnPrintOddEven {
    private  final Object lock = new Object();
    private  int count = 0;
    private  boolean flag = false;

    public  void turning() {
        new TurnPrintOddEven();
        Thread even = new Thread(()->{
            int i = 0;
            while (i<100) {
                synchronized (lock) {
                    if ((i & 1) == 0 && !flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        flag = true;
                        lock.notify();


                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    i++;
                }

            }



        },"偶数");
        Thread odd = new Thread(()-> {
            int i = 0;
            while(i<100){
                synchronized(lock) {
                    if ((i & 1) == 1 && flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        flag = false;
                        lock.notify();

                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    i++;
                }

            }

        },"奇数");

        even.start();
        odd.start();


    }

    public static void main(String[] args) {
        new TurnPrintOddEven().turning();
    }
}
