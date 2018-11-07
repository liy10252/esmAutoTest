package esm.datacontroller;

import esm.dataservice.CasesService;
import esm.dataservice.ClientService;
import esm.model.testcase.Cases;
import esm.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.CancellationException;

public class DataController {

    public static SqlSession esmdbSession = DatabaseUtil.getSqlSession("esmdb");
    public static SqlSession caseSession = DatabaseUtil.getSqlSession("testcase");
    public static List<Cases> caseList;

    @Test
    public void updateClient(){

        ClientService clientService= new ClientService(esmdbSession);
        clientService.updateClientDay();
        clientService.updateClientWeek();
        clientService.updateClientMonth();
        esmdbSession.commit();
    }

    @Test
    public static void getCases() {

        CasesService casesService = new CasesService(caseSession);
        caseList = casesService.getCaseList();
    }
}

