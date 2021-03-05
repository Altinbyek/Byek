package lab2;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.Scanner;

public class mainStack<T> implements Stack<T>{
	
	 private int maxSize;
	    private T[] array;
	    private int top;

	    public mainStack(Class<? extends T> cls, int maxSize) {
	    	this.maxSize = maxSize;
//	        @SuppressWarnings("unchecked")
	        this.array = (T[]) Array.newInstance(cls, maxSize);
	        this.top = -1;;
	    }

	    private T[] resizeArray() {
	        /**
	         * create a new array double the size of the old, copy the old elements then return the new array */
	        int newSize = maxSize * 2;
	        T[] newArray = (T[]) Array.newInstance(mainStack.class, newSize);
	        for(int i = 0; i < maxSize; i++) {
	            newArray[i] = this.array[i];
	        }
	        return newArray;
	    }

	    public boolean isEmpty() {
	        return top == -1;
	    }

	    public boolean isFull() {
	        return top == maxSize-1;
	    }

	    public void push(T element) {
	        if(!this.isFull()) {
	        	++top;
	            array[top]= element;
	        }
	        else {
	            this.array = resizeArray();
	            array[++top] = element;
	        }
	    }

	    public T pop() {
	        if(!this.isEmpty())
	            return array[top--];
	        else {
	            throw new EmptyStackException();
	        }
	    }

	    public T peek() {
	    	return array[top];
	    }
	    public int maxSize(){
			return this.top+1;
		}
	    public Object[] toArray() {
			Object[] newArray = new Object[this.maxSize()];
			int i = this.maxSize() - 1;
			while(!isEmpty()) {
				newArray[i] = this.pop();
				i--;
			}

			for(int j = 0; j < newArray.length; j ++) {
				this.push((T)newArray[j]);
			}
			return newArray;
			}
	    public String elementHevleh() {
	    	Object[] array = this.toArray();
			StringBuffer s = new StringBuffer();
			s.append("[======Stack from top======]\n");
			for(int i = array.length-1; i>=0; i--) {
				s.append("\t"+array[i].toString() + "\n");
			}
			return new String(s);
	    }
	    public static void main(String args[]) {
	    	
	    	mainStack<String> mS = new mainStack<String>(String.class,10);
	    	Scanner sc = new Scanner(System.in);
	    	mS.push("Altosh");
	    	for(;;) {
	    		System.out.println("\n******** MENU *******");
				 System.out.println("\n1.PUSH");
				 System.out.println("\n2.POP");
				 System.out.println("\n3.PEEK");
				 System.out.println("\n4 IS EMPTY");
				 System.out.println("\n5 IS FULL");
				 System.out.println("\n6 element hevleh");
				 System.out.println("\n7 toArray");
				 System.out.println("\n8.EXIT");
				 System.out.println("\n Та сонголтоо оруулна уу : ");
				 switch(sc.nextInt()) {
				 
				 case 1:  System.out.println("\n Нэмэх утга оруулна уу?? ");
				 mS.push(sc.next());
				 break;
				 case 2: 
						System.out.println("\n Стакээс хасагдсан элемент. : "+ mS.pop());
						 break;
				 case 3: 
						System.out.println("\n Оройн элемент : "+ mS.peek());
						 break;
				 case 4: System.out.println("\n Стак хоосон байна уу?? : "+ mS.isEmpty());
				 break;
				 case 5: System.out.println("\n Стак дүүрсэн байна уу?? : "+ mS.isFull());
				 break;
				 case 6:System.out.println(mS.elementHevleh()); break;
				 case 7: {Object[] array = mS.toArray(); System.out.print("Array >> "); for(Object i : array) {System.out.print(i + " ");} break;}
				 case 8: System.exit(0);
				 break;
				 default: System.out.println("\n Буруу утга.");
				  break;
				 }
	    	}
	    }

}
