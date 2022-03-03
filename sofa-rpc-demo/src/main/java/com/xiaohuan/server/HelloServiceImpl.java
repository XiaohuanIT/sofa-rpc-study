package com.xiaohuan.server;

import com.xiaohuan.HelloService;
import com.xiaohuan.TestObj;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String string) {
        System.out.println("Server receive: " + string);
        return "hello " + string + " ！";
    }

    @Override
    public TestObj sayHello(TestObj obj) {
        System.out.println("receive:"+obj.toString());
        return obj;
    }
}
