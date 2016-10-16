/*
创建线程的目的是为了开启一条新的执行路径，去运行指定的代码，使其和其它代码同时运行。
创建线程方式一：继承Thread类
1，继承父类Thread类
2，覆盖Thread类中的ran()方法
    为什么要重写ran方法？JVM创建的主线程的任务都定义在了主函数中。子线程的任务都放在
    run方法中。供JVM自动调用。
3，直接创建自定义子类的对象。
4，调用start()方法启动线程。start会自己调用run方法。



可以通过getName()获取线程的名字。名字为Thread-序号。并且一创建就已经完成了初始化。


Thread.currentThread(),返回当前运行线程对象。

每启动一个线程，都会创建一个新的栈用于该线程内部的函数调用的进栈和出栈
*/

class ThreadDemo implements Runnable{
    private int num = 100;
    Object obj = new Object();
    public void run(){
        while( true ){
            synchronized( obj ){
                if( num > 0 ){
                    
                }
            }
        }
    }

}