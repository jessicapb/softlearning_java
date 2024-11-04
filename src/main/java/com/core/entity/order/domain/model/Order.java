package com.core.entity.order.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.core.checks.Check;
import com.core.entity.exceptions.BuildException;
import com.core.entity.shared.operations.Operation;
import com.core.entity.shared.physicals.PhysicalData;
import com.core.entity.shared.products.Storable;


public class Order extends Operation implements Storable{
    protected String address;
    protected Set<String> phoneContact;
    protected String idClient;
    protected String name;
    protected String surname;
    protected String DNI;
    protected LocalDateTime paymentDate;//dia de pagament
    protected LocalDateTime deliveryDate;//fecha de entrega
    protected ArrayList<OrderDetail> shopCart;
    protected PhysicalData orderPackage;
    protected OrderStatus status;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");

    protected Order(){
        this.phoneContact = new HashSet<String>();
        this.shopCart = new ArrayList<OrderDetail>();
        this.status = OrderStatus.CREATED;
    }

    public static Order getInstanceOrder(int reference, String description, String initDate, String finishDate, String address, String phoneContact, String idClient, String name, String surname, String DNI) throws BuildException {
        String message ="";
        int error = 0;
        Order o = new Order();

        try{
            o.checkOperation(reference, description, initDate, finishDate);
        }catch(BuildException e){
            message += e.getMessage();
        }

        if((error = o.setAddress(address)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = o.setPhoneContact(null)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setIdClient(idClient)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setName(name)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setSurname(surname)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setDNI(DNI)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if(message.length()>0){
            o = null;
            throw new BuildException(message);
        }
        return o;
    }

    public String getAddress() {
        return address;
    }

    public int setAddress(String address) {
        if(Check.isNull(address) ==true){
            return -1;
        }
        if(Check.minLenght(address, 6) !=0){
            return -2;
        }
        this.address = address;
        return 0;
    }

    public Set<String> getPhoneContact() {
        return phoneContact;
    }

    public int setPhoneContact(String phoneContact) {
        this.phoneContact.add(phoneContact);
        return 0;
    }

    public String getIdClient() {
        return idClient;
    }

    public int setIdClient(String idClient) {
        if(Check.isNull(idClient) ==true){
            return -1;
        }
        if(Check.minLenght(idClient, 6) !=0){
            return -2;
        }
        this.idClient = idClient;
        return 0;
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        if(Check.isNull(name) ==true){
            return -1;
        }
        if(Check.minLenght(name, 2) !=0){
            return -2;
        }
        this.name = name;
        return 0;
    }

    public String getSurname() {
        return surname;
    }

    public int setSurname(String surname) {
        if(Check.isNull(surname) ==true){
            return -1;
        }
        if(Check.minLenght(surname, 4) !=0){
            return -2;
        }
        this.surname = surname;
        return 0;
    }

    public String getDNI() {
        return DNI;
    }

    public int setDNI(String DNI) {
        if(Check.isNull(DNI) ==true){
            return -1;
        }
        if(Check.minLenght(DNI, 9) !=0){
            return -2;
        }
        this.DNI = DNI;
        return 0;
    }

    public String getPaymentDate() {
        return this.paymentDate.format(formatter);
    }

    public int setPaymentDate(String paymentDate) {
        if(Check.isNull(paymentDate) == true){
            return -1;
        }
        this.paymentDate = LocalDateTime.parse(paymentDate, formatter);
        return 0;
    }

    public String getDeliveryDate() {
        return this.deliveryDate.format(formatter);
    }

    public int setDeliveryDate(String deliveryDate) {
        if(Check.isNull(deliveryDate) == true){
            return -1;
        }
        this.deliveryDate = LocalDateTime.parse(deliveryDate, formatter);
        return 0;
    }

    //PhysicalData
    public double getHigh() {
        return this.orderPackage.getHigh();
    }

    public double getLength() {
        return this.orderPackage.getLength();
    }

    public double getVolume() {
        return this.orderPackage.getVolume();
    }

    public double getWeight(){
        return this.orderPackage.getWeight();
    }

    public double getWidth(){
        return this.orderPackage.getWidth();
    }


    public boolean getFragil() {
        return this.orderPackage.getFragil();
    }

    public double getDepth() {
        return this.orderPackage.getDepth();
    }

    public void setPackagedDimensions(String physics)throws BuildException{

        String[] parts = physics.split(",");

        double high = 0;
        double width = 0;
        double depth = 0;
        double weight = 0;
        boolean fragil = true;
        double length = 0;

        for(String part : parts){
            String[] keyvalue = part.split(":");
            switch (keyvalue[0]){

                case "h":
                high = Double.parseDouble(keyvalue[1]);
                break;

                case "w":
                width = Double.parseDouble(keyvalue[1]);
                break;

                case "d":
                depth = Double.parseDouble(keyvalue[1]);
                break;

                case "we":
                weight = Double.parseDouble(keyvalue[1]);
                break;

                case "f":
                fragil = Boolean.parseBoolean(keyvalue[1]);
                break;

                case "l":
                length = Double.parseDouble(keyvalue[1]);
                default:
                break;
            }
        }
        this.orderPackage = PhysicalData.getInstancePhysical(high, width, length, weight, fragil, depth);
    }

    public String getPackedDimensions(){
        return "h: " + this.orderPackage.getHigh() + 
        ", w: " + this.orderPackage.getWidth() +
        ", l: " + this.orderPackage.getLength() +
        ", we: " + this.orderPackage.getWeight()+ 
        ", f: " + this.orderPackage.getFragil()+
        ", d: " + this.orderPackage.getDepth();       
    }

    //ArrayList
    public int getNumDetails(){
        int total = this.shopCart.size();
        for (int i = 0; i < total; i++) {
            System.out.println(this.shopCart.get(i -1));
        }
        return total;
    }

    public int setDetail(String namearticles, int quantity, int referencenum, double individualPrice, int discount, double total){
        try {
            OrderDetail d = OrderDetail.getInstanceDetail(namearticles, quantity, referencenum, individualPrice, discount, total);
            this.shopCart.add(d);
            System.out.println("Articles afegits correctament.");
            return 1; 
        } catch (BuildException e) {
            System.out.println(e.toString());
            return 0; 
        }
    }

    public String getDetail(int pos){
        if (pos < 0 || pos > this.shopCart.size()) {
            return "Posició incorrecta"; 
        }
        
        OrderDetail d = this.shopCart.get(pos); 
        return d.toString();
    }

    public String getDetail(String ref){
        return "";
    }

    public int updateDetail(int pos, int amount){
        return 0;
    }

    public int updateDetail(String ref, int amount){
        
        return 0;
    }

    public int deleteDetail(int pos){
        return 0;
    }

    public int deleteDetail(String ref){
        return 0;
    }

    public double getPrice(){
        return 0;
    }

    public String getShopCartDetails(){
        return "";
    }

    public String setShopCartDetails(String shopCart){
        return "";
    }

    @Override
    public String getDetails() {
        return "Factura Número d'operació: " + reference + ", Descripció: " + description + ", Data d'inici: " + getInitDate()
                + ", Data final: " + getFinishDate() + ", Adreça: " + address + ", Número de contacte: " + phoneContact
                + ", Número de soci: " + idClient + ", Nom del client: " + name + ", Cognoms: " + surname + ", DNI: " + DNI
                + ", Dia de pagament: " + getPaymentDate() + "";
    }
}
