package com.core.entity.book.model;

import com.core.checks.Check;
import com.core.entity.exceptions.BuildException;
import com.core.entity.shared.physicals.PhysicalData;
import com.core.entity.shared.products.Product;
import com.core.entity.shared.products.Storable;

public class Books extends Product implements Storable{
    protected String author;
    protected String title;
    protected String cover;
    protected int page;
    protected String gender;
    protected String editorial;
    protected String ISBN;
    protected PhysicalData phy;
    
    protected Books(){
    }

    public static Books getInstanceBooks(int code, double price, String description, String author, String title, String cover, int page,
            String gender, String editorial, String iSBN, double high, double width, double length, double weight, boolean fragil, double depth) throws BuildException {
        String message = "";
        int error = 0;

        Books b = new Books();

        try{
            b.CheckProduct(code, price, description);
        }catch(BuildException e){
            message += e.getMessage();
        }

        try {
            b.phy = PhysicalData.getInstancePhysical(high, width, length, weight,fragil,depth);
        } catch (BuildException e) {
            message += e.getMessage();
        }

        if((error = b.setAuthor(author)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = b.setTitle(title)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = b.setCover(cover)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = b.setPage(page)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = b.setGender(gender)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = b.setEditorial(editorial)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = b.setISBN(iSBN)) !=0){
            message += Check.getErrorMessage(error);
        }

        if(message.length()>0){
            b = null;
            throw new BuildException(message);
        }
        return b;
    }

    public String getAuthor() {
        return author;
    }

    public int setAuthor(String author) {
        if(Check.isNull(author) == true){
            return -1;
        }
        if(Check.minLenght(author, 5) !=0){
            return -2;
        }
        this.author = author;
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public int setTitle(String title) {
        if(Check.isNull(title) == true){
            return -1;
        }
        if(Check.minLenght(title, 5) !=0){
            return -2;
        }
        this.title = title;
        return 0;
    }

    public String getCover() {
        return cover;
    }

    public int setCover(String cover) {
        if(Check.isNull(cover) == true){
            return -1;
        }
        if(Check.minLenght(cover, 3)!=0){
            return -2;
        }
        this.cover = cover;
        return 0;
    }

    public int getPage() {
        return page;
    }

    public int setPage(int page) {
        if(Check.isNegative(page) !=0){
            return -3;
        }
        this.page = page;
        return 0;
    }

    public String getGender() {
        return gender;
    }

    public int setGender(String gender) {
        if(Check.isNull(gender) == true){
            return -1;
        }
        if(Check.minLenght(gender, 3) !=0){
            return -2;
        }
        this.gender = gender;
        return 0;
    }

    public String getEditorial() {
        return editorial;
    }

    public int setEditorial(String editorial) {
        if(Check.isNull(editorial) == true){
            return -1;
        }
        if(Check.minLenght(editorial, 3) !=0){
            return -2;
        }
        this.editorial = editorial;
        return 0;
    }

    public String getISBN() {
        return ISBN;
    }

    public int setISBN(String iSBN) {
        if(Check.isNull(iSBN) == true){
            return -1;
        }
        if(Check.minLenght(iSBN, 5) !=0){
            return -2;
        }
        if(Check.isNegative(code) !=0){
            return -3;
        }
        this.ISBN = iSBN;
        return 0;
    }
    

    //PhysicalData
    public double getHigh() {
        return this.phy.getHigh();
    }

    public double getLength() {
        return this.phy.getLength();
    }

    public double getVolume() {
        return this.phy.getVolume();
    }

    public double getWeight(){
        return this.phy.getWeight();
    }

    public double getWidth(){
        return this.phy.getWidth();
    }

    public int getCalcularVolum(int length, int width, int high){
        int volume;
        volume = length * width * high;
        return volume;
    }

    public boolean getFragil() {
        return this.phy.getFragil();
    }

    public double getDepth() {
        return this.phy.getDepth();
    }

    @Override
    public String getDetails() {
        return "LLIBRE: Codi producte: " + code + ", Preu: " + price + ", Descripció: " + description + ", Autora: " + author
                + ", Títol: " + title + ", Tapa: " + cover + ", Pàgines: " + page + ", Genere: " + gender + ", Editorial: "
                + editorial + ", ISBN: " + ISBN + ", Altura: " + this.getHigh() + ", Amplada" + this.getWidth() + ", Longitud: " + this.getLength() +  
                ", Pes: " + this.getWeight() +", Fràgil: " + this.getFragil() + ", Profunditat: " + this.getDepth() + "" ;
    }
}
