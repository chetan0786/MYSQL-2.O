package work;
import java.util.*;
import java.io.*;
public class Delete
{
   
        public boolean checkdelete(String words[]) throws Exception
        {
            if(words.length!=2)
            {
                return false;
            }
         File temp = new File(words[1]+".db");
          
         boolean exists = temp.exists();
          if(!exists)
          {
            //   System.out.println("1");
              return false;
          }
        return true;

        }
        public void deletetable(String words[]) throws Exception
         {
                File file = new File(words[1]+".db"); 
          
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
         }
}