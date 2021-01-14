import java.util.*;

//This is the driver Class
//It essentially introduces the user, creates necessary objects, and calls other classes to do the heavy lifting
public class BattleRPG
{
      
   public static void main(String[] args)
   {
      
      Scanner in = new Scanner (System.in);
      String input = "";

      do
      {
         //These act as the two players, details can be found in the CharacterConstructor class
         CharacterConstructor pc = new CharacterConstructor();
         CharacterConstructor npc = new CharacterConstructor();
         
         //This will be used to mutate the above, details can be found in the CharacterSelect class
         CharacterSelect selector = new CharacterSelect();
         
         //This object will handle the battle itself, details can be found in the RunBattle class
         RunBattle battle = new RunBattle();
         
         //Quick introduction (more will be handled via the selector object)      
         System.out.println("Welcome to the Battle RPG game!");
         
         //characterSelect() handles the mutation of the player's character
         pc = selector.characterSelect(pc);
         
         //And opponentSelect() will handle mutating the computer's character
         npc = selector.opponentCharacter(npc);
         
         //Once the stats are loaded up and the objects are ready to interact, they are passed into the runBattle method
         //Here a champion will be determined!
         battle.runBattle(pc, npc);
         
         //And once that's all said and done, we prompt the user with the option to exit (or not)
         System.out.println("\n\nWill you fight again? Enter 'Q' to quit, or any other key for another round.");
         input = in.nextLine();
      
      //This loop will handle the exit options
      }while(!input.equalsIgnoreCase("Q"));
      
      System.out.println("Until next time!");
      //Until next time! Sorry it's late... I think I went a bit overboard but it was worth it!      
   }
      
}