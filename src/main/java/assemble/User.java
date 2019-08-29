package assemble;

import java.util.List;

public class User {
    private String username;
    private Integer password;
    private List<String> list;

    /**
     * 构造器注入
     *  提供带有参数的构造方法
     */
    public User(String username, Integer password, List<String>list){
        super();
        this.list=list;
        this.username=username;
        this.password=password;
    }

    /**
     * 使用值注入,
     * 提供默认的空构造方法
     * 为素有属性提供 setter方法
     */
    public User(){
        super();
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(Integer password){
        this.password=password;
    }
    public void setList(List<String>list){
        this.list=list;
    }

    @Override
    public String toString(){
        return "User [username="+username+" password="+password+" list="+list+"]";
    }
}
