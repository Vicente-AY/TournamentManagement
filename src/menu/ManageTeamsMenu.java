package menu;

import team.Player;
import team.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageTeamsMenu {

    Scanner input = new Scanner(System.in);

    public void manageTeamsMenu(ArrayList<Team> teams) {

        int choice = 0;
        while(true) {
            System.out.println("Team Management Menu");
            System.out.println("1. Add Team | 2. Add Player to a team | 3. Remove Player from a team");
            System.out.println("4. Remove Team | 5. Back");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    Team.addTeam(teams);
                    break;
                case 2:
                    Player.addPlayer(teams);
                    break;
                case 3:
                    Team.removePlayer(teams);
                    break;
                case 4:
                    Team.removeTeam(teams);
                    break;
                case 5:
                    System.out.println("Returning to Main Menu");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }


}
