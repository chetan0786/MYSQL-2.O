package work;
import java.util.*;
import java.io.*;
public class Load
{
   
        public boolean checkload(String words[]) throws Exception
        {
         File temp = new File(words[1]+".db");
          
         boolean exists = temp.exists();
          if(!exists)
          {
            //   System.out.println("1");
              return false;
          }

           temp = new File(words[3]+".db");
           
          exists = temp.exists();
            if(exists)
            {
                return false;
            }
            if(!words[2].equals("as"))
            {
                return false;
            }
            else if(words.length!=4)
            {
                return false;
            }
           

            return true;
            
        }


         public void loadtable(String words[]) throws Exception
         {
                 FileInputStream instream = null;
	             FileOutputStream outstream = null;

             File infile =new File(words[1]+".db");
    	    File outfile =new File(words[3]+".db");
 
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);

              byte[] buffer = new byte[1024];
 
    	    int length;
    	   
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	   
    	    instream.close();
    	    outstream.close();

    	    System.out.println("LOADED");
          }


}