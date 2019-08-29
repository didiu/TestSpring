package com.didiu.ioc;

public class HelloWorldServiceImpl implements HelloWorldService{

    private HelloWorld helloWorld;
    public void setHelloWorld(HelloWorld helloWorld){
        this.helloWorld=helloWorld;
    }
    @Override
    public void say() {
        this.helloWorld.say();
        System.out.println("HelloWorldService say HelloWorld !");
    }
}
