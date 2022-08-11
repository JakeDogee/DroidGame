package DroidGame.Droids;

public class DroidData {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private boolean stateOfLive;

    DroidData(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        stateOfLive = true;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean getStateOfLive() {
        return stateOfLive;
    }

    public void setHealth() {
        this.health = this.maxHealth;
    }

    public String printRobot() {
        return ("Name:" + name + " Health:" + health + " Damage:" + damage);
    }

    public void takeDamage(int damageTaken) {
        this.health -= damageTaken;
        if (this.health <= 0) {
            this.health = 0;
            this.stateOfLive = false;
        }
    }
}
