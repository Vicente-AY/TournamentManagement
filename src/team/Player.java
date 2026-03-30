package team;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    int id = 0;
    String name = "";
    String surnames = "";

    public Player(int id, String name, String surnames) {

        this.id = id;
        this.name = name;
        this.surnames = surnames;
    }

    public static void addPlayer(ArrayList<Team> teams) {

        Scanner input = new Scanner(System.in);

        System.out.println("Type the id of the player");
        int id = input.nextInt();
        input.nextLine();

        Team teamToAddPlayer = null;

        for(Team team : teams) {
            if(team.id == id){
                teamToAddPlayer = team;
            }
        }

        if(teamToAddPlayer != null){
            System.out.println("Introduce the name of the Player");
            String name = input.nextLine();

            System.out.println("Introduce the surname of the Player");
            String surname = input.nextLine();

            Player player = new Player(id, name, surname);
            teamToAddPlayer.members.add(player);
            System.out.println("Player " + name + " " + surname + " with ID: " + id + " has been added to the team");
        }
        else{
            System.out.println("ID not found");
        }
    }
}
