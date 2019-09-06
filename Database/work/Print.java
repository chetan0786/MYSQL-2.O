package work;
import java.util.*;
import java.io.*;

public class Print
{
    public boolean checkprint(String words[]) throws Exception
        {
            File temp;
            if(words.length==2||words.length==5)
            {
                temp = new File(words[1]+".db");
            }
           else{
               return false;
           }
         
         boolean exists = temp.exists();
          if(!exists)
          {
            //   System.out.println("1");
              return false;
          }
          else if(words.length==5)
             {
                 if(!words[2].equals("(")||!words[3].equals("sort")||!words[4].equals(")"))
                 return false;
          }
            return true;
        }
        static void printheading(String words[],int value)throws Exception
        {
           
            ArrayList<String> a1 =new ArrayList<String>();
            
             FileReader fr = new FileReader(words[value]+".db");
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
             
            br.close();
            fr.close();
        }

         public void printvalues(String words[],int value) throws Exception  
         {
             printheading(words,value);

             ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
             ArrayList <String> a1 = new ArrayList<String>();
            FileReader fr = new FileReader(words[value]+".db");
            BufferedReader br = new BufferedReader(fr) ;

            String line=br.readLine();
            String temp=new String();

             while ((line = br.readLine()) != null) {

                     a1 = new ArrayList<String>();
             for(int i=0;i<line.length();i++)
            {
                
                
                 if(line.charAt(i)=='|')
                {
                    temp+=" ";
                    a1.add(temp);
                    temp="";
                }
                else
                temp+=line.charAt(i);

            }
                table.add(a1);

             }
            if(words.length==5)
            {
                Collections.sort(table, new Comparator<ArrayList<String>>() {    
        
               public int compare(ArrayList<String> o1, ArrayList<String> o2) {
              return o1.get(0).compareTo(o2.get(0));
                 }               
            });
            }
            printtable(table);

        
            
         }  

         static void printtable(ArrayList<ArrayList<String>> table)
         {

               System.out.println();
             for(int i=0;i<table.size();i++)
             {
                 for(int j=0;j<table.get(i).size();j++)
                 {
                     System.out.print(table.get(i).get(j));
                 }
                 System.out.println();
             }
         }

            
}
