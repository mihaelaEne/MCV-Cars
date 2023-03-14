package carsMCV.model;

public class Car {

    public int id;
    public String brand;
    public String model;
    public char fuel;
    public int VINnumber;
    public Boolean esteElectrica=null;


    public String descriereCar(){
        String text="";
        text+="Id-ul autovehiculului este: "+this.id+"\n";
        text+="Brandul autovehiculului este: "+this.brand+"\n";
        text+="Model autovehiculului este: "+this.model+"\n";
        text+="Tipul de combustibil folosit: "+this.fuel+"\n";
        text+="Seria autovehiculului: "+this.VINnumber+"\n";
        text+= this.model+(this.esteElectrica?" este electrica": " nu este electrica ");

        return text;
    }

}
