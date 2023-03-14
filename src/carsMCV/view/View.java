package carsMCV.view;

import carsMCV.controller.ControllerCars;
import carsMCV.model.Car;

import java.util.Scanner;

public class View {
    public ControllerCars controllerCar= new ControllerCars();

    public Scanner scanner= new Scanner(System.in);


    public void meniu(){
        System.out.println("Apasati tasta 1 pentru a vedea lista de masini");
        System.out.println("Apasati tasta 2 pentru a adauga o masina");
        System.out.println("Apasati tasta 3 pentru a sterge o masina");
        System.out.println("Apasati tasta 4 pentru a da update la o masina");


    }

    public void play(){
        controllerCar.loadCars();

        int alegere=0;
        boolean running=true;
        while (running) {
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1: controllerCar.afisareCar();
                    break;

                case 2:adaugareMasina();
                    break;

                case 3:stergereMasina();
                    break;

                case 4:update();
                    break;

                default:
                    System.out.println("Alegere gresita");
            }
        }

    }

    public void adaugareMasina(){
        System.out.println("Introduceti id-ul: ");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti brand-ul: ");
        String brand=scanner.nextLine();
        System.out.println("Introduceti modelul: ");
        String model=scanner.nextLine();
        System.out.println("Introduceti initiala tipul de combustibil: ");
         char fuel=scanner.nextLine().charAt(0);
        System.out.println("Introduceti seria : ");
        int serie=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti true,daca masina este electrica si false, daca masina nu este electrica : ");
        boolean areBursa =Boolean.parseBoolean(scanner.nextLine());


        Car masina=controllerCar.findCarByBrandSiModel(brand,model);
        if(masina==null)
        {
            Car cNou=new Car();
            cNou.id=id;
            cNou.brand=brand;
            cNou.model=model;
            cNou.fuel=fuel;
            cNou.VINnumber=serie;
            controllerCar.addCar(cNou);
            System.out.println("S-a adaugat cu success ");
        }else{

            System.out.println("Masian exista deja");
        }

    }

    public void stergereMasina(){
        System.out.println("Introduceti brand-ul: ");
        String brand=scanner.nextLine();
        System.out.println("Introduceti modelul: ");
        String model=scanner.nextLine();

       Car masina=controllerCar.findCarByBrandSiModel(brand, model);
        if(masina==null){
            System.out.println("Nu exista o mssina cu acest brand si model");
        }else{
            controllerCar.removeCar(masina);
            System.out.println("Masina a fost stearsa");
        }

    }


    public void update(){

        System.out.println("Introduceti brand-ul: ");
        String brand=scanner.nextLine();
        System.out.println("Introduceti modelul: ");
        String model=scanner.nextLine();

        Car masina=controllerCar.findCarByBrandSiModel(brand, model);
        if(masina==null) {
            System.out.println("Nu exista o masina cu acest brand si model");
        }else {

            System.out.println("Introduceti cu virgula campurile ce doriti sa fie modificate: brand,model");

            String[] upd=scanner.nextLine().split(",");


            Car  nou= new Car();

            nou.brand=brand;
            nou.model=model;

            for(int i=0;i<upd.length;i++){


                switch (upd[i]){

                    case "brand":
                        System.out.println("Introduceti noul brand");
                        nou.brand= scanner.nextLine();
                        break;
                    case "model":
                        System.out.println("Introduceti noul model");
                        nou.model= scanner.nextLine();
                        break;

                    default:
                        System.out.println("Alegere gresita");
                }
            }



            controllerCar.update(nou);

        }
    }

}

