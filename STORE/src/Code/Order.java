package Code;
import Code.Customer;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PT
 */
public class Order implements Serializable {
    private ArrayList<Products> prod;
    private Customer custo;
    private double total;
    private long orderId;
   
    public Order() {
    }

    public Order(long id ,ArrayList<Products> prod, Customer custo) {
        this.prod = prod;
        this.custo = custo;
        //this.total = total;
        this.orderId = id ;
        for(Products p: prod){ //for each
            double prodPrice=p.getAmount()*(p.getProduct()).getProPrice();
            total+=prodPrice;
        }
        
    }

    public ArrayList<Products> getProd() {
        return prod;
    }

    public void setProd(ArrayList<Products> prod) {
        this.prod = prod;
    }

    public Customer getCusto() {
        return custo;
    }

    public void setCusto(Customer custo) {
        this.custo = custo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double computePoints(double tot){
        double points;
        points=tot/25;
        // custo.addPoints(points);
        custo.setCusPoint((int)points-2);
        return points-2;
    }
    
    public double total(){
        return total ;
    }

    @Override
    public String toString() {
        String result;
        double total=0;
        result= "\t          Order No: " + orderId + "\n" +
                "\t        Customer: "+custo+"\n\t";
        result+="---------------------------------------------------------------\n";
        for(Products p: prod){ //for each
            double prodPrice=p.getAmount()*(p.getProduct()).getProPrice();
            result+=p+"\t"+prodPrice+"\n";
            total+=prodPrice;
        }
        result+="\t---------------------------------------------------------------\n";
        result+="\tTotal: "+total+"\n";
        result+="\tToday you received  "+computePoints(total)+" Points \n";
        
        
        result+="\t---------------------------------------------------------------\n";
       // result+="\n\t\t\tEmployee: "+orderEmp+"\n\n";
       
        return result;
    }
}
