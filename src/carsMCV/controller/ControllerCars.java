package carsMCV.controller;

import carsMCV.model.Car;

import java.util.ArrayList;

public class ControllerCars {

    public ArrayList<Car> masini = new ArrayList<>();

    public void loadCars() {
        Car c1 = new Car();
        c1.id = 1;
        c1.brand = "Ford";
        c1.model = "Fiesta";
        c1.fuel = 'g';
        c1.VINnumber = 111;
        c1.esteElectrica = false;

        Car c2 = new Car();
        c2.id = 2;
        c2.brand = "Dacia";
        c2.model = "Logan";
        c2.fuel = 'x';
        c2.VINnumber = 222;
        c2.esteElectrica = true;

        Car c3 = new Car();
        c3.id = 3;
        c3.brand = "Honda";
        c3.model = "Civic";
        c3.fuel = 'd';
        c3.VINnumber = 333;
        c3.esteElectrica = false;

        Car c4 = new Car();
        c4.id = 4;
        c4.brand = "Honda";
        c4.model = "Civic";
        c4.fuel = 'd';
        c4.VINnumber = 444;
        c4.esteElectrica = false;

        Car c5 = new Car();
        c5.id = 5;
        c5.brand = "BMW";
        c5.model = "335";
        c5.fuel = 'd';
        c5.VINnumber = 555;
        c5.esteElectrica = false;

        Car c6 = new Car();
        c6.id = 6;
        c6.brand = "Audi";
        c6.model = "Q5";
        c6.fuel = 'x';
        c6.VINnumber = 666;
        c6.esteElectrica = true;

        this.masini.add(c1);
        this.masini.add(c2);
        this.masini.add(c3);
        this.masini.add(c4);
        this.masini.add(c5);
        this.masini.add(c6);
    }

    public void afisareCar(){
        for(int i=0; i<masini.size();i++){
            System.out.println(this.masini.get(i).descriereCar());
            System.out.println("\n");
        }
    }

    public Car findCarByBrandSiModel(String brand, String model) {
        for (int i = 0; i < this.masini.size(); i++) {

            boolean equalsBrand = masini.get(i).brand.equals(brand);
            boolean equalsModel = masini.get(i).model.equals(model);

            if (equalsBrand && equalsModel) {
                return masini.get(i);
            }

        }
        return null;
    }

    public void addCar(Car masina) {
        this.masini.add(masina);
    }

    public void removeCar(Car masina) {
        this.masini.remove(masina);

    }

    public void update(Car masina){


        Car deUpdatat=findCarByBrandSiModel(masina.brand, masina.model);

        if(masina.id!=0){
            deUpdatat.id=masina.id;
        }

    }


}
