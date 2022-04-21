/*
Q8
Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields and methods are public unless mentioned otherwise.
Specifications

class definitions:
 class Product: 
  Data members:
       name: String
       price: double
       coupon: String 
    Define a parameterized constructor for all the data member.

  class Validator:
      validateCoupon(Product p)throws Exception
        return type: String
        visibility: public  
  
      netPrice(Product p) 
        type: double 
        visibility: public  
   
  class InvalidCouponException:
   method definitions:
    InvalidCouponException(String msg)
      visibility: public 

Task
Class Product
- define the String variable name
- define the double variable price
- define the String variable coupon
-define a parameterized constructor for all the data members.

Class Validator
Implement the below methods for this class:
-String validateCoupon(Product p):
•	throw an InvalidCouponException "Invalid Coupon" if the coupon is not valid. The coupon is valid if its name and discount value are separated with '-' and the discount value should be between 10-25(inclusive).
Example:
name = "IPhone" ; valid coupons are "IPhone-10", "IPhone-20", "IPhone-18" etc.
•	return "Valid Coupon" if no exception found.

-double netPrice(Product p):
•	netPrice = totalPrice-discountPrice.
•	return netPrice if Coupon is valid else return totalPrice.

Class InvalidCouponException
•	define custom exception class InvalidCouponException by extending the Exception class.
•	define a parameterised constructor with a String argument to pass the message to the super class.

Sample Input
Product obj = new Product("IPhone",25000,"IPhone-10");
Validator val = new Validator();
String valCop = val.validCoupon(obj);
double price = val.netPrice(obj);

Sample Output
valCop = "Valid Coupon"
price = 22500.0
*/

class InvalidCouponException extends Exception{
    public InvalidCouponException(String str)
    {
        super(str);
    }

}

class Validator {
    public Validator(Product p) {
    }

    public String validateCoupon (Product p) throws InvalidCouponException
	{
		String[] coupStrings = p.coupon.split("-");
		if(coupStrings.length>1)
		{
			int discount=Integer.parseInt(coupStrings[1]);
			if(discount>=10 && discount<=25)
			{
				return "Valid Coupon";
			}
			else
			{
				throw new InvalidCouponException("Invalid coupon");
			}
		}
		else
		{
			throw new InvalidCouponException("Invalid coupon");
		}
    }

    public double netPrice(Product p)
	{
		double netprice;
		try{
            String validString=validateCoupon(p);
		if(validString.equals("Valid Coupon"))
		{
			String[] coupStrings = p.coupon.split("-");
			int discount=Integer.parseInt(coupStrings[1]);
			netprice = p.price-(p.price*discount*0.01);
			return netprice;
		}
    }
        catch(Exception e)
        {
            
        }
        return p.price;
	}

}

public class Product {

    String name;
    double price;
    String coupon;
    public Product(String name,double price,String coupon)
    {
        this.name=name;
        this.price=price;
        this.coupon=coupon;
    }

    public String getName()
    {
        return this.name;
    }

    
    public double getPrice()
    {
        return this.price;
    }

    
    public String getCoupon()
    {
        return this.coupon;
    }

    public Product() {
    }

    public static void main(String[] args) throws Exception
    {
        Product p = new Product("IPhone",25000,"IPhone-10");
        Validator v = new Validator(p);
        try{
        String pdt=v.validateCoupon(p);
        double price=v.netPrice(p);
        System.out.println("valCop = \""+pdt+"\"");
        System.out.println("price = "+price);
        }
        catch(InvalidCouponException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}

