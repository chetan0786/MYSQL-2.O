package work;
import java.util.*;
import java.io.*;
public class History
{
   
        public boolean checkhistory(String words[]) throws Exception
        {
            if(words.length!=1)
            return false;

            return true;
            
        }


         public void printhistory(String words[]) throws Exception
         {
             ArrayList<String> his=new ArrayList<String>();

             FileReader fr = new FileReader("history.txt");
            BufferedReader br = new BufferedReader(fr) ;

            String line=br.readLine();
           

             while ((line = br.readLine()) != null) {
                 his.add(line);
         }
         br.close();
         fr.close();

         for(int i=his.size()-1;i>=0;i--)
         {
             System.out.println(his.get(i));
            
         }
         
        }
}