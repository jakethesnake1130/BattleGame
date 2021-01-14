import java.util.*;

//This class deals with taking the CharacterConstructor objects from the Driver class and mutating them to reflect a specific character
//That is to say, CharacterConstructor objects are passed in, then used in the setUp() method of their class, and passed back out with different stats
public class CharacterSelect
{
   
   //Initialize them class-wide for broad scope
   Scanner in = new Scanner (System.in);
   Random rng = new Random();
   
   //This method is where the player's object is passed into for mutation. It offers the user options.
   public CharacterConstructor characterSelect(CharacterConstructor pc)
   {
      
      //used for the do-while loop below            
      boolean error = false;
      
      //Storage for the parameter, also used for the return
      CharacterConstructor playerCharacter = pc;
      
      do
      {
         
         //try-catch statement to handle errors in input
         try
         {
            
            //Used for the do-while loop in conjunction with the try-catch statement
            error = false;
            
            String input = "";
            
            char select = ' ';
            
            //Three options presented to the user
            System.out.println("Choose between (T)hief, a (W)arrior, or a (B)erserker!");
            System.out.println("Select a class to get more information");
            
            //Input is truncated to narrow the margin for error (only the first character is taken)
            input = in.nextLine();
            select = input.charAt(0);
            
            //switch statement handles the character selection            
            switch(select)
            {
               //Thief choice and description
               case 'T':
               case 't':
                  System.out.println("The thief is excellent at dodging, and can often escape the opponents attacks without any damage");
                  System.out.println("However, he has to sacrifice strength in order to achieve such speed.");
                  
                  //Offer the user further review before making the final decision
                  System.out.println("Would you like to select the thief as your character? (Y/N)");
                                    
                  input = in.nextLine();
                  
                  select = input.charAt(0);
                  
                  //This will mutate the 'pc' object in the Driver class to reflect the thief's stats                  
                  if(select == 'y' || select == 'Y')
                  {
                     //See the CharacterConstructor class to see where these parameters go and what this setter method does.
                     playerCharacter.setUp(20, 40);
                     System.out.println("You have chosen the thief!");
                  }
                  //If the user decides not to go with this class, error is toggled to true which restarts the do-while loop
                  else
                  {
                     error = true;
                  }
                  break;
                
               //Behaves the same as above, but with respect to the Warrior option   
               case 'W':
               case 'w':               
                  System.out.println("The warrior is a well-rounded character, trained in attack and defense in equal measure");
                  System.out.println("Would you like to select the warrior as your character? (Y/N)");
                                                      
                  input = in.nextLine();
                  
                  select = input.charAt(0);
                                                      
                  if(select == 'y' || select == 'Y')
                  {
                     playerCharacter.setUp(35, 30);
                     System.out.println("You have chosen the warrior!");
                  }
                  else
                  {
                     error = true;
                  }
                  break;
               
               //Behaves the same as above, but with respect to the Berserker option   
               case 'B':
               case 'b':               
                  System.out.println("The berserker is a bloodthirsty savage who can deal massive damage to his opponents");
                  System.out.println("The berserker is so blind with rage that he rarely thinks to protect himself");
                  System.out.println("Would you like to select the berserker as your character? (Y/N)");
                  
                  
                  input = in.nextLine();
                  
                  select = input.charAt(0);
                  
                  if(select == 'y' || select == 'Y')
                  {
                     playerCharacter.setUp(45, 20);
                     System.out.println("You have chosen the berserker!");
                  }
                  else
                  {
                     error = true;
                  }
                  break;
               
               //If something other than the three options is entered, this default message is printed and the do-while loop goes back to the beginning   
               default:
                  System.out.println("Sorry, I didn't understand that input. Review the options and try again.");
                  error = true;

            }
            
         }
         //If a non-char is entered, this catch will prevent an error being thrown and a program crash.
         catch(InputMismatchException e)
         {
            System.out.println("Sorry, I didn't understand that input. Review the options and try again.");
            error = true;
         }
            
      }while(error == true);
      
      //At the end of it all, the playerCharacter object is returned to the Driver class, where it will be used to mutate the existing 'pc' object
      return playerCharacter;
        
   }
   
   //This method handles the mutation of the computer's character. The computer's character is not chosen, but randomly assigned.
   public CharacterConstructor opponentCharacter(CharacterConstructor computerCharacter)
   {
      
      //This will store the random number which will be used for the decision.   
      int compGen = 0;

      
      System.out.println("Now to reveal your opponent....");
      
      //A random number 0-2 is generated and stored in compGen     
      compGen = rng.nextInt(3);     
      
      //And a switch statement is used to convert that random int into a character
      //Other than using rng instead of user input, this switch statment works essentially the same way as the one found in characterSelect()     
      switch(compGen)
      {
         case 0:
            computerCharacter.setUp(20, 45);
            System.out.println("Watch your back. Your opponent is a thief!");
            break;
            
         case 1:
            computerCharacter.setUp(30, 30);
            System.out.println("Stay on your guard. Your opponent is a warrior!");
            break;
            
         case 2:
            computerCharacter.setUp(45, 20);
            System.out.println("Keep light on your feet. Your opponent is a berserker!");
            break;
            
      }
      
      //After assigning a character type and setting the stats accordingly, computerCharacter is returned to the Driver class where it will be used to mutate the existing 'npc' object.
      return computerCharacter;
      
   }


}