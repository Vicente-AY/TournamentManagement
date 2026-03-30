package team;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    int id = 0;
    String name = "";
    Sport sport = null;
    ArrayList<Player> members = new ArrayList<>();

    public Team(int id, String name, Sport sport) {

        this.id = id;
        this.name = name;
        this.sport = sport;
    }

    public static void addTeam(ArrayList<Team> teams) {

        Scanner input = new Scanner(System.in);

        int id =  0;
        for (Team team : teams) {
            if(team.id == id) {
                id = team.id;
            }
        }
        id++;

        System.out.println("Introduce the name of the Team");
        String teamName = input.nextLine();

        int option = input.nextInt();
        input.nextLine();
        boolean cont = true;
        Sport sport = null;
        while(cont){
            System.out.println("Introduce the Sport of the Team");
            System.out.println("1. Chess | 2. Padel | 3. Basket");
            switch(option){
                case 1:
                    sport = Sport.Chess;
                    cont = false;
                    break;
                case 2:
                    sport = Sport.Padel;
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
}
