package com.didiu.ioc;

public class HelloWorldImpl implements HelloWorld {
//    private HelloWorld helloWorld;
//    public void setHelloWorld(HelloWorld helloWorld){
//        this.helloWorld=helloWorld;
//    }
    @Override
    public void say() {
       // this.helloWorld.say();
        System.out.println("HelloWorld say HelloWorld !");
    }
}
