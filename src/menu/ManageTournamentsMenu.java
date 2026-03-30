package menu;

import team.Team;
import tournament.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageTournamentsMenu {

    public void manageTournamentsMenu(ArrayList<Tournament> tournaments, ArrayList<Location> locations, ArrayList<Team> teams) {

        Scanner input = new Scanner(System.in);

        int option = 0;
        while(true) {
            System.out.println("- - - Tournament Management Menu - - -");
            System.out.println("1. Add new Location | 2. Add new Tournament | 3. Add Team to a Tournament");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    Location.createLocation(locations);
                    break;
                case 2:
                    Tournament.createTournament(tournaments, locations);
                    break;
                case 3:
                    addPlayerToATeam(tournaments, teams);
                    break;
            }
        }
    }

    public void addTeamToATournament(ArrayList<Tournament> tournaments, ArrayList<Team> teams) {

        Scanner input = new Scanner(System.in);
        int teamId = 0;
        System.out.println("Enter the ID of the Team you want to add to a Tournament");
        teamId = input.nextInt();
        input.nextLine();

        Team teamToAssign = null;

        for(Team team : teams) {
            if(team.getId() == teamId){
                teamToAssign = team;
            }
        }

        System.out.println("Team ID: " + teamToAssign.getId() + " Name " + teamToAssign.getName() + " Selected");

        if(teamToAssign != null) {
            if (teamToAssign.getPlayers().size() >= teamToAssign.getSport().getValue()) {
                System.out.println("Enter the ID of the Tournament you want to add the Selected Team");
                int tournamentId = input.nextInt();
                input.nextLine();

                Tournament tournamentToAssign = null;
                for (Tournament tournament : tournaments) {
                    if (tournament.getId() == tournamentId) {
                        tournamentToAssign = tournament;
                    }
                }
                if (tournamentToAssign != null) {
                    if (teamToAssign.getSport() == tournamentToAssign.getSport()) {
                        System.out.println("Are you sure you want to sign " + teamToAssign.getName() + " to " + tournamentToAssign.getName() + " ?");
                        String answer = input.nextLine();
                        if (answer.equalsIgnoreCase("yes") && answer.equalsIgnoreCase("y")) {
                            tournamentToAssign.getTeams().add(teamToAssign);
                            System.out.println("Team added successfully");
                        }
                        else {
                            System.out.println("Cancelling operation");
                        }
                    }
                    else {
                        System.out.println("The team competes in another Sport");
                    }
                }
                else {
                    System.out.println("Tournament ID not found");
                }
            }
            else{
                System.out.println("The team has no enough Players for the tournament");
            }
        }
        else{
            System.out.println("Team ID not found");
        }
    }
}
