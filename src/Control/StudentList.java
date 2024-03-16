
package Control;

import Model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import util.Inputter;

public class StudentList {
    public ArrayList<Student> arrS = new ArrayList();
    //add student
    public void addStudent()
    {
        String id =Inputter.getString("ID");
        Student s = new Student(id);
        if(arrS.contains(s)){
            System.out.println("Id had exitted");
            return;
        }
        s.setName(Inputter.getString("name"));
        s.setAge(Inputter.getInt("Age"));
        s.setAddress(Inputter.getString("Address"));
        s.setGpa(Inputter.getDouble("gpa"));
        arrS.add(s);
    }
    
    //delete student
    public void deleteStudent()
    {
        String id = Inputter.getString("Input ID want to delete");
        Student s = new Student(id);
        if(arrS.contains(id) == false){
            System.out.println("Id does not exits");
            return;
        }
        
    }
    //edit student
    public void editStudent(){
        Scanner sc = new Scanner (System.in);
        Student st = new Student();
        String id = sc.next();
        sc.nextLine();
        st.setId(id);
        arrS.get(arrS.indexOf(st)).setName(Inputter.getString("New name"));
        sc.nextLine();
        arrS.get(arrS.indexOf(st)).setAge(Inputter.getInt("new age"));
        arrS.get(arrS.indexOf(st)).setGpa(Inputter.getDouble("new gpa"));
        return;
    }
    //show student
    public void showStudent()
    {
        for(Student s:arrS)
            System.out.println(s);
    }
    
    public void readFromFile(String filename) {
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String sentence = sc.nextLine();
                String words[] = sentence.split("[|]");
                Student s = new Student((words[0]), words[1],
                        Integer.parseInt(words[2]), words[3],
                        Double.parseDouble(words[4]));
                arrS.add(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exits");
        }

    }
    
    public void saveToFile(String filename) {
        File f = new File(filename);
        try {
            FileOutputStream fo = new FileOutputStream(f, true);
            PrintStream ps = new PrintStream(f);
            for (Student s : arrS) {
                ps.print(s.toString() + "\n");
            }
            ps.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exits");
        }
    }
    
    
    public static<Student> void swap(ArrayList<Student> a, int i, int j)
    {
        Student tmp = a.get(i);
        a.set(i,a.get(j));
        a.set(j, tmp);
    }
    
    public static<Student> void sort(ArrayList<Student> a, Comparator<Student> c)
    {
       for(int i = 0; i < a.size(); i++)
        {
            for(int j = i+1; j < a.size() ; j++)
            {
                if((c.compare(a.get(i), a.get(j))) > 0)
                    swap(a, i, j);
            }
        } 
    }
    
//    public int sortStudent(Student student1, Student student2) {
//        int mode = 0;
//        System.out.println("1. ASC - 2. DESC");
//        mode = sc.nextInt();
//        
//if(mode == 1) return student1.getName().compareTo(student2.getName());
//else if (mode == 2) return student2.getName().compareTo(student1.getName());
//else return 0;
//    }
//}
    
}
