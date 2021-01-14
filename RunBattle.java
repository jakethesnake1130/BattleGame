import java.util.*;


//After the 'pc' and 'npc' objects are assigned stats, they are passed here to simulate battle.
public class RunBattle
{
   
   //This method does all the heavy lifting in this class. As you can see, it takes two CharacterConstructor parameters; one for each character from the Driver class
   public void runBattle(CharacterConstructor player, CharacterConstructor opponent)
   {
      
      //This is used for the loop. I was going to make a return statement, but ultimately found it unneccessary, and so you might call this a vestigial variable.
      String winner = "";
      
      //This Random will be heavily relied upon in this class.
      Random rng = new Random();
      
      //This scanner won't be used for any inputs, but I found it useful for managing the flow of print statements
      Scanner in = new Scanner(System.in);
      
      //These are the primary variables used for determining the course of battles. They are derivative of the stats assigned in the CharacterSelect class.
      int damage = 0;
      int attack = 0;
      int defense = 0;
      
      //Beginning statement and health display
      System.out.println("Now it is time to battle.");
      System.out.println("Your health: " + player.getHealth());
      System.out.println("Your opponent's health: " + opponent.getHealth());
      System.out.println("Your turn is first, prepare to strike!");
            
      do
      {
         //I found this out by accident, but with a clear buffer and an 'in.nextLine()' statement, the program will suspend until any input is received (including pressing enter)
         //This class has a lot of output, so I thought this was a good way of helping the user stay in the driver's seat
         //You'll find this at several points in the program
         System.out.println("Press ENTER to proceed with the duel");
         in.nextLine();
         
         
         //As stated above, the player's attack goes first. What's below this determines damage dealt to the computer's character.
         
         
         //Attack is a random number between strength and strength - 10
         //In other words, if strength is 20, attack will be a random int between 10 and 20.
         attack = rng.nextInt(10) + (player.getStrength() - 10);
         
         //defense is a random number between block and block * 1/2
         //In other words, if block is 30, defense will be a random int between 15-30
         //This differs from attack in that the range varies among values; the higher the stat, the higher the range of possibilities
         defense = rng.nextInt(opponent.getBlock() - (opponent.getBlock() / 2)) + (opponent.getBlock() - (opponent.getBlock() / 2));
         
         //damage is determined by attack minus defense
         damage = attack - defense;         
         
         //if damage is equal to or less than zero, the computer's health will not be affected
         //A print statement notifies the user of this fact
         if(damage <= 0)
         {
            System.out.println("Your opponent is too crafty! You failed to inflict any damage!");
         }
         //If damage is greater than zero, the int is subtracted from the computer character's health using the setter method found in CharacterConstructor
         else
         {
            System.out.println("You dealt a blow, staggering your opponent and dealing " + damage + " damage!");
            opponent.setHealth(damage);
         }
         
         //Below this is the computer's attack. It works essentially the same as the above, but inverted so the player's character is what is dealt damage (with print statements reflecting this state of affairs)
         System.out.println("Now get ready, your opponent is about to attack!");
         System.out.println("Press ENTER to continue");
         
         in.nextLine();
         
         attack = rng.nextInt(10) + (opponent.getStrength() - 10);
         defense = rng.nextInt(player.getBlock() - (player.getBlock() / 2)) + (player.getBlock() - (player.getBlock() / 2));
         
         damage = attack - defense;
         
         if(damage <= 0)
         {
            System.out.println("Well done! You narrowly escaped damage that round.");
         }
         else
         {
            System.out.println("You are hit, and you suffer " + damage + " damage!");
            player.setHealth(damage);            
         }
         
         
         //This block of if statements handles the end of the battle
         //This first one fires if both characters' health falls to or below zero, and declares a draw
         if(player.getHealth() <= 0 && opponent.getHealth() <= 0)
         {
            System.out.println("\n\nAs you strike the final blow you feel a sharp pain. Looking down with horror, you see a fatal wound has been dealt to yourself!");
            System.out.println("The battle is a draw, there are no victors today!");
            
            //Setting the winner String to a value will discontinue the loop, bringing the program back to the loop found in the Driver class prompting exit/repeat
            winner = "draw";
         }
         //This is if the player "dies" while the opponent still has health
         else if(player.getHealth() <= 0)
         {
            System.out.println("\n\nYou fall off your feet, looking up at the beat that has defeated you one last time. The battle is over!");
            
            //Setting the winner String to a value will discontinue the loop, bringing the program back to the loop found in the Driver class prompting exit/repeat
            winner = "computer";
         }
         //This is if the opponent "dies" while the player still has health
         else if(opponent.getHealth() <= 0)
         {
            System.out.println("\n\nYour opponent stumbles, and falls. The mighty fighter has been vanquished, and you are victorious!");
            
            //Setting the winner String to a value will discontinue the loop, bringing the program back to the loop found in the Driver class prompting exit/repeat
            winner = "player";
         }
         //And finally, this will fire if both characters live to fight. winner remains at its "" value, the health stats are displayed, and the loop goes back around.
         else
         {
            System.out.println("Your health: " + player.getHealth());
            System.out.println("Your opponent's health: " + opponent.getHealth());            
            System.out.println("The battle carries on. Get ready, you see an opening to strike!");
         }
      
      //When winner is assigned a value, the loop is exited and the program returns to the Driver class.
      }while(winner.equals(""));

   }

}