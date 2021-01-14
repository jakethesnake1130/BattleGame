//This class handles all the getters and setters for the character, as well as initializing the stats that will be used
public class CharacterConstructor
{
   
   //Health, strength, and block will all determine the interplay between the two characters
   //These become more relevant in the RunBattle and CharacterSelect classes. For now they are just set to defaults.
   protected int health = 100;
   protected int strength = 0;
   protected int block = 0;
   
   //Getter for strength
   public int getStrength()
   {
      return this.strength;
   }
   
   //Setter for health
   //Only used in RunBattle, which passes the necessary parameter and adjusts health after each turn
   public void setHealth (int dmg)
   {
      this.health = health - dmg;
   }
   
   //Getter for health
   public int getHealth()
   {
      return this.health;
   }
   
   //Getter for block
   public int getBlock()
   {
      return this.block;
   }
   
   //Setter for strength and block
   //I set these for the same method for ease, since all the classes have fixed combinations of these stats
   //This will make more sense upon viewing the CharacterSelect class
   public void setUp(int s, int b)
   {
      this.strength = s;
      this.block = b;  
   }
   
   //I didn't add too much room for mutation since the stats are handled by the game, and the user doesn't have opportunities to tinker themselves
   
}