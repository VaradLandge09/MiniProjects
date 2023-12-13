package StudentManagementSystem;

import java.io.*;
import java.util.*;

class Student implements Serializable
{
    private String name;
    private long mobileNo;
    private String email;
    private String branch;
    private int seatNo;

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setMobileNo(long mobileNo)
    {
        this.mobileNo = mobileNo;
    }
    public long getMobileNo()
    {
        return mobileNo;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }
    public String getBranch()
    {
        return branch;
    }

    public void setSeatNo(int seat)
    {
        this.seatNo = seat;
    }
    public int getRoll()
    {
        return seatNo;
    }

    public void disp()
    {
        System.out.println("\n---------------- Student Details ----------------\n");
        System.out.println("Name of Student : " + name);
        System.out.println("Mobile Number of Student : " + mobileNo);
        System.out.println("Email of Student : " + email);
        System.out.println("Branch of Student : " + branch);
        System.out.println("Seat Number of Student : " + seatNo);
        System.out.println("\n--------------------------------------------------\n");

    }

}

public class StudentManagementSys  
{
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int flag = 0;

        System.out.println("************** Student Management System ***************\n");

        ArrayList<Student> studentsList = new ArrayList<Student>();
        try 
        {
            while(flag == 0)
            {
            System.out.println("Select The operations you want to perform !!!");
            System.out.println("1. Add student");
            System.out.println("2. remove student");
            System.out.println("3. search for a student");
            System.out.println("4. display all students");
            System.out.println("5. Exit");
            // System.out.println("Size : " + studentsList.size());
            System.out.print("Entre your choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch(ch)
            {
                case 1: // Adding student --------------------------------------------------------------
                    Student s = new Student();
                    System.out.println("\n================= Adding Student ================\n");
                    System.out.print("Entre the Name of Student : ");
                    String name0 = sc.nextLine();
                    s.setName(name0);
                    
                    System.out.print("Entre the Mobile number of Student : ");
                    long moblieNo = sc.nextLong();
                    s.setMobileNo(moblieNo);
                    
                    System.out.print("Entre the Email of Student : ");
                    String email = sc.next();
                    s.setEmail(email);
                    
                    System.out.print("Entre the Branch of Student : ");
                    sc.nextLine();
                    String branch = sc.nextLine();
                    s.setBranch(branch);

                    System.out.print("Entre the Seat Number of the Student : ");
                    int seatn = sc.nextInt();
                    s.setSeatNo(seatn);

                    studentsList.add(s);
                    System.out.println("Student '" + s.getName() + "' Added !!!");
                    System.out.println("\n==================================================\n");
                    break;

                case 2: // Removing Student ------------------------------------------------------------------

                System.out.println("\n================= Removing Student ===============\n");
                // sc.nextLine();
                
                int temp = 0;
                
                if(studentsList.size() == 0)
                {
                    System.out.println("Student list is Empty !!!");
                }
                else
                {
                        System.out.println("Entre the name of Student to be Removed : ");
                        String name1 = sc.nextLine();
    
                        for(Student stu: studentsList)
                        {
                            if(stu.getName().equals(name1))
                            {
                                studentsList.remove(stu);
                                System.out.println("Student "+ name1 + " Removed !!!");
                                temp = 1;
                                break;
                            }
                        }
                        if(temp == 0)
                        {
                            System.out.println("Student Not Found !!!");
                        }

                }
                    


                    System.out.println("\n==================================================\n");

                    break;

                case 3: // Searching Student ------------------------------------------------------------------------

                    System.out.println("\n================ Searching Student ================\n");
                    if(studentsList.size() == 0)
                    {
                        System.out.println("Student List is Empty !!!");
                    }
                    else
                    {
                        System.out.println("Entre the name of Student you want to Search : ");
                        String name2 = sc.nextLine();
                        int temp1 = 0;
                    
                        for(Student stu: studentsList)
                        {
                            if(stu.getName().equals(name2))
                            {
                                System.out.println("Student details are as follows : ");
                                stu.disp();
                                temp1 = 1;
                                break;
                            }
                        }

                        if(temp1 == 0)
                        {
                            System.out.println("Student Not Found !!!");
                        }
                    }
                    
                    System.out.println("\n===================================================\n");

                    break;

                case 4: // Displaying All Students ----------------------------------------------------------------------

                    System.out.println("\n================ Displaying All Students ================\n");


                    if(studentsList.size() == 0)
                    {
                        System.out.println("Students Listt is Empty !!!");
                    }
                    else
                    {
                        int i = 0;                    
                        for(Student st: studentsList)
                        {
                            i++;
                            System.out.println("Student number " + i + " :");
                            st.disp();
                        }

                    }
                    
                    System.out.println("\n======================================================\n");                                      

                    break;

                case 5: // Exit -----------------------------------------------------------------------------------------
                    flag = 1;
                    // Below Object 'oos' will store the object "studentList" in a file named "StudentList.txt "
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentList.txt"));
                    oos.writeObject(studentsList);
                    break;

                default:
                    System.out.println("Invalid Input !!!");
                    break;
            }
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Entre a valid input !!!");
        }
        catch(Exception e)
        {
            System.out.println("Something Went worng !!!");
        }

        
        sc.close();

        System.out.println("\n*************** Thanks For Using ! ****************");

        /*
        // This code is to take retrive the data from the file "StudentList"
        // make sure to write the same class "Student" to retrive it.

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentList.txt"));
        ArrayList<Student> al = (ArrayList) ois.readObject();
        Student st1 = al.get(0);
        System.out.println(al + "\n");
        st1.disp();
        Student st2 = al.get(1);
        st2.disp();
        ois.close();
        */
        
    }

    

}