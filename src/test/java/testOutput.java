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


public class testOutput {
    @Test
    @DisplayName("Spring bean测试")
    public void run() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationBean.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.say();
    }

    @Test
    @DisplayName("Spring bean测试")
    public void run1() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationBean.xml");
        HelloWorldService helloWorld = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorld.say();
    }

    @Test
    public void run3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beanassemble.xml");
        System.out.println(context.getBean("user1"));
        System.out.println(context.getBean("user2"));
    }

    @Test
    @DisplayName("注解测试")
    public void run4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beansannotation.xml");
        UserController userController=(UserController)context.getBean("userController");
        userController.save();
    }

    @Test
    public void run5(){
        JdkProxy jdkProxy=new JdkProxy();
        UserDao userDao=new UserDaoImpl() ;

        UserDao userDao1=(UserDao) jdkProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }

    @Test
    public void run6(){
        CglibProxy cglibProxy=new CglibProxy();

        com.itheima.cglib.UserDao userDao=new com.itheima.cglib.UserDao();
        com.itheima.cglib.UserDao userDao1=(com.itheima.cglib.UserDao) cglibProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }
    @Test
    public void run7(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("factory.xml");
        UserDao userDao=(UserDao) applicationContext.getBean("userDaoProxy");
        userDao.addUser();
        userDao.deleteUser();
    }
}
