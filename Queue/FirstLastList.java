/**
 * 
 */
/**
 * @author wyong
 *
 */
package Queue;
public class FirstLastList {  
    private class Data{  
        private Object obj;  
        private Data next = null;  
          
        Data(Object obj){  
            this.obj = obj;  
        }  
    }  
      
    private Data first = null;  
    private Data last = null;  
      
    public void insertLast(Object obj){  
        Data data = new Data(obj);  
        if(first == null){  
            first = data;  
        }else{  
            last.next = data;  
        }  
        last = data;  
    }  
      
    public Object deleteFirst() throws Exception{  
        if(first == null)  
            throw new Exception("empty");  
        Data temp = first;  
        if(first.next == null)  
            last = null;  
        first = first.next;  
        return temp.obj;  
    }  
              
    public void display(){  
        if(first == null)  
            System.out.println("empty");  
        System.out.print("first -> last : | ");  
        Data cur = first;  
        while(cur != null){  
            System.out.print(cur.obj.toString() + " | ");  
            cur = cur.next;  
        }  
        System.out.print("\n");  
    }  
}  