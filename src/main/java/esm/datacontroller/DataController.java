package esm.datacontroller;

import esm.dataservice.CasesService;
import esm.dataservice.ClientService;
import esm.model.testcase.Cases;
import esm.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import java.util.List;

public class DataController {

    public static SqlSession esmdbSession = DatabaseUtil.getSqlSession("esmdb");
    public static SqlSession caseSession = DatabaseUtil.getSqlSession("testcase");
    public static List<Cases> caseList;


    static{

        CasesService casesService = new CasesService(caseSession);
        caseList = casesService.getCaseList();
        caseSession.close();
    }

    @Test
    public void updateClient(){

        ClientService clientService= new ClientService(esmdbSession);
        clientService.updateClientDay();
        clientService.updateClientWeek();
        clientService.updateClientMonth();
        esmdbSession.commit();
    }


}

