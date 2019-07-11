public class MyTask {

    public void printNumber(int i) {
        try {
            synchronized (this) {
                this.notify();
                System.out.println(Thread.currentThread().getName() + " " + i);
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
