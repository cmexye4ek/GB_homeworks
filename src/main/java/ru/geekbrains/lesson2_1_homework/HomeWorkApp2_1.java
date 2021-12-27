package ru.geekbrains.lesson2_1_homework;

public class HomeWorkApp2_1 {
    public static void main(String[] args) {
        Team team = new Team("1st team");
        Course course = new Course();
        team.printMembersList();
        course.passObstacleCourse(team);
        team.showResults();


    }


}
