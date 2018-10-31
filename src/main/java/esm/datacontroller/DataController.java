package esm.datacontroller;

import esm.dataservice.ClientService;
import esm.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;

public class DataController {
    public static SqlSession session = DatabaseUtil.getSqlSession();

    public static void main(String[] args) {

        ClientService clientService= new ClientService(session);
        clientService.updateClientDay();
        clientService.updateClientWeek();
        clientService.updateClientMonth();
        session.commit();
    }
}
