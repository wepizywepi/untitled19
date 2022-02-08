import com.company.*;
public class RpgGame {
        private static int roundCounter = 1;
        private static void printStatistics(Hero heroes[], Boss boss){
            System.out.println("_");
            System.out.println("Round; " + roundCounter);
            System.out.println("Boss health " + boss.getHealth());
            for (Hero hero : heroes){
                System.out.println(hero.getClass().getSimpleName()
                        + " current health: " + hero.getHealth());
            }
            System.out.println("_");
        }
        private static void heroesHits(Hero heroes[], Boss boss) {
            for (Hero hero : heroes) {
                int heroDamage = hero.getDamage();
                boss.damage(heroDamage);
                System.out.println(hero.getClass().getSimpleName()
                        + " attack Boss " + heroDamage);
            }
        }
        private static void bossHits(Hero heroes[], Boss boss) {
            for (Hero hero : heroes) {
                int bossDamage = boss.getDamage();
                hero.damage(bossDamage);
                System.out.println("Boss attack " + hero.getClass().getSimpleName()
                        + " attack Boss " + bossDamage);
            }
        }
        private static boolean isFinish(Hero[] heroes, Boss boss){
            if (boss.getHealth() <= 0){
                System.out.println("Heroes won!!");
                return true;
            }
            boolean allHeroesDead = true;
            for (Hero hero : heroes){
                if (hero.getHealth() > 0){
                    allHeroesDead = false;
                    break;
                }
            }
            if (allHeroesDead){
                System.out.println("Boss won!!");
            }
            return allHeroesDead;
        }
        private static void roundI(Hero heroes[], Boss boss){
            bossHits(heroes, boss);

            heroesHits(heroes, boss);
            applyAbility(heroes, boss);

            printStatistics(heroes, boss);
        }
        private static void applyAbility(Hero heroes[], Boss boss){
            for (Hero hero : heroes){
                hero.useAbility(heroes, boss);
            }
        }
        private static Hero[] creatHeroes(){
            Golem golem = new Golem(1200, 50);
            Warrior warrior = new Warrior(1200, 50);
            Magic magic = new Magic(1200, 50);
            Hero[] heroes = {golem, warrior, magic};
            return heroes;
        }
        public static void startGame(){
            Hero[] heroes = creatHeroes();
            Boss boss = new Boss(4000, 50);
            printStatistics(heroes, boss);
            while (!isFinish(heroes, boss)){
                roundI(heroes, boss);
                roundCounter++;
            }
        }

    }


