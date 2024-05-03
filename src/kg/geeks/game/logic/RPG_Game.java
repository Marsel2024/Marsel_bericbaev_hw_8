package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss(2000, 50, "Thanos ");
        Warrior warrior1 = new Warrior(260, 20, "Captain America ");
        Warrior warrior2 = new Warrior(280, 10, "Ten ");
        Magic magic = new Magic(270, 20, "Scorpion ");
        Berserk berserk = new Berserk(240, 15, "Hulk ");
        Medic doc = new Medic(250, 5, 15, "Zeus ");
        Medic assistant = new Medic(300, 5, 5, "Ahiles ");
        Hacker mrRobot = new Hacker(200,19,"Mr.Robot ");
        Vampire vampire = new Vampire(150, 20, "Alucard ");
        Witcher witcher = new Witcher(50, 10, "Geralt");

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant,mrRobot,vampire,witcher};
        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);

    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
