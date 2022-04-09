
package ui;
import java.util.Scanner;
import model.Control;
/*
To compile: javac -cp src src/ui/Main.java -d bin
To execute: java -cp bin ui.Main
To generate javadoc: javadoc src/ui/Main.java -d doc/API/
*/
public class Main {
    private static Scanner sc;

    private Control controlObject;
    public static void main(String[] args) {

        Main mainObject = new Main();

        System.out.println("\n\n**** WELCOME TO THE WETLAND SYSTEM ****");

        int option= 0;
		
		do {
		    option =mainObject.showMenu();
		    mainObject.answerOption(option);
		}while (option !=0);
    }


    public Main() {
        sc = new Scanner(System.in);
        controlObject = new Control();
    }


    public int showMenu(){
        int option;
        System.out.println("\n\nMenu of options, please insert an option: "+
                            "\n\n1) Create a wetland" +
                            "\n2) Register a new specie in a wetland" +
                            "\n3) Register an event in a wetland" + 
                            "\n4) Inform for each wetland, the amount of maintenance in a year given by the user" + 
                            "\n5) Show the name of the wetland with the less species of flora" + 
                            "\n6) Given the name of a specie, show the wetlands where it is in" + 
                            "\n7) Display the information of all wetlands, including the total number of species by type (not including events)"+
                            "\n8) Display the name of the wetland with the largest number of animals (birds, mammals and aquatic)" + 
                            "\n0) Exit the program");
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void answerOption(int option) {
        switch (option) {
            case 1:
                registerWetland();
                break;
            case 2:
                registerSpecie();
                break;  
            case 3:
                registerEvent();
                break;
            case 4:
                showNumberMantenanceWetlands();
                break;
            case 5: 
                showWetlandWithLessFlora();
                break;
            case 6:
                showSameSpecieInWetlands();
                break;
            case 7:
                showInformationWetlands();
                break;
            case 8:
                showMaxNumberOfAnimalsInWetlands();
                break;
        }
    }

    public void showNumberMantenanceWetlands() {
        System.out.println("Enter the year you want to search for: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("\n***** Number of mantenance of wetlands *****\n");
        System.out.println(controlObject.amountMaintenanceWetlandsInYear(year));
    }

    public void showInformationWetlands() {
        System.out.println(controlObject.toString());
    }

    public void registerWetland() {
        String name, urlOfThePicture, locationName;
        boolean locationZone, type, protectedArea;
        double area; 
        System.out.println("Plese enter the name: ");
        name = sc.nextLine();
        System.out.println("Plese enter the locationZone: 1) Rural 2) Urban ");
        int numLocationZone = sc.nextInt();
        sc.nextLine();
        if(numLocationZone == 1) {
            locationZone = true;
        } else {
            locationZone = false;
        }
        System.out.println("Plese enter the type of the wetland:  1) Private 2) Public ");
        int numType = sc.nextInt();
        sc.nextLine();
        if(numType == 1) {
            type = true;
        } else {
            type = false;
        }
        System.out.println("Plese enter the area of the wetland: ");
        area = sc.nextDouble();
        sc.nextLine();
        System.out.println("Plese enter the url of the picture: ");
        urlOfThePicture = sc.nextLine();
        System.out.println("Plese enter if the wetland is a protected area: 1) Yes 2) No ");
        int numProtectedArea = sc.nextInt();
        sc.nextLine();
        if(numProtectedArea == 1) {
            protectedArea = true;
        } else {
            protectedArea = false;
        }
        System.out.println("Plese enter the name of the name of the neighborhood (Urban) or township (Rural) ");
        locationName = sc.nextLine();
        System.out.println(controlObject.addWetland(name, locationZone, type, area, urlOfThePicture, protectedArea, locationName));
    }

    public void registerSpecie() {
        String nameWetland, name, scientificName;
        boolean migratorySpecie;
        int optionType;
        System.out.println("Please enter the name of the wetland where you want to add the specie: ");
        nameWetland = sc.nextLine();
        System.out.println("Please enter the name of the specie: ");
        name = sc.nextLine();
        System.out.println("Please enter the scientific name of the specie: ");
        scientificName = sc.nextLine();
        System.out.println("Please enter if the it is a migratory specie 1) Yes 2) No");
        int optionMigratorySpecie = sc.nextInt();
        if (optionMigratorySpecie == 1) {
            migratorySpecie = true;
        } else {
            migratorySpecie = false;
        }
        System.out.println("Please enter the type of the specie: " +
                            "\n1) Terrestrial flora "+
                            "\n2) Aquatic flora"+
                            "\n3) Bird"+
                            "\n4) Mammal" +
                            "\n5) Aquatic" );
        optionType = sc.nextInt();
        sc.nextLine();
        System.out.println(controlObject.addSpecie(nameWetland, name, scientificName, migratorySpecie, optionType));
    }

    public void registerEvent() {
        String nameWetland, eventClient,description;
        double price; 
        int day, month,  year, optionTypeEvent;
        System.out.println("Please enter the name of the wetland where you want to add the event: ");
        nameWetland = sc.nextLine();
        System.out.println("Please enter the name of the client of the event: ");
        eventClient = sc.nextLine();
        System.out.println("Please enter the price of the event: ");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Please enter the description of the event: ");
        description = sc.nextLine();
        System.out.println("Please enter the day of the event: ");
        day = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the month of the event: ");
        month = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the year of the event: ");
        year = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the type of the event: "+
                            "\n1) Maintenance"+
                            "\n2) School visits" +
                            "\n3) Improvement activities" +
                            "\n4) Celebrations");
        optionTypeEvent = sc.nextInt();
        sc.nextLine();
        System.out.println(controlObject.addEvent(nameWetland, eventClient, price, description, day, month, year, optionTypeEvent));
    }

    public void showSameSpecieInWetlands() {
        System.out.println("Enter the name the specie to search: ");
        String nameSpecie = sc.nextLine();
        System.out.println(controlObject.wetlandsWithSameSpecie(nameSpecie));
    }

    public void showWetlandWithLessFlora(){
        System.out.println("\n* The Wetland with the less flora is: " + controlObject.nameWetlandWithLessFlora());
    }

    public void showMaxNumberOfAnimalsInWetlands() {
        System.out.println("\n***** The number of the wetland with more animals : *****\n\n");
        System.out.println(controlObject.nameWetlandWithMoreAnimals());
    }
}
