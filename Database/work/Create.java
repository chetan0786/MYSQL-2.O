package work;
import java.util.*;
import java.io.*;
public class Create
{
    public void createtable(String words[]) throws Exception
   {
      
          File temp = new File(words[2]+".db");
          
         boolean exists = temp.exists();
          if(!exists)
          {

                FileOutputStream out = new FileOutputStream(words[2]+".db"); 
                
                
                for(int i=3;i<words.length;i++)
                {
                    
                    if(!(words[i].equals("("))&&!(words[i].equals(")")))
                    {
                        System.out.println(words[i]);
                   out.write(words[i].getBytes());
                   
                    }
                    
                }  
              
               String  s="    (ALL THE COLUMN NAMES ARE SEPERATED BY ,)";
                out.write(s.getBytes());
                out.close();
                 System.out.println("Table created");
          }
          else{
              System.out.println("Table already Exists");
          }
        
      }
      
   
        public boolean checkcreate(String words[]) throws Exception
        {
            if(!(words[1].equals("table")))
            {
                return false;
            }
            else if(words[2].equals("table"))
            {
                return false;
            }
            else if(!(words[3].equals("(")))
            {
                return false;
            }
            else if(!(words[words.length-1].equals(")")))
            {
                // System.out+.println("here1");
                return false;
            }
            else if((words[words.length-2].equals(",")))
            {
                // System.out.println("here1");
                return false;
            }
            else if((words[4].equals(")")))
            {
                return false;
            }
            else
            {
                for(int i=4;i<words.length-1;i++)
                {
                    if(i%2==1)
                    {
                        if(!words[i].equals(","))
                        {
                            
                            return false;
                        }
                    }
                    else{
                            
                            if(!(Character.isLetter(words[i].charAt(0))))
                        {
                           
                            return false;
                        }
                        
                    }
                }
            }
            return true;
        }
}