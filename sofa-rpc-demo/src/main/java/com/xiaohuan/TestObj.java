package com.xiaohuan;

public class TestObj {
    private String str;
    private int    num;

    public String getStr() {
        return str;
    }

    public TestObj setStr(String str) {
        this.str = str;
        return this;
    }

    public int getNum() {
        return num;
    }

    public TestObj setNum(int num) {
        this.num = num;
        return this;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "str='" + str + '\'' +
                ", num=" + num +
                '}';
    }
}
