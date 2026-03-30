package tournament;

import team.Sport;
import team.Team;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tournament {

    int id = 0;
    String name = "";
    Sport sport = null;
    double price = 0;
    ArrayList<Team> teams = new ArrayList<Team>();
    LocalDateTime startDate = null;
    LocalDateTime endDate = null;
    Location location = null;


    public Tournament(int id, String name, Sport sport, double price, LocalDateTime startDate, Location location){

        this.id = id;
        this.name = name;
        this.sport = sport;
        this.price = price;
        this.startDate = startDate;
        this.location = location;
    }

    public static void createTournament(ArrayList<Tournament> tournaments, ArrayList<Location> locations){

        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        int id = 0;
        for(Tournament tournament : tournaments){
            if(tournament.id > id){
                id = tournament.id;
            }
        }
        id++;

        System.out.println("Enter the name of the Tournament");
        String name = input.nextLine();

        Sport sport = null;
        int option = 0;
        boolean cont = true;
        while(cont) {
            System.out.println("Enter the Sport of the Tournament");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    sport = Sport.Chess;
                    cont = false;
                    break;
                case 2:
                    sport = Sport.Padle;
                    cont = false;
                    break;
                case 3:
                    sport = Sport.Basketball;
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        System.out.println("Enter the price of the Tournament");
        double price = input.nextDouble();
        input.nextLine();

        System.out.println("Enter the start date of the Tournament (DD/MM/YYYY)");
        String startDateString = input.nextLine();

        System.out.println("Enter the start time of the Tournament (HH:MM:SS)");
        String startTimeString = input.nextLine();

        String start = startDateString + " " + startTimeString;

        LocalDateTime startDate = LocalDateTime.parse(start, formatter);

        System.out.println("Enter the location: ");
        for(int i  = 0; i < locations.size(); i++){
            System.out.println("Option: " + (i + 1) + " " +  locations.get(i).name + " Adress: " + locations.get(i).address);
            System.out.println("Which has: ");
            System.out.println(locations.get(i).infrastructure[0] + " Boards of Chess");
            System.out.println(locations.get(i).infrastructure[1] + " Courts of Padle");
            System.out.println(locations.get(i).infrastructure[2] + " Courts of Basketball");
        }
        int infraOption = input.nextInt();
        input.nextLine();

        Location location = locations.get(infraOption -1);

        Tournament newTournament = new Tournament(id, name, sport, price, startDate, location);

        tournaments.add(newTournament);
        System.out.println("Tournament Created");
        System.out.println(newTournament.name + " Tournament of " + newTournament.sport + " will be celebrated at " + newTournament.startDate + " in " + newTournament.location);
    }
}
