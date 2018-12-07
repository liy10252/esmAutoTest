package esm.datacontroller;

import esm.dataservice.CasesService;
import esm.dataservice.esmdb.ClientService;
import esm.dataservice.esmlog.ScanEventService;
import esm.dataservice.esmlog.SysDefService;
import esm.dataservice.esmlog.VirusService;
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

    @Test(description = "更新未知客户端的创建时间")
    public void updateClient(){

        ClientService clientService= new ClientService(esmdbSession);
        clientService.updateClientDay();
        clientService.updateClientWeek();
        clientService.updateClientMonth();
        clientService.updateClientStatus();
        esmdbSession.commit();
    }

    @Test(description = "更新全网查杀日志时间")
    public void updateScanEvent(){

        ScanEventService scanEventService = new ScanEventService(esmlogSession);
        scanEventService.updateTimelastWeek();
        scanEventService.updateTimelastMonth();
        esmlogSession.commit();
    }

    @Test(description = "更新病毒详情日志时间")
    public void updateVirus(){

        VirusService virusService = new VirusService(esmlogSession);
        virusService.updateTimeDay();
        virusService.updateTimelastWeek();
        virusService.updateTimelastMonth();
        esmlogSession.commit();

    }

    @Test(description = "更新系统加固日志时间")
    public void updateSysDef(){

        SysDefService sysDefService = new SysDefService(esmlogSession);
        sysDefService.updateTimeDay();
        sysDefService.updateTimelastWeek();
        sysDefService.updateTimelastMonth();
        esmlogSession.commit();
    }


    @AfterClass
    public void tearDown(){

        esmdbSession.close();
        esmlogSession.close();
    }


}

