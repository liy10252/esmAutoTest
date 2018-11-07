package esm.demo;

import esm.model.esmdb.Client;
import esm.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Date;

public class Demo2 {


    @Test
    public void testSelect() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        Client client = session.selectOne("selectClient","WIN-2AL1RFMO556");
        System.out.println(client.toString());
        System.out.println(client.getComputerName());

    }

    @Test
    public void testUpdate() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        Client client = new Client();
        client.setCreateTime(new Date());
        client.setComputerName("WIN-2AL1RFMO551");
        int count = session.update("updateClient",client);
        session.commit();
        System.out.println(count);
    }


}
