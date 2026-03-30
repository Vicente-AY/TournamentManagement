package team;

import java.time.LocalDateTime;
import java.util.ArrayList;

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


}
