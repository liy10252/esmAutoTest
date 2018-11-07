package esm.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import esm.model.testcase.Cases;
import esm.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class Demo1{
    public static SqlSession session = DatabaseUtil.getSqlSession("testcase");
    @Test
    public void testDemo1()  {

        Cases cases = session.selectOne("selectCase","com.test.a");
        System.out.println(cases.getCasename());

        JSONObject ob = JSON.parseObject(cases.getParam());
        System.out.println(ob.get("name").toString());
        System.out.println(Integer.valueOf(ob.get("age").toString()));

    }
}
