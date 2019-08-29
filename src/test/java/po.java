import com.itheima.po.User11;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class po {

    @Test
    public void run() throws Exception{

        InputStream inputStream= Resources.getResourceAsStream("configmybatis.xml");

        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session=sqlSessionFactory.openSession();

        //User11 user=session.selectOne("Mapper.findDateById",11);
        User11 user=session.selectOne("test.findDateById",11);

        System.out.println(user.toString());

        session.close();
    }
}
