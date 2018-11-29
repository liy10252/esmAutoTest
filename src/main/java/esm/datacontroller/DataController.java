package esm.datacontroller;

import esm.dataservice.CasesService;
import esm.dataservice.ClientService;
import esm.dataservice.ScanEventService;
import esm.dataservice.VirusService;
import esm.model.testcase.Cases;
import esm.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.*;
import java.util.List;

public class DataController {

    public static SqlSession esmdbSession = DatabaseUtil.getSqlSession("esmdb");
    public static SqlSession esmlogSession = DatabaseUtil.getSqlSession("esmlog");
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
        clientService.updateClientStatus();
        esmdbSession.commit();
    }

    @Test
    public void updateScanEvent(){

        ScanEventService scanEventService = new ScanEventService(esmlogSession);
        scanEventService.updateTimelastWeek();
        scanEventService.updateTimelastMonth();
        esmlogSession.commit();
    }

    @Test
    public void updateVirus(){

        VirusService virusService = new VirusService(esmlogSession);
        virusService.updateTimeDay();
        virusService.updateTimelastMonth();
        virusService.updateTimelastWeek();
        esmlogSession.commit();

    }


    @AfterClass
    public void tearDown(){

        esmdbSession.close();
        esmlogSession.close();
    }


}

