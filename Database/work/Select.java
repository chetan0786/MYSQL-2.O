package work;
import java.util.*;
import java.io.*;
import work.*;
public class Select
{
    static ArrayList<String> a1;
    static int add[]=new int[50];
    static int k=0;
    static int from=0;
        

        static ArrayList<ArrayList<String>>  getData(String words[],int value) throws Exception
         {
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
             return table;
         }











         public boolean checkselect(String words[]) throws Exception
         {

             a1 =new ArrayList<String>();
            
            FileReader fr = new FileReader(words[words.length-1]+".db");
           BufferedReader br = new BufferedReader(fr) ;

           String line=br.readLine();
           String temp=new String();
           
           for(int i=0;i<line.length();i++)
           {
               if(line.charAt(i)=='(')
               {
                   temp=temp.trim();
                   a1.add(temp);
               break;
               }
               else if(line.charAt(i)==',')
               {
                   
                   a1.add(temp);
                   temp="";
               }
               else
               temp+=line.charAt(i);

           }
            br.close();
            fr.close();
             from=0;
            for(int i=1;i<words.length;i++)
            {
                if(words[i].equals("from"))
                {
                    from=i;
                    break;
                }
            }
            
            File temp1 = new File(words[words.length-1]+".db");
            boolean e = temp1.exists();
          if(!e)
          {
              System.out.println("File not found");
              return false;
          }
           if(words.length<=from)
           return false;
            int count=0;
            for(int i=1;i<from;i++)
            {
                count++;
            }

            if(count<1)
            return false;

            else
            {
                if(count==1&&words[1].equals("*"))
                {
                    return true;
                }
                for(int i=1;i<from;i++)
                {
                    if(i%2==0)
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
                        
                        if(!a1.contains(words[i]))
                        {
                            return false;
                        }
                        else{
                            add[k++]=a1.indexOf(words[i]);
                        }
                    }
                }

            }


            return true;
           

         }
















        
         public void printselect(String words[]) throws Exception  
         {
                if(words[1].equals("*"))
                {
                     Print p = new Print();
                     p.printvalues(words,3);
                }
                else
                {
                    print(words);

                }

         }









         
        static void print(String words[])
        {
            modifiedPrint(a1,k);
            try
            {
                ArrayList<ArrayList<String>> table=getData(words,from+1);
                for(int i=0;i<table.size();i++)
                {
                    modifiedPrint(table.get(i),k);
                }

            }
            catch(Exception e)
            {

            }


            k=0;

        }





        static void modifiedPrint(ArrayList<String> a1,int k1)
        {
            for(int i=0;i<k1;i++)
            {
                System.out.print(a1.get(add[i])+" ");
            }
            System.out.println();

        }
            
}
