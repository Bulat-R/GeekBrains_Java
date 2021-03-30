package level_2;

import level_2.obstacle_course.*;
import level_2.team.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Team team = new Team(3);
        team.add(new Cat());
        team.add(new Human());
        team.add(new Robot());

        Course course = new Course();
        course.add(new Wall());
        course.add(new Treadmill());
        course.add(new Wall());
        course.add(new Treadmill());

        course.doIt(team);
        team.showResult();
    }
}
