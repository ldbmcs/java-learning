package com.ldbmcs.singleton;

public class NestedSingleton {
    private static class SingletonHolder {
        private static final NestedSingleton instance = new NestedSingleton();
    }

    private NestedSingleton() {
    }

    public static NestedSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
