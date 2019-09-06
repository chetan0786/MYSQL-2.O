import java.util.*;
import java.io.*;
import work.*;
class Database
{
   

   
    static String makequery (String query)
    {
         query=query.toLowerCase();
         query= query.replaceAll("( )+", " ");
        for(int i=0;i<query.length();i++)
        {
            if(query.charAt(i)=='('||query.charAt(i)==')'||query.charAt(i)==',')
            {
                query=query.substring(0,i)+" "+query.charAt(i)+" "+query.substring(i+1,query.length());
                i=i+1;
                
            }
        }
         query= query.replaceAll("( )+", " ");
        return query;
        
    }

      public static void main(String args[])
    {
       
        Scanner sc=new Scanner(System.in);
        ArrayList <String> funcs=new ArrayList<String>();
        funcs.add("create");
        funcs.add("select");
        funcs.add("insert");
        funcs.add("update");
        funcs.add("print");
        funcs.add("delete");
        funcs.add("desc");
        funcs.add("load");
        funcs.add("history");
        funcs.add("exit");
       
        while(true)
        {
        String query=sc.nextLine();
            try{
                BufferedWriter out = new BufferedWriter( 
                    new FileWriter("history.txt", true));
               out.write(query);
               
               out.append(System.lineSeparator());

               out.close();
            }
            catch(Exception e){}
           
        query=makequery(query);
            
        String words[]=query.split(" ");
        
        if(funcs.contains(words[0]))
        {
          
            switch (words[0]) {
                case "create":
                    try
                    {
                        Create c=new Create();
                        boolean res= c.checkcreate(words);
                        if(res)
                        {
                            c.createtable(words);
                        }
                        else{
                            System.out.println("INVALID");
                            
                        }
                       
                    }
                    catch(Exception e)
                    {
                        
                    }
                    break;

                case "insert":
                        try
                        {
                            Insert i = new Insert();
                            boolean res = i.checkinsert(words);
                            if(res)
                            {
                                i.insertvalues(words);
                            }
                            else
                            {
                                System.out.println("INVALID");
                                
                            }
                        }
                        catch(Exception e)
                         {
                        
                        }
                        break;


                        case "print":
                        try
                        {
                            Print p = new Print();
                            boolean res = p.checkprint(words);
                            if(res)
                            {
                                p.printvalues(words,1);
                            }
                            else
                            {
                                System.out.println("INVALID");
                             
                            }
                        }
                        catch(Exception e)
                        {
                        
                        }
                        break;
                case "load":
                        try
                        {
                            Load l = new Load();
                            boolean res = l.checkload(words);
                            if(res)
                            {
                                l.loadtable(words);
                            }
                            else
                            {
                                System.out.println("INVALID");
                            
                            }
                        }
                        catch(Exception e)
                        {
                        
                        }
                        break;
                case "select":
                try
                {
                    Select s = new Select();
                    boolean res = s.checkselect(words);
                    if(res)
                    {
                         s.printselect(words);
                        
                    }
                    else
                    {
                        System.out.println("INVALID");
                    
                    }
                }
                catch(Exception e)
                {
                        
                        System.out.println(e);
                }
                break;

                case "delete":
                try
                {
                    Delete d = new Delete();
                    boolean res = d.checkdelete(words);
                    if(res)
                    {
                        d.deletetable(words);
                    }
                    else
                    {
                        System.out.println("INVALID");
                    
                    }
                }
                catch(Exception e)
                {
                
                }
                break;
                case "desc":
                try
                {
                    Desc d = new Desc();
                    boolean res = d.checkdesc(words);
                    if(res)
                    {
                        d.printdesc(words);
                    }
                    else
                    {
                        System.out.println("INVALID");
                    
                    }
                }
                catch(Exception e)
                {
                
                }
                break;

                case "history":
                try
                {
                    History h = new History();
                    boolean res = h.checkhistory(words);
                    if(res)
                    {
                        h.printhistory(words);
                    }
                    else
                    {
                        System.out.println("INVALID");
                    
                    }
                }
                catch(Exception e)
                {
                
                }
                break;

                
                    

                case "quit":
                case "exit":

                

                    System.exit(1);
                default:
                    break;
            }
        }
        
        else
        {
            System.out.println("PL/SQL 0101");
        }
        }
    }
}