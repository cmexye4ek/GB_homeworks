package ru.geekbrains.lesson2_1_homework;

public class Course {
    private Obstacle[] obstacles;

    public Course() {
        Obstacle runningTrack1 = new RunningTrack();
        Obstacle runningTrack2 = new RunningTrack();
        Obstacle runningTrack3 = new RunningTrack();
        Obstacle runningTrack4 = new RunningTrack();
        Obstacle wall1 = new Wall();
        Obstacle wall2 = new Wall();
        Obstacle wall3 = new Wall();
        Obstacle wall4 = new Wall();
        this.obstacles = new Obstacle[]{runningTrack1, wall1, runningTrack2, wall2, runningTrack3, wall3, runningTrack4, wall4};
    }

    public void passObstacleCourse(Team team) {
        Moving[] teamMembers = team.getTeamMembers();
        System.out.println("Соревнования начинаются!!!");
        for (int i = 0; i < teamMembers.length; i++) {
            System.out.println("Участник №" + (i + 1) + " " + teamMembers[i].getName() + ":");
            for (int j = 0; j < obstacles.length; j++) {
                System.out.println((j + 1) + " препятствие: ");
                if (obstacles[j] instanceof RunningTrack) {
                    System.out.print("Беговая дорожка, её длина: " + ((RunningTrack) obstacles[j]).getTrackLength() + "м");
                    System.out.println();
                    teamMembers[i].run((RunningTrack) obstacles[j]);
                    if (!teamMembers[i].getSuccess()) {
                        break;
                    }
                }

                if (obstacles[j] instanceof Wall) {
                    System.out.print("Барьер, его высота: " + ((Wall) obstacles[j]).getWallHeight() + "см");
                    System.out.println();
                    teamMembers[i].jump((Wall) obstacles[j]);
                    if (!teamMembers[i].getSuccess()) {
                        break;
                    }

                }

            }
        }

    }
}