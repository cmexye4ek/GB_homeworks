package ru.geekbrains.lesson2_1_homework;

import java.util.Arrays;

public class Team {
    private String teamName;
    private Moving[] teamMembers;

    public Team(String teamName) {
        this.teamName = teamName;
        Moving catOne = new Cat("Барсик");
        Moving catTwo = new Cat("Мурзик");
        Moving human = new Human("Иван");
        Moving robot = new Robot("Kill_All_Humans");
        this.teamMembers = new Moving[]{catOne, catTwo, human, robot};
    }

    public void printMembersList() {
        System.out.println("Команда: " + teamName);
        System.out.println("Состав участников:");
        for (Moving teamMember : teamMembers) {
            System.out.println("Имя участника: " + teamMember.getName() + " Расстояние которое может пробежать, м: " + teamMember.getRunLength() + " Высота прыжка, см: " + teamMember.getJumpHeight());
        }

    }
/*  реализация вывода участников если в интерфейсе нет геттеров (а в задании насчет этого ничего нету, поэтому интерфейс я могу делать как хочу) через cast и instanceof.

        for (int i = 0; i < teamMembers.length; i++) {
            if (teamMembers[i] instanceof Cat) {
                System.out.println("Имя участника: " + ((Cat) teamMembers[i]).getName() + " Расстояние которое может пробежать, м: " + ((Cat) teamMembers[i]).getRunLength() + " Высота прыжка, см: " + ((Cat) teamMembers[i]).getJumpHeight());
            }
            if (teamMembers[i] instanceof Human) {
                System.out.println("Имя участника: " + ((Human) teamMembers[i]).getName() + " Расстояние которое может пробежать, м: " + ((Human) teamMembers[i]).getRunLength() + " Высота прыжка, см: " + ((Human) teamMembers[i]).getJumpHeight());
            }
            if (teamMembers[i] instanceof Robot) {
                System.out.println("Имя участника: " + ((Robot) teamMembers[i]).getName() + " Расстояние которое может пробежать, м: " + ((Robot) teamMembers[i]).getRunLength() + " Высота прыжка, см: " + ((Robot) teamMembers[i]).getJumpHeight());
            }
        }
    }
*/

    public void showResults() {
        int count = 0;
        System.out.println("Соревнование окончено!!!");
        System.out.println("Список участников прошедших полосу препятствий:");
        for (Moving teamMember : teamMembers) {
            if (teamMember.getSuccess()) {
                count++;
                System.out.println(teamMember.getName());
            }

        }
        if (count == 0) {
            System.out.println("Соревнование оказалось слишком сложным для участников. Победителей нет");
        }
    }

    public Moving[] getTeamMembers() {
        return this.teamMembers;
    }
}