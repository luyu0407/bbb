public class Service {

    private boolean shouldBeMain=true;

    /**
     * 主线程打印，注意同步
     */
    public  void mainPrint(int loopth) throws Exception{

//        while(!shouldBeMain){//不该主线程
//            System.out.println("主线程等待："+loopth);
//            this.wait();
//        }
////
////        Thread.sleep(1000);
//        System.out.println("主线程打印："+loopth+"次循环");
////
//        shouldBeMain=false;
//
//        this.notify();

        while (shouldBeMain){
            this.notify();
            System.out.println("主线程打印："+loopth+"次循环");
            shouldBeMain=false;
            this.wait();
        }

        int i;



    }


    public synchronized void subPrint(int loopth) throws Exception{

        while (!shouldBeMain){
            this.notify();
            System.out.println("子线程打印："+loopth+"次循环");
            shouldBeMain=true;
            this.wait();
        }

//        while(shouldBeMain){
//            System.out.println("子线程等待："+loopth);
//            this.wait();
//        }
//
////        Thread.sleep(1000);
//        System.out.println("子线程打印："+loopth+"次循环");
//
//
//        shouldBeMain=true;
//
//        this.notify();

    }

}


