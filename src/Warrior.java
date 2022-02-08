import java.util.Random;
    public class Warrior extends Hero {
        public Warrior(int health, int damage) {
            super(health, damage);
        }
        @Override
        public void useAbility(Hero[] heroes, Boss boss) {
            int damage = new Random().nextInt(0) + 4;
            this.damage = this.damage * damage;
            System.out.println("Warrior used her Ability " + this.damage);
        }
    }
