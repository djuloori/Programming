import java.util.*;

/**
 * Created by Dhruva Juloori on 7/20/2017.
 */
public class phone_book2 {
    static int no_of_buckets;
    static List<String>[] dict;
    static ArrayList<String> Solution = new ArrayList<>();
    static String newLine = System.getProperty("line.separator");
    static int prime = 1000000007;
    static int multiplier = 263;

    static class queries{
        static String type;
        static String name;
        static int number;
    }

    public static void main(String[] args){
        read();
        solution();
    }

    static void solution(){
        for(int i = 0; i < Solution.size(); i++){
            if(Solution.get(i).equals(newLine)) {
                System.out.print(Solution.get(i));
            }else{
                System.out.println(Solution.get(i));
            }
        }
    }

    static void read(){
        Scanner input = new Scanner(System.in);
        no_of_buckets = input.nextInt();
        dict = new List[no_of_buckets];
        for (int i = 0; i < dict.length; i++){
            dict[i] = new ArrayList<>();
        }
        int no_of_queries = input.nextInt();
        input.nextLine();
        for(int i = 0; i < no_of_queries; i++){
            String str = input.nextLine();
            String[] temp;
            String delimiter = " ";
            temp = str.split(delimiter);
            queries.type = temp[0];
            if(queries.type.equals("add")){
               queries.name = temp[1];
               add(queries.name);
            }else if(queries.type.equals("del")){
                queries.name = temp[1];
                delete(queries.name);
            }else if(queries.type.equals("find")){
                queries.name = temp[1];
                search(queries.name);
            }else if(queries.type.equals("check")){
                queries.number = Integer.parseInt(temp[1]);
                check(queries.number);
            }else{
                continue;
            }
        }
    }


    static long hashcode(String key){
        long hash = 0;
        for (int i = key.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + key.charAt(i)) % prime;
        return (int)hash % no_of_buckets;
    }

    static void search(String a){
        long hashvalue = hashcode(a);
        if(dict[(int)hashvalue].contains(a)){
            Solution.add("yes");
        }else{
            Solution.add("no");
        }
    }

    static void add(String a){
       long hashvalue = hashcode(a);
       if(dict[(int)hashvalue].contains(a)){
           return;
       }else{
           dict[(int)hashvalue].add(0,a);
       }
    }

    static void delete(String a){
        long hashvalue = hashcode(a);
        if(dict[(int)hashvalue].contains(a)){
            dict[(int)hashvalue].remove(a);
        }else{
            return;
        }
    }

    static void check(Integer a){
      if(dict[a].size()!=0){
          String str1 = "";
        for(int i = 0; i < dict[a].size(); i++){
            if(i == 0){
                str1 = str1 + dict[a].get(i);
            }else{
                str1+= " " + dict[a].get(i);
            }
        }
        Solution.add(str1);
      }else{
          Solution.add(newLine);
      }
    }
}
