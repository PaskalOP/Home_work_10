import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

public class TaskSecond {


    public User makeUser (String dataFromFile){
        String [] parts = dataFromFile.split(" ");
        User user = new User(parts[0], Integer.parseInt (parts[1]));
        return user;
    }
    public  String getJsonUser( User user){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        return json.toJson(user);
    }

    public static void main(String[] args) throws IOException {
        TaskSecond ts = new TaskSecond();
        File usersData = new File("fileUsers.txt");
        File jasonUsers = new File("jsonUsers.txt");
        jasonUsers.createNewFile();
        Writer fw = new FileWriter(jasonUsers);
        Scanner sc = new Scanner(usersData);
        sc.nextLine() ;
        fw.write("[\n");
        while (sc.hasNext()){
            String userData = sc.nextLine();
            User newUser = ts.makeUser(userData);
            String jsonUser = ts.getJsonUser(newUser);
            fw.write( jsonUser + "\n");

        }
        fw.write("]\n");
        fw.flush();
        fw.close();
        sc.close();
    }
}
