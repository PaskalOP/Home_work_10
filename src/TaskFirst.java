import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskFirst {

     private String nameFiles;

    public TaskFirst(String nameFiles) {
        this.nameFiles = nameFiles;
    }
    public String [] getPhones() throws IOException {
        ArrayList<String> phones = new ArrayList<>();
        File datafile = new File(nameFiles);
        Scanner sc = new Scanner(datafile);
        while (sc.hasNext()){
            phones.add(sc.nextLine());
        }
        sc.close();
        return phones.toArray(String[]::new);
    }

    public void checkPhones(String [] phones){
        String mask = "[0-9]{3}-[0-9]{3}-[0-9]{4}|\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}";
        for (String phone:phones) {
            if(phone.matches(mask )) System.out.println(phone);
        }
    }

    public static void main(String[] args) throws IOException{
        TaskFirst task = new TaskFirst("file.txt");
//        for (String str: task.getPhones()) {
//            System.out.println(str);
//        }
        task.checkPhones(task.getPhones());
    }
}
