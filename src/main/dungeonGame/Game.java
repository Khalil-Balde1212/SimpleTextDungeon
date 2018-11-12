import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game{
    public static void main(String[] args) throws InterruptedException{
        //System objects
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        //enemy variables
        String[] enemies = { 
                "Millenial", 
                "Trump Supporter", 
                "Furry", 
                "Killer Keemstar", 
                "Triggered Social Justice Warrior", 
                "Obnoxious Vegan", 
                "Donald Trump :The man himself", 
                "Kim Jung Un", 
                "Logan Paul", 
                "Jake Paul", 
                "KSI" };
        
        int e_maxHealth = 100;
        int e_maxDamage = 25;

        //player variables
        int p_health = 100;
        int p_maxDamage = 50;
        int p_numHealthPots = 2;
        int p_healthPotVal = 20;
        int p_healthPotDrop = 50; //percent
        
        boolean running = true;

        System.out.println("Welcome to this example!");
        GAME:
        while(running){
            System.out.println("---------------------------------------------------------------------------------------");
            int e_health = rand.nextInt(e_maxHealth) + 1;
            String e_enem = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + e_enem + " Appeared! #\n");

            while(e_health > 0){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("\tYour HP: " + p_health);
                System.out.println("\t" + e_enem + "'s HP: " + e_health);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink potion (" + p_numHealthPots + ")");
                System.out.println("\t3. Yeet away");

                String input = scanner.nextLine();
                switch(input){
                    case "1": //enemy
                    int p_damageDealt = rand.nextInt(p_maxDamage);
                    int e_damageDealt = rand.nextInt(e_maxDamage);

                    if (e_enem == "Donald Trump :The man himself") {
                        System.out.println("\t>Donald protected himself with a wall! you deal less damage 10");
                        e_damageDealt += 10;
                    }

                    e_health -= Math.max(p_damageDealt,0);
                    p_health -= Math.max(e_damageDealt,0);

                    System.out.println("\t>You strike the " + e_enem + " for " + p_damageDealt + " damage!");
                    System.out.println("\t>The" + e_enem + " strikes you for " + e_damageDealt + " damage!");
                    break;

                    case "2":
                    if (p_numHealthPots > 0) {
                        p_health += p_healthPotVal;
                        p_numHealthPots--;
                        System.out.println("\t> You drink a health potion for " + p_healthPotVal + " health!");
                        System.out.println("\t you now have " + p_health + " health");
                        System.out.println("\t you now have " + p_numHealthPots + " health potions");
                    } else {
                        System.out.println("\t> No more health potions! Defeat enemies for a chance to get one");
                    }
                    break;

                    case "3":
                    System.out.println("\t> You run away from the " + e_enem + "!");
                    continue GAME;

                    default:
                    System.out.println("Invalid command");
                    continue;
                }
            }

            if (p_health <= 0) {
                System.out.println("You are a loser xd");
                break;
            }
            
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println(" # " + e_enem + " was defeated! # ");
            System.out.println("You have " + p_health + " HP left");
            if (e_enem == "Donald Trump :The man himself") {
                p_numHealthPots++;
                System.out.println(" # Donald dropped a health potion # ");
                System.out.println(" # You now have " + p_numHealthPots + " health potions! # ");
            }
            if(rand.nextInt(100) < p_healthPotDrop){
                p_numHealthPots ++;
                System.out.println(" # You found a potion! # ");
                System.out.println(" # You now have " + p_numHealthPots + " health potions! # ");
            }
        }
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}