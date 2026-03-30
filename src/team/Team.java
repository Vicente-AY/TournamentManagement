package team;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    int id = 0;
    String name = "";
    Sport sport = null;
    ArrayList<Player> players = new ArrayList<>();

    public Team(int id, String name, Sport sport) {

        this.id = id;
        this.name = name;
        this.sport = sport;
    }

    public static void addTeam(ArrayList<Team> teams) {

        Scanner input = new Scanner(System.in);

        int id = 0;
        for (Team team : teams) {
            if (team.id > id) {
                id = team.id;
            }
        }
        id++;

        System.out.println("Enter the name of the Team");
        String teamName = input.nextLine();

        int option = input.nextInt();
        input.nextLine();
        boolean cont = true;
        Sport sport = null;
        while (cont) {
            System.out.println("Enter the Sport of the Team");
            System.out.println("1. Chess | 2. Padel | 3. Basket");
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

        Team newTeam = new Team(id, teamName, sport);
        teams.add(newTeam);
        System.out.println(sport + " Team " + teamName + " with ID: " + id + " Crated");
    }

    public static void removePlayer(ArrayList<Team> teams) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the ID of the Team you want to remove a player from");
        int id = input.nextInt();

        Team teamToRemovePlayer = null;

        for (Team team : teams) {
            if (team.id == id) {
                teamToRemovePlayer = team;
            }
        }

        Player playerToRemove = null;

        if (teamToRemovePlayer != null) {
            System.out.println("Enter the option of the Player you want to remove");
            if (!teamToRemovePlayer.players.isEmpty()) {
                for (int i = 0; i < teamToRemovePlayer.players.size(); i++) {
                    System.out.println("Option: " + (i +1) + " Name: " + teamToRemovePlayer.players.get(i).name
                    + " Surname: " + teamToRemovePlayer.players.get(i).surnames);
                }
                int option = input.nextInt();
                input.nextLine();
                playerToRemove = teamToRemovePlayer.players.get(option -1);

                System.out.println("Are you sure you want to remove Player ID: " + playerToRemove.id + " Name: " + playerToRemove.name + " " + playerToRemove.surnames + "?");
                System.out.println("Y/N");
                String delete = input.nextLine();
                if (delete.equalsIgnoreCase("y") || delete.equalsIgnoreCase("yes")) {
                    teamToRemovePlayer.players.remove(playerToRemove);
                    System.out.println("Player removed");
                }
                else{
                    System.out.println("Operation cancelled");
                }
            }
            else{
                System.out.println("The team has no active Players");
            }
        }
        else {
            System.out.println("ID not found");
        }
    }

    public static void removeTeam(ArrayList<Team> teams){

        Scanner input = new Scanner(System.in);

        int id = 0;
        Team teamToRemove = null;

        System.out.println("Enter the id of the Team you want to remove");
        id = input.nextInt();
        input.nextLine();

        for(Team team : teams){
            if (team.id == id){
                teamToRemove = team;
            }
        }

        if(teamToRemove != null){
            if(teamToRemove.players.isEmpty()){
                System.out.println("Are you sure you want to remove Team ID: " + teamToRemove.id + " " + teamToRemove.name);
                String delete = input.nextLine();
                if(delete.equalsIgnoreCase("y") || delete.equalsIgnoreCase("yes")){
                    teams.remove(teamToRemove);
                    System.out.println("Team removed");
                }
                else{
                    System.out.println("Operation cancelled");
                }
            }
            else{
                System.out.println("The team still has active Players. Delete them first");
            }
        }
        else{
            System.out.println("ID not found");
        }
    }




    //Getters y setters

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Sport getSport(){
        return this.sport;
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
}
