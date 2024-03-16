/*
Mỗi đối tượng sinh viên có các thuộc tính sau
id, name, age, address và gpa
yc: tạo ra menu với các chức năng:
- add student
- delete by id
- edit name, age, address by id
- show student
- exit

 */
package View;

import Control.StudentList;
import Model.Student;
import util.Inputter;

public class Menu {
    StudentList st = new StudentList();
    public void menuSort()
    {
       System.out.println("1. Sort asc");
       System.out.println("2. Sort desc");
       int choice = Inputter.getInt("Choice: ", 1, 2);
       switch(choice)
       {
            case 1:
                StudentList.sort(st.arrS, (Student o1, Student o2) -> o2.compareTo(o1));
                st.showStudent();
                break;
            case 2:
                StudentList.sort(st.arrS, (Student o1, Student o2) -> o1.compareTo(o2));
                st.showStudent();
                break;
       }
    }
    public void menune() {
        
        int choice;
        do {
            System.out.println("------------------------------------------");
            System.out.println("|                Menu                     |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|1.Add student                            |");
            System.out.println("|2.delete by ID                           |");
            System.out.println("|3.Edit                                   |");
            System.out.println("|4.Show                                   |");
            System.out.println("|5.read from file                         |");
            System.out.println("|6.save to file                           |");
            System.out.println("|7.sort                                   |");
            System.out.println("-------------------------------------------");
            choice = Inputter.getInt("Choice: ", 1, 7);

            switch (choice) {
                case 1:
                    st.addStudent();
                    break;
                case 2:
                    st.deleteStudent();
                    break;
                case 3:
                    st.editStudent();
                    break;
                case 4:
                    st.showStudent();
                    break;
                case 5:
                    st.readFromFile("input.txt");
                    break;
                case 6:
                    st.saveToFile("input.txt");
                    break;
                case 7:
                    menuSort();
                    break;
                default:
                    break;
            }
        } while (choice >= 1 && choice <= 8);

    }

    public static void main(String[] args) {
        Menu mn = new Menu();
        mn.menune();
    }
}
