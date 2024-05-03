package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero {
    int stolenHealth;

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.THEFT, name);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stolenHealth = boss.getHealth() -  RPG_Game.random.nextInt(1500);
        for (int i = 0; i < heroes.length; i++) {
            i = RPG_Game.random.nextInt(heroes.length);
            heroes[i].setHealth(heroes[i].getHealth() + stolenHealth);
            System.out.println("Hacker take health boss");
            break;

        }
    }
}
