/*
Q6
Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields, and methods unless mentioned.
Specifications
class definitions:
 class Credentials:
  data members:
         userName: String
         password: String
  Credentials(String userName, String password): constructor with public visibility

 class Implementation:
   method definitions:
      passwordValidator(Credentials details) throws Exception
          return type: String
          visibility: public   
      signUp(Credentials details)
           return type: String
           visibility: public
   
 class MissingCharacterException:
        method definitions:
          MissingCharacterException(String str)
          visibility: public
    
 class LengthMismatchException:
        method definitions:
          LengthMismatchException(String str)
          visibility: public           
Task
Class Credentials
- define the String variable userName.
- define the String variable password.
-Define a parameterized constructor as specified above.
Class Implementation
Implement the below methods for this class:
-String passwordValidator(Credentials details):
•	Write a code to validate the password.
•	If the password doesn't contain at least one special character, one Upper case alphabet, one lower case alphabet, and one digit then throw a MissingCharacterException with a message "password must contain at least one special character, at least one upper case alphabet, at least one lower case alphabet, and at least one digit".
•	If the password length is not between 8 to 40(inclusive) then throw a LengthMismatchException with a message "length of the password is not between 8 to 40".
•	If no exception found then return a message "valid password".
-String signup(Credentials details):
•	Write a code to sign up using the given details.
•	Use try-catch to validate the password using passwordValidator method, If the password is valid then return "signup successfully".
•	If MissingCharacterException or LengthMismatchException found then return "invalid password" in the catch block.
•	If any other exception found then return "other exception" in the catch block.
Class MissingCharacterException
•	define custom exception class MissingCharacterException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Class LengthMismatchException
•	define custom exception class LengthMismatchException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Sample Input
Implementation obj = new Implementation();
-------------------------------------------------------
obj.passwordValidator(new Credentials("Steve", "Akjsdhhj@1"));
obj.signUp(new Credentials("Bob", "jsdhJS12*&$1"));
Sample Output
valid password
signup successfully

*/
import java.util.regex.*;

public class Credentials {
    String userName; 
    String password;

    public Credentials(String userName, String password)
    {
        this.userName=userName;
        this.password=password;
    }

    public String getUsername(){
        return userName;
    }
    public String getPassword(){
        return password;
    }

    public static void main(String[] args) throws Exception {
        Implementation1 obj = new Implementation1();
        try{
        String p=obj.passwordValidator(new Credentials("Steve", "Akjsdhhj@1"));
        String s=obj.signUp(new Credentials("Bob", "jsdhJS12*&$1"));
        System.out.println(p);
        System.out.println(s);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

class Implementation1{

    public String passwordValidator(Credentials c) throws Exception {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(c.password);

        if(c.password.length()< 8 || c.password.length()> 40)
        {
            throw new LengthMismatchException("length of the password is not between 8 to 40");
        }
        else if(!m.matches())
        {
            throw new MissingCharacterException("password must contain at least one special character, at least one upper case alphabet, at least one lower case alphabet, and at least one digit");
        }
        else
        return "valid password";
    }

    public String signUp(Credentials c)
    {
        try{
            String s=passwordValidator(c);
            if(s.equals("valid password"))
            {
                return "signup successfully";
            }
        }
        catch(MissingCharacterException e){
            return "invalid password";
        }
        catch(LengthMismatchException e){
            return "invalid password";
        }
        catch(Exception e)
        {
            return "other exception";
        }
        return null;
    }
}

class MissingCharacterException extends Exception{
    public MissingCharacterException(String str)
    {
        super(str);
    }
}

class LengthMismatchException extends Exception{
    public LengthMismatchException(String str){
        super(str);
    }
}