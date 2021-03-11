package com.ldbmcs.singleton;

public class LazySingleton {

    // 内存屏障(解决重排序问题)，可见性
    private volatile static LazySingleton instance;

    private LazySingleton() {
    }


    // 懒汉式（线程不安全）
//    public static LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    // 懒汉式（线程安全）
//    public static  synchronized LazySingleton getInstance(){
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    // 双重检查锁
    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton(); // 不是原子操作，存在重排序问题
                    // 1. 给instance 分配内存
                    // 2. 调用Singleton构造函数初始化成员变量
                    // 3. 将instance指向分配的内存空间
                    // 如何1-3-2执行，就会出现非null，但是未实例化
                }
            }
        }
        return instance;
    }
}
