
    public class Golem extends Hero {
        public Golem(int health, int damage) {
            super(health, damage);
        }
        @Override
        public void useAbility(Hero[] heroes, Boss boss) {
            int damage = boss.getDamage() / 2;
            this.damage = this.damage + damage;
            System.out.println("Golem used her Ability " + this.damage);
        }
    }

