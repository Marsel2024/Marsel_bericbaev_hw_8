package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Vampire extends Hero{
    private  int vampires;
    public Vampire(int health, int damage, String name) {
        super(health, damage, SuperAbility.TRANSFORMATION, name);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int blood = RPG_Game.random.nextInt(20) + 1;
        vampires = blood;
        boss.setHealth(boss.getHealth() - vampires);
        System.out.println("Alucard востановил: " + vampires + " Здоровья ");
        this.setHealth(this.getHealth() + vampires);

        int transform = RPG_Game.random.nextInt(20) + 1;
        boolean transformation = false;
        if (transform % 2 == 0){
            transformation = true;
            this.setHealth(getHealth() - (boss.getDamage()/2));
            System.out.println("Alucard transform ");

        }else
            this.setHealth(getHealth() - boss.getDamage());
    }
}
