package esm.dataservice;

import esm.model.esmdb.Client;
import esm.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class ClientService {

    SqlSession session;

    public ClientService(SqlSession session){
        this.session = session;
    }

    //更新指定client日期为当天
    public void updateClientDay(){
        Client client = new Client();
        client.setCreateTime(new Date());
        client.setComputerName("WIN-2AL1RFMO551");
        session.update("updateClient",client);

    }

    //更新指定client日期为上周
    public void updateClientWeek(){
        Client client = new Client();
        client.setCreateTime(TimeUtil.getLastWeekDate());
        client.setComputerName("WIN-2AL1RFMO552");
        session.update("updateClient",client);

    }

    //更新指定client日期为上月
    public void updateClientMonth(){
        Client client = new Client();
        client.setCreateTime(TimeUtil.getPMonthDate());
        client.setComputerName("WIN-2AL1RFMO553");
        session.update("updateClient",client);

    }

}
