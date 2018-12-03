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
    private Integer Status;
    private String LastServerGUID;
    private String LastLoginAccount;
    private Date LastLoginTime;
    private Integer GroupType;
    private Integer NodeType;
    private Integer SourceType;
    private String CreatorGUID;
    private Date CreateTime;
    private String ModifierGUID;
    private Date ModifyTime;
    private Integer Deleted;
    private Integer Accredited;
    private Integer ReBoot;
    private Integer IsVD;
    private String SynSource;

}
