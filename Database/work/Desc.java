package work;
import java.util.*;
import java.io.*;

public class Desc
{
    public boolean checkdesc(String words[]) throws Exception
        {
            if(words.length!=2)
            {
                return false;
            }
            File temp=new File(words[1]+".db");
            boolean exists = temp.exists();
          if(!exists)
          {
            //   System.out.println("1");
              return false;
          }
            
           
         
         
        
            return true;
        }
        public void printdesc(String words[])throws Exception
        {
           
            ArrayList<String> a1 =new ArrayList<String>();
            
             FileReader fr = new FileReader(words[1]+".db");
            BufferedReader br = new BufferedReader(fr) ;

            String line=br.readLine();
            String temp=new String();
        
            for(int i=0;i<line.length();i++)
            {
                if(line.charAt(i)=='(')
                {
                    temp+=" ";
                    a1.add(temp);
                break;
                }
                else if(line.charAt(i)==',')
                {
                    temp+=" ";
                    a1.add(temp);
                    temp="";
                }
                else
                temp+=line.charAt(i);

            }

            



            for(int i=0;i<a1.size();i++)
            {
               System.out.print(a1.get(i));
            }
            System.out.println();
             
            br.close();
            fr.close();
        }

         
            
}
