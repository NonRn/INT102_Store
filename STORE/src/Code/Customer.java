package Code;

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
//import static org.apache.derby.impl.sql.compile.SQLParserConstants.CURRENT_TIMESTAMP;

/**
 *
 * @author PT
 */
public class Customer implements Serializable{
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
    private String cusName;
    private String cusSurname;
    private long cusId;
    private int cusAge;
    private String addr ;
    private int cusPoint = 5;
    private Date birth;
    private String birthday;
    private Date regis;
    //private static long idRun = 1000000l;

    public Customer() throws ClassNotFoundException, SQLException {
        
    }

    public Customer(String cusName, String cusSurname, long cusId, int cusAge, String addr,int point, String birthday, Date regis) {
        this.cusName = cusName;
        this.cusSurname = cusSurname;
        this.cusId = cusId;
        this.cusAge = cusAge;
        this.addr = addr;
        this.birth = birth;
        this.birthday = birthday;
        this.regis = regis;
        this.cusPoint = point;
    }
    
    public Customer(Long id,String cusName,String cusSurname,String addr,int cusAge, Date birthday) throws ClassNotFoundException, SQLException {
        regis = new Date();
        this.cusSurname = cusSurname ;
        this.cusName = cusName;
        this.cusAge = cusAge;
        this.birth = birthday ;
        this.birthday = sdf.format(birthday);
        this.addr = addr ;
        cusId = id ;
        
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusSurname() {
        return cusSurname;
    }

    public void setCusSurname(String cusSurname) {
        this.cusSurname = cusSurname;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public long getCusId() {
        return cusId;
    }

    public void setCusId(long cusId) {
        this.cusId = cusId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getRegis() {
        return regis;
    }

    public int getCusAge() {
        return cusAge;
    }

    public void setCusAge(int cusAge) {
        this.cusAge = cusAge;
    }

    public int getCusPoint() {
        return cusPoint;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setCusPoint(int cusPoint) {
        this.cusPoint = cusPoint;
    }
    
    
    public String toString() {
        return "Name = " + cusName + "   " + cusSurname+
                "\nId = " + cusId + "\nLogin = " + "\nBirthDay" + birthday +
                "\nAge = " + cusAge + "\nPoint = " + cusPoint ;
    
    } 
    
}
