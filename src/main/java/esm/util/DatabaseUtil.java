package esm.util;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

@Log4j
public class DatabaseUtil {

    public static SqlSession getSqlSession(){
        //获取配置的资源文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("databaseConfig.xml");
        } catch (IOException e) {
            log.info("数据库连接出错");
            e.printStackTrace();
        }

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //sqlSession就是能够执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();

        return sqlSession;

    }

    public static SqlSession getSqlSession(String dataSource){
        //获取配置的资源文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("databaseConfig.xml");
        } catch (IOException e) {
            log.info("数据库连接出错");
            e.printStackTrace();
        }

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader,dataSource);

        //sqlSession就是能够执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();

        return sqlSession;

    }
}
