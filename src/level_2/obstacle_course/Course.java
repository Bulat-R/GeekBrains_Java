package level_2.obstacle_course;

import level_2.team.Team;
import level_2.team.Teammate;
import java.util.ArrayList;

public class Course {
    private final ArrayList<Obstacle> courseList = new ArrayList<>();

    public void add(Obstacle obstacle) {
        courseList.add(obstacle);
    }

    public void doIt (Team team) throws Exception {
        if (courseList.isEmpty()) {
            throw new Exception("Course is empty");
        }

        System.out.println(team + " выходит на полосу препятствий");
        System.out.println();

        team.getResultList().addAll(team.getTeamList());

        for (int i = 0; i < courseList.size(); i++) {
            Obstacle obstacle = courseList.get(i);
            System.out.println("Препятствие №" + (i + 1) + " " + obstacle.toString());
            System.out.println("=======================================");
            for (int j = 0; j < team.getResultList().size(); j++) {
                Teammate teammate = team.getResultList().get(j);
                if (obstacle instanceof Wall) {
                    if (!teammate.canJump(((Wall)obstacle).getHeight())) {
                        team.getResultList().remove(teammate);
                        j--;
                    }
                }
                if (obstacle instanceof Treadmill) {
                    if (!teammate.canRun(((Treadmill)obstacle).getDistance())) {
                        team.getResultList().remove(teammate);
                        j--;
                    }
                }
            }
            if (team.getResultList().isEmpty()) {
                System.out.println();
                return;
            }
            System.out.println();
        }
    }
}
