package Queue;

public class FirstLastListQueue {  
    private  FirstLastList fll = new FirstLastList();  
  
    public void push(Object obj){  
        fll.insertLast(obj);  
    }  
      
    public Object pop() throws Exception{  
        return fll.deleteFirst();  
    }  
      
    public void display(){  
        fll.display();  
    }  
      
    public static void main(String[] args) throws Exception{  
        FirstLastListQueue fllq = new FirstLastListQueue();  
        fllq.push(1);  
        fllq.push(2);  
        fllq.push(3);  
        fllq.display();  
        System.out.println(fllq.pop());  
        fllq.display();  
        fllq.push(4);  
        fllq.display();  
    }  
}  
