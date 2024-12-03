package com.core.entity.order.domain.model;

import com.core.checks.Check;
import com.core.entity.exceptions.BuildException;

public class OrderDetail {
    protected String namearticles;
    protected int quantity;
    protected String referencenum;
    protected double individualPrice;
    protected int discount;
    protected double total;

    protected OrderDetail(){
    }

    public static OrderDetail getInstanceDetail(String namearticles, int quantity, String referencenum, double individualPrice, int discount, double total) throws BuildException{
        String message = "";
        int error = 0;
        OrderDetail d = new OrderDetail();

        if((error = d.setNamearticles(namearticles)) !=0){
            message += Check.getErrorMessage(error);
            
        }
        
        if((error = d.setQuantity(quantity)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = d.setReference(referencenum)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = d.setIndividualPrice(individualPrice)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = d.setDiscount(discount)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = d.setTotal(total)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if(message.length()>0){
            d= null;
            throw new BuildException(message);
        }
        return d;
    }

    public String getNamearticles() {
        return namearticles;
    }

    public int setNamearticles(String namearticles) {
        if((Check.minLenght(namearticles, 2)) !=0){
            return -2;
        }
        this.namearticles = namearticles;
        return 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.individualPrice * this.quantity;
        return 0;
    }

    public String getReference() {
        return this.referencenum;
    }

    public int setReference(String referencenum) {
        if((Check.minLenght(referencenum, 2))!=0){
            return -2;
        }
        this.referencenum = referencenum;
        return 0;
    }

    public double getIndividualPrice() {
        return individualPrice;
    }

    public int setIndividualPrice(double individualPrice) {
        this.individualPrice = individualPrice;
        return 0;
    }

    public int getDiscount() {
        return discount;
    }

    public int setDiscount(int discount) {
        this.discount = discount;
        return 0;
    }

    public double getTotal() {
        return this.quantity*getIndividualPrice() - this.discount;
    }

    public int setTotal(double total) {
        this.total = total;
        return 0;
    }

    public String getDetails(){
        return "nomarticle" + this.getNamearticles() +
        ", quantitat" + this.getQuantity() + 
        ", referencia" + this.getReference() + 
        ", preuindividual" + this.getIndividualPrice() +
        ", descompte" + this.getDiscount() + 
        ", total" + this.getTotal();
    }
}
