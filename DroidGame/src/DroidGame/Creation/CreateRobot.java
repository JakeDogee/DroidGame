package DroidGame.Creation;

import java.util.Scanner;

import DroidGame.Droids.DroidData;
import DroidGame.Droids.Droid;

public class CreateRobot {

    static Scanner scan = new Scanner(System.in);

    public static String inputName() {
        System.out.println("Input name of your droid");
        String name = scan.next();
        return name;
    }

    public static int inputHealth() {
        System.out.println("Input health of your droid");
        int health = scan.nextInt();
        return health;
    }

    public static int inputDamage() {
        System.out.println("Input damage of your droid");
        int damage = scan.nextInt();
        return damage;
    }

    public static DroidData makeDroid() {
        Droid droid = new Droid(inputName(), inputHealth(), inputDamage());
        return droid;
    }


}
