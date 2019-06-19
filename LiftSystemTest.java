package assignment.day2;


import java.util.*;

class User
{
	int userId;
	int destination;
	public User(int userId,int destination) {
		this.userId=userId;
		this.destination=destination;
	}
}

class FloorCompare implements Comparator<User>
{
	@Override
	public int compare(User o1, User o2) {
		if(o1.destination<=o2.destination)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

	
}
public class LiftSystemTest {
	
public static void main(String[] args) {
        
		System.out.println("Enter the number of users :");
        Scanner s= new Scanner(System.in);
        int number =s.nextInt();
        
        System.out.println("Enter the initial floor");
        int x =s.nextInt();
       
       // Array of users storing their user id and destination
       User[] users= new User[number];
       for(int i=0;i<number;i++)
       {
      System.out.println("Destination for user "+ (i+1) +" is :");
      int dest=s.nextInt();
      users[i]=new User(i+1, dest);
       } 
       
       List<User> a1 = new ArrayList<User>();// to store users' details who wants to go up
       List<User> a2 = new ArrayList<User>();// to store users' details who wants to go down
      
       for(int i=0;i<number; i++)
       {
	      if(users[i].destination>x)
	    	  a1.add(users[i]);
	      else
	    	  a2.add(users[i]);
       }
       
     // System.out.println(a1);
     // System.out.println(a2);
       FloorCompare dc=new FloorCompare();
      Collections.sort(a2,dc);
      Collections.sort(a1, dc);
      Collections.reverse(a1);
      
     // System.out.println(a1);
 // System.out.println(a2);
       
      int m=number/2;
  //System.out.println("each lift can contain only "+ m +" person");
      
  // manage the number of people in lift as both lift should contain equal number of people
  	if(a1.size()>m)
      {
   	  for(int i=0;i<(a1.size()-m);i++)
   	  {
   		  a2.add(a1.remove(a1.size()-1));
   	  }
   	  
      }
     else if(a2.size()>m)
      {
	   	for(int i=0;i<(a2.size()-m);i++)
	   	  {
	   		a1.add(a2.remove(a2.size()-1));
	   	  } 
      	 
      }
      
     // System.out.println(a1);
 // System.out.println(a2);
           
 System.out.println("order in which lift will operate \n");
  
  System.out.println("Lift A Operation ");
  
  User user1= a1.get(0);
  User user2= a1.get(m-1);
  if(user1.destination>x && user2.destination>x)
  {
	  Collections.sort(a1,dc); 
	  //System.out.println(a1);
	  
  }
  else if(user1.destination>x && user2.destination<x)
  {
	int diff1= Math.abs(user1.destination-x);
	int diff2= Math.abs(user2.destination-x);
	if(diff1>diff2)
	{
	Collections.reverse(a1);
	//System.out.println(a1);
	
	}
//	else if(diff1<diff2)
//	{
//	System.out.println(a1);
//	}
	else if(diff1==diff2)
	{
		int count1=0;
		int count2=0;
		for(int i=0;i<m;i++)
		{
		User user3= a1.get(i);
		if(user3.destination>x)
		count1++;
		else
		count2++;
		}
		if(count1<count2)
		{
		Collections.reverse(a1);
		//System.out.println(a1);
		}
//		else
//		System.out.println(a1);
	}
  }
//  else if(user1.Destination<x && user2.Destination<x)
//  {
//System.out.println(a1);
//  }
//  else
//  {
//  System.out.println(a1);
//  }
  for(int i=0;i<a1.size();i++)
	{
		System.out.println("user - "+a1.get(i).userId+", floor - "+a1.get(i).destination);
	}
  System.out.println("******************************************************");
  System.out.println("\nLift B Operation ");
  user1=a2.get(0);
  user2=a2.get(m-1);
  if(user1.destination>x && user2.destination>x )
  {
  Collections.sort(a2,dc); 
  //System.out.println(a2);
  }
  else if(user1.destination<x && user2.destination>x)
{
int diff1= Math.abs(user1.destination-x);
int diff2= Math.abs(user2.destination-x);
if(diff1>diff2)
{
Collections.reverse(a2);
//System.out.println(a2);
}
//else if(diff1<diff2)
//{
//System.out.println(a2);
//}
else if(diff1==diff2)
{
int count1=0;
int count2=0;
for(int i=0;i<m;i++)
{
User user3= a2.get(i);
if(user3.destination>x)
count1++;
else
count2++;
}
if(count1>count2)
{
Collections.reverse(a2);
//System.out.println(a2);
}
//else
//System.out.println(a2);
}
}
  else if(user1.destination<x && user2.destination<x)
  {
   Collections.reverse(a2);
//System.out.println(a2);
  }
//  else
//  {
// System.out.println(a2);
//  }   
  for(int i=0;i<a2.size();i++)
	{
		System.out.println("user - "+a2.get(i).userId+", floor - "+a2.get(i).destination);
	}
  s.close();
}

}
