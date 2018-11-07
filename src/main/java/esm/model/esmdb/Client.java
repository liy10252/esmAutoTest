package esm.model.esmdb;

import lombok.Data;
import java.util.Date;

@Data
public class Client {

    private String GUID;
    private String ComputerName;
    private String Memo;
    private String IP;
    private String NatIP;
    private String MAC;
    private String OS;
    private String Version;
    private String GroupGUID;
    private int Status;
    private String LastServerGUID;
    private String LastLoginAccount;
    private Date LastLoginTime;
    private int GroupType;
    private int NodeType;
    private int SourceType;
    private String CreatorGUID;
    private Date CreateTime;
    private String ModifierGUID;
    private Date ModifyTime;
    private int Deleted;
    private int Accredited;
    private int ReBoot;
    private int IsVD;
    private String SynSource;

}
