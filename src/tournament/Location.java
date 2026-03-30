package tournament;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Location {

    int id = 0;
    String name = "";
    String address = "";
    //First for chess, second for padel, third for Basket
    int[] infrastructure = new int[3];
    int[] freeInfrastructure = new int[3];

    public Location(int id, String name, String Adress){

        this.name = name;
        this.address = Adress;
    }

    public static void createLocation(ArrayList<Location> locations){

        Scanner input = new Scanner(System.in);

        int id = 0;
        for(Location location : locations){
            if(location.id > id){
                id = location.id;
            }
        }
        id++;

        System.out.println("Enter the Location name");
        String name = input.nextLine();

        System.out.println("Enter the Location address");
        String address = input.nextLine();

        Location newLocation = new Location(id, name, address);

        System.out.println("The amount of Chess boards of the Location");
        int chess = input.nextInt();
        input.nextLine();
        newLocation.infrastructure[0] = chess;
        newLocation.freeInfrastructure[0] = chess;

        System.out.println("Enter the amount of paddle tennis courts of the Location");
        int padle = input.nextInt();
        input.nextLine();
        newLocation.infrastructure[1] = padle;
        newLocation.freeInfrastructure[1] = padle;

        System.out.println("Enter the amount of Basketball courts of the Location");
        int basket = input.nextInt();
        input.nextLine();
        newLocation.infrastructure[2] = basket;
        newLocation.freeInfrastructure[2] = basket;

        locations.add(newLocation);
        System.out.println("The location with ID: " + newLocation.id + " and Name: " + newLocation.name + " has been created");
    }


}
