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
        updateUnknowClientTime(new Date(),"WIN-2AL1RFMO551");

    }

    //更新指定client日期为上周
    public void updateClientWeek(){
        updateUnknowClientTime(TimeUtil.getLastWeekDateR(),"WIN-2AL1RFMO552");

    }

    //更新指定client日期为上月
    public void updateClientMonth(){
        updateUnknowClientTime(TimeUtil.getLastMonthDate(),"WIN-2AL1RFMO553");

    }

    //修改指定computer的status
    public void updateClientStatus(){
        Client client = new Client();
        client.setStatus(1);
        client.setComputerName("WIN-DARB1NLQBLO");
        session.update("updateClient",client);
    }

    //更新指定未知client日期字段
    public void updateUnknowClientTime(Date date,String computerName){

        Client client = new Client();
        client.setCreateTime(date);
        client.setComputerName(computerName);
        session.update("updateClient",client);
    }

}
