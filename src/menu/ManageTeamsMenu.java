package menu;

import java.util.Scanner;

public class ManageTeamsMenu {

    Scanner input = new Scanner(System.in);

    public void manageTeamsMenu() {

        int choice = 0;
        while(true) {
            System.out.println("Team Management Menu");
            System.out.println("1. Add Team | 2. Add Player to a team | 3. Remove Player from a team");
            System.out.println("4. Remove Team | 5. Back");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    removePlayer();
                    break;
                case 4:
                    removeTeam();
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
