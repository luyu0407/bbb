public class MyObject {
    public  void method1(){
        synchronized (MyObject.class){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized修饰为同步方法,如果先调用method1,则4秒后才会调用method2
    //如果不用synchronized修饰,则可以直接异步调用,没有影响
    private void method2(){
        System.out.println(Thread.currentThread().getName());
    }

}
