package menu;

import java.util.Scanner;

public class MainMenu {

    Scanner input = new Scanner(System.in);

    public void mainMenu(){

        int choice = 0;
        while(true) {
            System.out.println("Welcome to Tournament Management APP");
            System.out.println("1. Manage Teams | 2. Manage Tournaments | 3. Exit application");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    ManageTeamsMenu manageteams = new ManageTeamsMenu();
                    manageteams.manageTeamsMenu();
                    break;
                case 2:
                    ManageTournamentsMenu manageTournaments = new ManageTournamentsMenu();
                    manageTournaments.manageTournamentsMenu();
                    break;
                case 3:
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
