package Code;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Code.Products;
/**
 *
 * @author PT
 */
public class Product implements Serializable{

    public enum ProType {
        Stationery, Electronics, Equipment, Costume, MusicAndGame, Other
    };
    
    private String proName;
    private Products products;
    private long proId;
    private String det;
    private ProType proType;
    private double proPrice;
    private double proCost;
    private static long stat = 1100000000l;
    private static long elec = 1200000000l;
    private static long equip = 1300000000l;
    private static long cos = 1400000000l;
    private static long game = 1500000000l;
    private static long other = 2200000000l;
    
   
    public Product() throws ClassNotFoundException, SQLException {
        this(null, "Can't buy", ProType.Other, 0.0, 0.0);
    }

    public Product(long proId, String proName, String det, ProType proType, double proPrice, double proCost) {
        this.proName = proName;
        this.proId = proId;
        this.det = det;
        this.proType = proType;
        this.proPrice = proPrice;
        this.proCost = proCost;
    }
   
    public Product(String proName, String det, ProType proType, double proPrice, double proCost) throws ClassNotFoundException, SQLException {
        this.proName = proName;
        this.det = det;
        this.proType = proType;
        this.proPrice = proPrice;
        this.proCost = proCost;
       
            switch (proType) {
                case Stationery:
                    proId = ++stat;
                    break;
                case Electronics:
                    proId = ++elec;
                    break;
                case Equipment:
                    proId = ++equip;
                    break;
                case MusicAndGame:
                    proId = ++game;
                    break;
                case Costume:
                    proId = ++cos;
                    break;
                default:
                    proId = ++other;
                    break;
            }  
        addPro();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public long getProId() {
        return proId;
    }

    public String getDet() {
        return det;
    }

    public void setProId(long proId) {
        this.proId = proId;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public ProType getProType() {
        return proType;
    }

    public void setProType(ProType proType) {
        this.proType = proType;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public double getProCost() {
        return proCost;
    }

    public void setProCost(double proCost) {
        this.proCost = proCost;
    }

    public String toString() {       
        return  "ProId\tProName\t\tProtype\tProprice\tAmount\tTotal\n"
                +proId+"\t"+proName+" \t"+proType+"\t"+proPrice;
    }
    
    public void addPro() throws ClassNotFoundException, SQLException{
        String sql = "insert into Product values(" + proId + ",'" + 
                proName + "','" + det + "','" + proType + "'," + 
                proPrice + "," + proCost + ")" ;
        Connection con = ConnectionBuilder.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("Add Product finish");
        
    }
}
