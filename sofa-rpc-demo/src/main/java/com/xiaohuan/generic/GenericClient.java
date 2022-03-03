package com.xiaohuan.generic;

import com.alipay.hessian.generic.model.GenericObject;
import com.alipay.sofa.rpc.api.GenericService;
import com.alipay.sofa.rpc.config.ApplicationConfig;
import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.xiaohuan.HelloService;
import com.xiaohuan.TestObj;

public class GenericClient {
    public static void main(String[] args) {

        ApplicationConfig applicationConfig = new ApplicationConfig().setAppName("generic-client");

        ConsumerConfig<GenericService> consumerConfig = new ConsumerConfig<GenericService>()
                .setApplication(applicationConfig)
                .setInterfaceId(HelloService.class.getName())
                .setGeneric(true)
                .setTimeout(50000)
                .setDirectUrl("bolt://127.0.0.1:12200");
        GenericService testService = consumerConfig.refer();

        String s1 = (String) testService.$invoke("sayHello", new String[]{"java.lang.String"},
                new Object[]{"1111"});
        System.out.println(s1);


        GenericObject genericObject = new GenericObject(
                "com.xiaohuan.TestObj");
        genericObject.putField("str", "xxxx");
        genericObject.putField("num", 222);

        GenericObject o2 = (GenericObject) testService.$genericInvoke("sayHello",
                new String[] { "com.xiaohuan.TestObj" },
                new Object[] { genericObject });
        System.out.println("generic return :{}" + o2);

        TestObj o3 = testService.$genericInvoke("sayHello",
                new String[] { "com.xiaohuan.TestObj" },
                new Object[] { genericObject }, TestObj.class);
        System.out.println("generic return :{}" + o3);


    }
}
