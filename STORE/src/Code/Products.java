package Code;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PT
 */
public class Products implements Serializable{
    private Product product;
    private int amount;

    public Products() {
    }

    public Products(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
   
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Products" + "\n" + product+"\t"+amount;
    }        
    
}
