public class Prime_Number {
 
 public boolean prime_check(int num) {
  int remainder;
  boolean isPrime=true;
  int numberToCheck=num; // Enter the numberToCheckber you want to check for prime
        
  //Loop to check whether the numberToCheckber is divisible any numberToCheckber other than 1 and itself
  for(int i=2;i<=numberToCheck/2;i++)
  {
   //numberToCheckber is divided by itself
            remainder=numberToCheck%i;
            
       //if remainder is 0 than numberToCheckber is not prime and break loop. Else continue the loop
     if(remainder==0)
     {
        isPrime=false;
        break;
     }
  }
  // Check value true or false, if isprime is true then numberToCheckber is prime otherwise not prime
  if(isPrime)
     return true;
	  else
     return false;
    }
  }