package DroidGame.BattleTypes;

import DroidGame.Droids.DroidData;
import DroidGame.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;


public class SoloBattle {
    static Scanner scan = new Scanner(System.in);

    public static void chooseRobot(DroidData tank, DroidData hunter) {
        System.out.println("Choose your robot " +
                " 1 - Hunter " +
                " 2 - Tank ");
        int typeOfRobot = scan.nextInt();
        switch (typeOfRobot) {
            case 1: {
                soloBattle(hunter, tank);
                recoveryAfterBattle(hunter, tank);
                break;
            }
            case 2: {
                soloBattle(tank, hunter);
                recoveryAfterBattle(hunter, tank);
                break;
            }
        }
    }

    public static void soloBattle(DroidData yourRobot, DroidData enemyRobot) {
        System.out.println("First attack will be choosen by random");
        attack(yourRobot, enemyRobot);
        resultOfBattle(yourRobot, enemyRobot);
    }

    public static String resultOfBattle(DroidData yourRobot, DroidData enemyRobot) {
        String result = "";
        if (!yourRobot.getStateOfLive() && !enemyRobot.getStateOfLive()) {
            result = "\t\t\t\tDRAW";
        } else {
            if (!yourRobot.getStateOfLive()) {
                result = "\t\t\t\tYOU LOST";
            } else if (!enemyRobot.getStateOfLive()) result = "\t\t\t\tYOU WON";
        }
        return result;
    }

    public static void attack(DroidData yourRobot, DroidData enemyRobot) {
        int numberOfRound = 1;
        boolean checkFile = false;
        while (yourRobot.getStateOfLive() && enemyRobot.getStateOfLive()) {
            System.out.println("\t\t\t\tRound " + numberOfRound);
            int firstStep = 1 + (int) (Math.random() * 2);
            if (firstStep == 1) {
                yourRobot.takeDamage(enemyRobot.getDamage());
                enemyRobot.takeDamage(yourRobot.getDamage());
            } else {
                enemyRobot.takeDamage(yourRobot.getDamage());
                yourRobot.takeDamage(enemyRobot.getDamage());
            }
            System.out.println("States about robot after " + numberOfRound + " round");
            Main.printRobots(yourRobot, enemyRobot);
            checkFile = saveFile(yourRobot, enemyRobot, numberOfRound, checkFile);
            numberOfRound++;
        }
    }

    public static void recoveryAfterBattle(DroidData tank, DroidData hunter) {
        tank.setHealth();
        hunter.setHealth();
    }

    public static boolean saveFile(DroidData yourRobot, DroidData enemyRobot, int roundNumber, boolean checkFile) {
        try (FileWriter writer = new FileWriter("SoloBattle.txt", true)) {
            if (!checkFile) {
                new Formatter("SoloBattle.txt").format("");
                checkFile = true;
            }
            writer.write("Round " + roundNumber + "\n");

            writer.write("Your robot : " + yourRobot.printRobot() + "\n");
            writer.write("Enemy robot : " + enemyRobot.printRobot() + "\n");
            writer.write(resultOfBattle(yourRobot, enemyRobot));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return checkFile;
    }


}
