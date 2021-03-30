package level_2.team;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Team {
    private final ArrayList<Teammate> teamList = new ArrayList<>();
    private final ArrayList<Teammate> resultList = new ArrayList<>();
    private String name;
    private int teammateNumbers;
    private static int count;

    public ArrayList<Teammate> getTeamList() {
        return teamList;
    }

    public ArrayList<Teammate> getResultList() {
        return resultList;
    }

    public Team(int teammateNumbers) {
        this.teammateNumbers = teammateNumbers;
        name = "Команда №" + ++count;
    }

    public void add(Teammate teammate) throws Exception {
        if (teammateNumbers > teamList.size()) {
            teamList.add(teammate);
        } else throw new Exception("Can't add teammate. Team already full");

    }

    public void showResult() {
        if (resultList.isEmpty()) {
            System.out.println("Команда не прошла полосу препятствий");
        } else {
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (Teammate teammate : resultList) {
                stringJoiner.add(teammate.toString());
            }
            System.out.println("Команда прошла полосу препятствий в составе: " + stringJoiner);
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Teammate teammate : teamList) {
            stringJoiner.add(teammate.toString());
        }
        return name + ": " + stringJoiner;
    }
}
