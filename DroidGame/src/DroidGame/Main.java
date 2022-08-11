package DroidGame;

import DroidGame.BattleTypes.SoloBattle;
import DroidGame.BattleTypes.TeamBattle;
import DroidGame.Creation.CreateRobot;
import DroidGame.Droids.DroidData;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t\tCreate a droids to start play ");
        System.out.println("Set characteristics for \"Tank\" type:");
        DroidData tank = CreateRobot.makeDroid();
        System.out.println("Set characteristics for \"Hunter\" type:");
        DroidData hunter = CreateRobot.makeDroid();
        options(tank, hunter);

    }

    public static void options(DroidData tank, DroidData hunter) {
        System.out.println("\t\t\t\t\t\tMenu " +
                " \n1 - Show Robots" +
                " \t\t2 - Start play  " +
                "\t\t3 - Exit");
        int choice = scan.nextInt();
        switch (choice) {
            case 1: {
                printRobots(tank, hunter);
            }
            case 2:
                typeOfBattle(tank, hunter);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Error");
                System.exit(0);
        }
    }

    public static void typeOfBattle(DroidData tank, DroidData hunter) {
        System.out.println("\t\t\t\t\t\tSelect type of Battle " +
                " \n\t\t1 - Solo Battle" +
                " \t\t2 - Team Battle  ");
        int typeBattle = scan.nextInt();
        switch (typeBattle) {
            case 1:
                SoloBattle.chooseRobot(tank, hunter);
                options(tank, hunter);
                break;
            case 2:
                TeamBattle.battle(tank, hunter);
                break;
            default:
                System.out.println("Error");
                System.exit(0);
        }
    }

    public static void printRobots(DroidData tank, DroidData hunter) {
        System.out.println("Tank");
        System.out.println(tank.printRobot());
        System.out.println("Hunter");
        System.out.println(hunter.printRobot());
        hunter.printRobot();
    }

}
