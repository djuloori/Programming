import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dhruva Juloori on 7/16/2017.
 */
public class phone_book {
    static String[] dict = new String[10000000];
    static ArrayList<String> solution = new ArrayList<>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int no_of_queries = input.nextInt();
        input.nextLine();
        for(int i = 0; i < no_of_queries; i++){
           String str = input.nextLine();
           String[] temp;
           String delimiter = " ";
           temp = str.split(delimiter);
           queries.type = temp[0];
           queries.number = Integer.parseInt(temp[1]);
           if(queries.type.equals("add")){
               queries.name = temp[2];
               add(queries.number,queries.name);
           }else if(queries.type.equals("find")){
                search(queries.number);
           }else{
               delete(queries.number);
           }
        }
        for(int i = 0; i < solution.size(); i++){
            System.out.println(solution.get(i));
        }
    }

    static void add(int a, String b){
        dict[a] = b;
    }

    static void search(int a){
        if(dict[a]!=null){
            solution.add(dict[a]);
        }else{
            solution.add("not found");
        }
    }

    static void delete(int a){
        dict[a] = null;
    }

    static class queries{
        static String type;
        static int number;
        static String name;

        public queries( String type, int number, String name){
            this.type = type;
            this.number = number;
            this.name = name;
        }

        public queries(String type, int number){
            this.type = type;
            this.number = number;
        }
    }
}
