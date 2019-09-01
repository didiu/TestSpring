import com.didiu.ioc.HelloWorld;
import com.didiu.ioc.HelloWorldService;
import com.itheima.annotation.UserController;
import com.itheima.cglib.CglibProxy;
import com.itheima.jdk.JdkProxy;
import com.itheima.jdk.UserDao;
import com.itheima.jdk.UserDaoImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class testOutput {

    private static ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("applicationBean.xml");

    @Test
    @DisplayName("Spring bean测试")
    void run() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationBean.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.say();
    }

    @Test
    @DisplayName("Spring bean测试")
    void run1() {
        HelloWorldService helloWorld = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorld.say();
    }

    @Test
    void run3(){
        System.out.println(applicationContext.getBean("user1"));
        System.out.println(applicationContext.getBean("user2"));
    }

    @Test
    @DisplayName("注解测试")
    void run4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("annotationBeans.xml");
        UserController userController=(UserController)applicationContext.getBean("userController1");
        userController.save();
    }

    @Test
    @DisplayName("jdk动态代理测试")
    void run5(){
        JdkProxy jdkProxy=new JdkProxy();
        UserDao userDao=new UserDaoImpl() ;

        UserDao userDao1=(UserDao) jdkProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }

    @Test
    @DisplayName("cglib动态代理测试")
    void run6(){
        CglibProxy cglibProxy=new CglibProxy();

        com.itheima.cglib.UserDao userDao=new com.itheima.cglib.UserDao();
        com.itheima.cglib.UserDao userDao1=(com.itheima.cglib.UserDao) cglibProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }
    @Test
    void run7(){
        UserDao userDao=(UserDao) applicationContext.getBean("userDaoProxy");
        userDao.addUser();
        userDao.deleteUser();
    }
}
