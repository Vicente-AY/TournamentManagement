package tournament;

import team.Team;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Tournament {

    int id = 0;
    String name = "";
    double price = 0;
    ArrayList<Team> teams = new ArrayList<Team>();
    LocalDateTime startDate = null;
    Location location = null;
}
