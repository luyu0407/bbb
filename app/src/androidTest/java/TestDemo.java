import com.example.myapplication.Myqueen;
import com.example.myapplication.observer.ConcreteObserver1;
import com.example.myapplication.observer.ConcreteObserver2;
import com.example.myapplication.observer.ConcreteSubject;
import com.example.myapplication.observer.Observer;
import com.example.myapplication.observer.Subject;

import org.junit.Test;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TestDemo {




    public int maxProfit(int[] prices) {
        //[7,1,5,3,6,4]

        if (prices == null || prices.length ==0)
            return 0;

        int n = 0;
        int m = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[n]>prices[i]){
                n = i;
            }
        }

        if (n == prices.length-1){
            return 0;
        }else {
            m = n;
            for (int j =n; j < prices.length; j++) {
                if (prices[j]>prices[m]){
                    m = j;
                }
            }
            return prices[m] - prices[n];
        }



    }



    @Test
    public void test(){
        System.out.print("ddd");
    }


    public  static volatile int aa = 1;

    public static void main(String[] strs) {

        //观察者模式
        Subject subject = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1();
        Observer o2 = new ConcreteObserver2();
        subject.add(o1);
        subject.add(o2);
        subject.notifyObserver();



        //两个堆栈实现队列
//        Myqueen myqueen = new Myqueen();
//
//        myqueen.push(2);
//        myqueen.push(4);
//        myqueen.push(6);
//        myqueen.push(8);
//        myqueen.push(9);
//
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        s.push(5);
//
//
//        for (int i=0;i<2;i++){
//            System.out.println("i ="+i+"----"+myqueen.pop());
//        }
//
//        myqueen.push(10);
//        myqueen.push(11);
//
//        for (int i=0;i<2;i++){
//            System.out.println("i ="+i+"----"+myqueen.pop());
//        }





//        boolean b1= isOneBit(new int[]{1,0,0});
//        boolean b2= isOneBit(new int[]{1,1,0});
//        System.out.println("b1="+b1);
//        System.out.println("b2="+b2);

//        B.test();

//        stringTest();


//        int[] nums = {4,2, 7, 11, 15};
//        int target = 11;
//
//        int[] res = twoSum(nums,target);
//        if (res == null){
//            printObject("没有对应数组");
//        }else {
//            printArray(res);
//        }

//        new Thread(new Thread1()).start();
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new Thread(new Thread2()).start();


//        System.out.print(lengthOfLastWord("hello World"));
//        merge2(new int[]{1,3,4,0,0,0},3,new int[]{2,5,6},3);

        //创建一个对象
//        final MyObject myObject=new MyObject();
//        final MyObject myObject2=new MyObject();
//
//        Thread t1=new Thread (new Runnable() {
//            @Override
//            public void run() {
//                myObject.method1();
//            }
//        },"t1");
//        Thread t2=new Thread (new Runnable() {
//            @Override
//            public void run() {
//                myObject2.method1();
//            }
//        },"t2");
//        t1.start();
//        t2.start();


//        final Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    synchronized (TestDemo.class){
//                        try {
//                            this.notify();
//                            printlnObject("t1");
//                            this.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                  }
//        });
//
//        final Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (TestDemo.class) {
//                    try {
//                        this.notify();
//                        printlnObject("t2");
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//            }
//        });
//
//
//        while (true){
//
//            t1.start();
//            t2.start();
//        }





//        final MyTask myTask = new MyTask();
//
//        Thread t1 = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 1 ; i <= 100 ; i+=2) {
//                    myTask.printNumber(i);
//                }
//            }
//        });
//
//        t1.setName("Thread t1");
//        t1.start();
//
//        Thread t2 = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 2 ; i <= 100 ; i+=2) {
//                    myTask.printNumber(i);
//                }
//            }
//        });
//
//        t2.setName("Thread t2");
//        t2.start();


//        final Service service=new Service();
//
//        new Thread(){
//
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        service.subPrint(i);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        service.mainPrint(i);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//
//
//        HashSet set = new HashSet();
//
//        set.add("dsfa");
//        set.remove("");
//        Hashtable hashtable = new Hashtable();
//        hashtable.put(1,32);
//        hashtable.get(1);
//
//        ConcurrentHashMap map = new ConcurrentHashMap();
//        map.put(1,2);


//        lastStoneWeight(new int[]{4,7,1,3,9,5,14,2,8});

      }



    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 0){
            return 0;
        }

        if (stones.length == 1){
            return stones[1];
        }

        boolean b = true;
        int i,j;
        while (b){
            b = false;
            for (i = 0;  i< stones.length-1; i++) {
                if (stones[i] > stones[i+1]){
                    stones[i] = stones[i] + stones[i+1];
                    stones[i+1] = stones[i] - stones[i+1];
                    stones[i] = stones[i] -stones[i+1];
                    b = true;
                }

            }
        }



        if (stones[stones.length-2] == stones[stones.length-1]){
            int[] arr = new int[stones.length-2];
            System.arraycopy(stones,0,arr,0,arr.length);
            return lastStoneWeight(arr);
        }else {
            int[] arr = new int[stones.length-1];
            System.arraycopy(stones,0,arr,0,arr.length-1);
            arr[stones.length-2] = stones[stones.length-1] -stones[stones.length-2];
            return lastStoneWeight(arr);
        }

    }





    public static int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        if (s.contains(" ")){
            String s1 = s.substring(s.lastIndexOf(" "));
            return s1.length();
        }else {
            return s.length();
        }

    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];

        int i=0,j=0,a =0;
        while (i<nums1.length|| j<nums2.length){

            if (i<nums1.length && j<nums2.length){
                if (nums1[i]<nums2[j]){
                    res[a] = nums1[i];
                    i++;
                }else {
                    res[a] = nums2[j];
                    j++;
                }

            }else if (i==nums1.length){
                res[a] = nums2[j];
                j++;
            }else if (j == nums2.length){
                res[a] = nums1[i];
                i++;
            }
            a++;
        }


    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        System.out.println("p = "+p);
        System.out.println("m = "+m);
        System.out.println("n = "+n);
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }

    }


    private int a(String s){

        int res = 0;
        for(int i = s.length()-1;i>=0;--i)
        {

            if(s.charAt(i) != ' ')
            {
                res++;
                while(i-res>=0 && s.charAt(i-res) != ' ')
                {
                    ++res;
                }
                break;
            }
        }
        return res;


    }

    private static class Thread1 implements Runnable{

        @Override
        public void run() {
            Object o =new Object();
            synchronized (o){
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");

                try {
                    o.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }

        }
    }

    public static boolean isOneBit(int bits[]){
        if (bits.length==1){
            return true;
        }
        int i = bits.length-2;
        while (i>1){
            if (bits[i] == 0){
                return true;
            }else {
                i-=2;
            }
        }
        if(i==1){
            return bits[i]==1;
        }else if(i==0){
            return bits[i]==0;
        }else{
            return false;
        }

    }

    private static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (TestDemo.class){
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");

                TestDemo.class.notify();

                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");

            }
        }
    }






    public static int[] twoSum(int[] nums, int target) {

        for (int i=0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target)
                    return new int[]{i,j};
            }
        }

        return null;
    }

    public static void printArray(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                printObject("["+nums[i]);
            }else if (i==nums.length-1){
                printObject(","+nums[i]+"]");
            }else {
                printObject(","+nums[i]);
            }
        }
    }


    public static void printObject(Object o){
        System.out.print(o);
    }
    public static void printlnObject(Object o){
        System.out.println(o);
    }


    private static void stringTest() {
        String a = "a";
        String b = "b";
        String ab = a + b;
        String c = "ab";
        System.out.println("");
        System.out.println("ab = " + ab);
        System.out.println("c=" + c);

        System.out.println(a + b == "ab");
        System.out.println(ab.equals(c));


        A aa = new A("dd");
        A a1 = new A("dd");


        System.out.println("aa.equals(a1)=" + aa.equals(a1));
        System.out.println("aa==a1 =" + (aa == a1));


    }


}
