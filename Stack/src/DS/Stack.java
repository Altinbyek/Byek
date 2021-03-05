package DS;

import java.util.Scanner;

public class Stack {

	 int[] a;
	   int top;
	   Stack()
	   {	
		a=new int[100];
		top=-1;
	   }
	  
	  void push(int x)
	  {	
		if(top==a.length-1)
		  System.out.println("overflow");
		else
		 a[++top]=x;
	   }
	   
	   int pop()
	   {
	     if(top==-1)
			{System.out.println("******* Стак хоосон байна. ********");
		     return -1;
			}
		 else
		   return(a[top--]);
		}
		
		void display()
		{
			for(int i=0;i<=top;i++)
				System.out.print(a[i]+" ");
			System.out.println();	
		}
		
		boolean isEmpty()
		{
			if(top==-1)
				return true;
			else 
				return false;
		}
		
		int peek()
		{
			if(top==-1)
				return -1;
			return (a[top]);
		}
		
		 
		public static void main(String args[])
		{
			
			Stack s=new Stack();
			Scanner in= new Scanner(System.in);
			s.push(10);
			s.push(9);
			s.push(8);
			s.push(7);
			s.push(6);
			s.push(5);
			s.push(4);
			s.push(3);
			 for(;;)
				{System.out.println("\n******** MENU *******");
				 System.out.println("\n1.PUSH");
				 System.out.println("\n2.POP");
				 System.out.println("\n3.PEEK");
				 System.out.println("\n4 IS EMPTY");
				 System.out.println("\n5.EXIT");
				 System.out.println("\n Та сонголтоо оруулна уу : ");
				 switch(in.nextInt())
					{
					 case 1: 
						 System.out.println("\n Нэмэх утга оруулна уу?? ");
						 s.push(in.nextInt());
						 break;
					 case 2: 
						System.out.println("\n Стакээс хасагдсан элемент. : "+ s.pop());
						 break;
					 
					case 3: 
						System.out.println("\n Оройн элемент : "+ s.peek());
						 break;
					 case 4: System.out.println("\n Стак хоосон байна уу?? : "+ s.isEmpty());
							 break;
					 case 5: System.exit(0);
							 break;
					 default: System.out.println("\n Буруу утга.");
							  break;
					}
				}

		}
}
