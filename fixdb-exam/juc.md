1. 原子性
	1. 32位的系统来说，long类型数据的读写都不是原子型
	2. 指令重排  
		哪些指令不能重排：  
			1.程序顺序原则  
			2.volatile规则  
			3.锁规则  
			4.传递性  
			5.线程的start()方法优先于它的每一个动作  
			6.线程的所有操作优先线程的终结操作(Thread.join)  
			7. 线程的中断interrupt()先于中断线程的代码  
			8. 对象的构造函数执行，结束先与finalize()方法  
2. 线程的状态
    1. NEW:表示刚刚创建的线程，还没有start;  
    2. runnable:表示线程所需要的所有资源都已经准备好；  
    3. blocked:如果线程在执行过程中遇到synchronized同步代码块，就会进入blocked状态，直到线程获得请求锁。
    4. waiting:进入无时间限的等待，通过wait()方法等待的线程，在等待notify()方法;  
    5. timed_waiting:线程正在等待一些特殊的时间，通过join方法等待的线程，则会等待目标线程的终止。  
    6. terminated:线程执行完毕状态;  
3. 线程的中断  
    1. public void Thread.interrupt(); // 中断线程，打上标记
    2. public boolean Thread.isInterrupted(); // 判断是否有中断标记
    3. public static boolean Thread.interrupted(); // 判断是否有中断标记，并清除当前的中断状态
    4. 如果线程在sleep()状态休眠时，执行interrupt()被中断，就会出现 InterruptedException
4. wait 和 notify  
    1. 在线程运行时，系统可能出现多个线程同时等待某一个对象，当obj.notify()被调用时，就会从这个等待的线程队列中，随机选择一个，并将其唤醒。
5. join 和 yield  
    1. join的本质就是让调用线程wait()在当前线程对象实例上。
6. volatile   
    1. volatile对保证原子性操作是非常大的帮助  
    2. volatile并不能代替锁  
    3. volatile也能保证数据的可见性和有序性  
    4. 无法保证复合操作的原子性。  
7. daemon Thread  
    1. main线程为用户线程，是系统的工作线程
    2. 只有main线程，因此在线程休眠2s后退出，整个程序也就随之结束，如果不把线程t设置为守护线程，main线程结束后，t线程还会不停的打印。
    3. daemon是守护线程，如果用户线程结束，那么守护线程也就要结束了。
8. synchronized  
    1. 指定加锁对象: 对给定对象加锁，进入同步代码前要获取给定对象的锁。  
    2. 直接作用于实例方法: 相当于对当前实例加锁，进入同步代码前要获取当前实例的锁。  
    3. 直接作用与静态方法: 想当于当当前类加锁，进入同步代码前要获得当前类的锁。
9. 程序中的错误  
    1. int 数值溢出问题  
    2. ArrayList非线程安全的，使用Vector替换ArrayList  
    3. HashMap并发问题，使用ConcurrentHashMap
    4. 不能使用Integer i =0;使用i进行加锁  
        实际使用Integer.valueOf();方法是新建了一个Integer对象并将它赋值给变量i,也就是说i++在真实执行变成了i=Integer.valueOf(i.intValue()+1);
        Integer.valueOf()工厂方法是新创建一个新的Integer实例，就会导致两个线程都加在了不同的实例上。  
        ```
        public static Integer i=0;
        public void run() {
         for(int j=0; j<100000; j++) {
                synchronized(i){i++;}
            }
         }
10. ReentrantLock  
    1. lock(): 获得锁，如果锁已经占用，则等待。
    2. lockInterruptibly(): 获得锁，但优先响应中断，如果被interrupt则会释放锁。
    3. tryLock(): 尝试获得锁，如果成功，返回true,失败返回false.该方法不等待，立即返回。
    4. tryLock(time, TimeUnit): 在给定的事件内尝试获得锁。
    5. unlock(): 释放锁。
    6. 重入锁的三要素  
        1. 是原子性，原子状态使用CAS操作，来存储当前锁的状态。
        2. 是等待队列，所有没有请求到锁的线程，会进入等待队列。
        3. 是阻塞原语park()和unpark()用来挂起和恢复线程。