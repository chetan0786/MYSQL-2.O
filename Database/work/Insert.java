package work;
import java.util.*;
import java.io.*;
public class Insert
{
   
        public boolean checkinsert(String words[]) throws Exception
        {
         File temp = new File(words[2]+".db");
          int count=0;
         boolean exists = temp.exists();
          if(!exists)
          {
            //   System.out.println("1");
              return false;
          }
          else{
              
              BufferedReader brTest = new BufferedReader(new FileReader(words[2]+".db"));
              String text = brTest .readLine();
              for(int i=0;i<text.length();i++)
              {
                  if(text.charAt(i)==',')
                  count++;
              }
              brTest.close();
              count--;
          }


            if(!words[1].equals("into"))
            {
                return false;
            }
            else if(!words[3].equals("values"))
            {
                return false;
            }
            else if(!words[4].equals("("))
            {
                return false;
            }
            else if(!words[words.length-1].equals(")"))
            {
                return false;
            }
            else if((words[words.length-2].equals(",")))
            {
                return false;
            }
            else if((words[5].equals(")")))
            {
                return false;
            }
            else
            {
                // System.out.println("2");
                for(int i=5;i<words.length-1;i++)
                {
                    if(i%2==0)
                    {
                        
                        if(!words[i].equals(","))
                        {
                            return false;
                        }
                        else 
                        {
                           
                            count--;
                        }
                    }
                    else{
                         
                        
                    }
                }
            }
            if(count!=0)
            return false;

            return true;
            
        }


         public void insertvalues(String words[]) throws Exception
         {
      
                 BufferedWriter out = new BufferedWriter(
                                new FileWriter(words[2]+".db",true)  //Set true for append mode5
                            ); 
                       out.newLine();   //Add new line
   
                  
                String s="|";
                for(int i=5;i<words.length;i=i+2)
                {
                    
                    if(!(words[i].equals("("))&&!(words[i].equals(")")))
                    {
                        
                   out.write(words[i]);
                    out.write(s);
                    }
                    
                }  
              
              
                out.close();
                 System.out.println("Inserted");
          }
         
        
      

}