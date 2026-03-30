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
    int maxMatches = 0;


    public Tournament(int id, String name, Sport sport, double price, LocalDateTime startDate, Location location, int maxMatches){

        this.id = id;
        this.name = name;
        this.sport = sport;
        this.price = price;
        this.startDate = startDate;
        this.location = location;
        this.maxMatches = maxMatches;
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

        ArrayList<Location> locationSport = new ArrayList<>();

        System.out.println("Enter the location: ");
        if(locationSport.isEmpty()) {
            for (int i = 0; i < locations.size(); i++) {
                if (sport == Sport.Chess && locations.get(i).freeInfrastructure[0] > 0) {
                    locationSport.add(locations.get(i));
                }
                if (sport == Sport.Padle && locations.get(i).freeInfrastructure[1] > 0) {
                    locationSport.add(locations.get(i));
                }
                if (sport == Sport.Basketball && locations.get(i).freeInfrastructure[2] > 0) {
                    locationSport.add(locations.get(i));
                }
                for (int j = 0; j < locationSport.size(); j++) {
                    System.out.println("Option: " + (i + 1) + " " + locations.get(i).name + " Adress: " + locations.get(i).address);
                    System.out.println("Which has available: ");
                    if(sport == Sport.Chess){
                        System.out.println(locations.get(i).freeInfrastructure[0] + " Boards of Chess");
                    }
                    if(sport == Sport.Padle){
                        System.out.println(locations.get(i).freeInfrastructure[1] + " Courts of Padle");
                    }
                    if(sport == Sport.Basketball){
                        System.out.println(locations.get(i).freeInfrastructure[2] + " Courts of Basketball");
                    }
                }
            }
        }
        else{
            System.out.println("There are no suitable Locations at the moment");
        }
        int infraOption = input.nextInt();
        input.nextLine();

        Location location = locations.get(infraOption -1);

        System.out.println("Enter the total infrastructure you want for the Tournament");
        int maxMatches = input.nextInt();
        input.nextLine();
        if(sport == Sport.Chess) {
            if (maxMatches < location.freeInfrastructure[0]){
                location.freeInfrastructure[0] -= maxMatches;
            }
            else{
                System.out.println("Not enough Infrastructure");
                return;
            }
        }
        if(sport == Sport.Padle) {
            if(maxMatches > location.freeInfrastructure[1]){
                location.freeInfrastructure[1] -= maxMatches;
            }
            else{
                System.out.println("Not enough Infrastructure");
                return;
            }
        }
        if(sport == Sport.Basketball) {
            if(maxMatches > location.freeInfrastructure[2]){
                location.freeInfrastructure[2] -= maxMatches;
            }
            else{
                System.out.println("Not enough Infrastructure");
                return;
            }
        }

        Tournament newTournament = new Tournament(id, name, sport, price, startDate, location, maxMatches);

        tournaments.add(newTournament);
        System.out.println("Tournament Created");
        System.out.println(newTournament.name + " Tournament of " + newTournament.sport + " will be celebrated at " + newTournament.startDate + " in " + newTournament.location);
    }

    //Getters and Setters

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Sport getSport(){
        return sport;
    }
    public double getPrice(){
        return price;
    }
    public LocalDateTime getStartDate(){
        return startDate;
    }
    public Location getLocation(){
        return location;
    }
    public int getMaxMatches(){
        return maxMatches;
    }
    public ArrayList<Team> getTeams(){
        return teams;
    }
}
