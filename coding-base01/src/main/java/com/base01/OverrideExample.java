package com.base01;

public class OverrideExample {
    public void o1(String s1, String s2) {}

    public void o1(int s1, String s2) {}

    public void o1(int s2, int s1) {}

    public int o1(String s2, int s1) {
        return 1;
    }

}
