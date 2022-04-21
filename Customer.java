
/*  Q9
Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields and methods are public unless mentioned otherwise.
Specifications

class definitions:
 class Customer:
  Data members:
       name: String
       mobileNo: String
       cId: String 
   Define a parameterized constructor for all the data members.

  class Validator:
      validateCId(Customer c) throws Exception
        return type: String  
        visibility: public   
 
      validateMobileNo(Customer c) throws Exception
        return type: String 
        visibility: public  
   
  class InvalidCIdException:
   method definitions:
    InvalidCIdException(String str)
      visibility: public   

  class InvalidMobileNoException:
   method definitions:
    InvalidMobileNoException(String str)
      visibility: public   

Task
Class Customer
- define the String variable name
- define the String variable mobileNo
- define the String variable cId
-define a parameterized constructor for all the data members.

Class Validator
Implement the below methods for this class:
-String validateCId(Customer c):
•	throw an InvalidCIdException "Invalid CId" if CId is not valid. cId is valid if it starts with first 4 character of mobileNo and end with last 2 character of name.

Example:
name = "Steve", mobileNo = "9898111111" then valid cId = "9898ve".
•	return "Valid CId" if no exception found.
-String validateMobileNo(Customer c):
•	throw an InvalidMobileNoException "Invalid MobileNo" if mobileNo is not valid. mobileNo is valid if it has 10 digits and starts with [9,8,7,6] only.
•	return "Valid MobileNo" if no exception found.

Class InvalidCIdException
•	define a custom exception class InvalidCIdException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.

Class InvalidMobileNoException
•	define a custom exception class InvalidMobileNoException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.

Sample Input
Customer obj = new Customer("Steve","9898111111","9898ve");
Validator val = new Validator();
String CID = val.validCId(obj);
String mob = val.validMobileNo(obj);

Sample Output
CID = "Valid CId"
mob = "Valid MobileNo"
*/

class InvalidCIdException extends Exception{
    public InvalidCIdException(String str)
    {
        super(str);
    }
}

class InvalidMobileNoException extends Exception{
    public InvalidMobileNoException(String str)
    {
        super(str);
    }
}

class Validator1{
    Validator1(){
    }

    public String validCId(Customer obj) throws InvalidCIdException
    {
        String cId=obj.getCId();
        String name=obj.getName();
        if(cId.substring(cId.length()-2,cId.length()).equals(name.substring(name.length()-2, name.length())) 
        && cId.length()==6 && obj.getMobileNo().substring(0,4).equals(cId.substring(0,4)))
        {
            return "Valid CId";
        }
        else
        throw new InvalidCIdException("Invalid CId");
    }

    public String validMobileNo(Customer obj) throws Exception
    {
        
        String mobno=obj.getMobileNo();
        if(obj.getMobileNo().length()==10 && (mobno.charAt(0)=='9' || mobno.charAt(0)=='8' || 
        mobno.charAt(0)=='7' || mobno.charAt(0)=='6'))
        {
        return "Valid MobileNo";
        }
    
        else 
        throw new InvalidMobileNoException("Invalid MobileNo");
        
    }
}

public class Customer {
    String name;
    String mobileNo;
    String cId;  
    public Customer(String name, String mobileNo, String cId)
    {
        this.name=name;
        this.mobileNo=mobileNo;
        this.cId=cId;
    }

    public String getName(){
        return this.name;
    }
    
    public String getMobileNo(){
        return this.mobileNo;
    }
    
    public String getCId(){
        return this.cId;
    }

    public static void main(String[] args) throws Exception{
        Customer obj = new Customer("Steve","9898111111","9898ve");
        Validator1 val = new Validator1();
        try{
        String CID = val.validCId(obj);
        System.out.println("CID = \""+CID+"\"");
        }
        catch(InvalidCIdException e){
            System.out.println(e.getMessage());
        }

        try{
            String mob = val.validMobileNo(obj);
            System.out.println("mob = \""+mob+"\"");
        } 
        catch(InvalidMobileNoException e){
            System.out.println(e.getMessage());
        } 
    }
}


