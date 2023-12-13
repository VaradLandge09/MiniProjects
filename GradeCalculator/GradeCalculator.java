import java.util.*;

public class GradeCalculator 
{
    private int mathsMarks;
    private int scienceMarks;
    private int socialStudiesMarks;
    private int englishMarks;
    private int hindiMarks;

    private int totalM;
    private float percent;
    private String grade;


    Scanner sc = new Scanner(System.in);

    public void getMarks()
    {

        System.out.println("--------------------------------------------\n");
        System.out.print("Entre Marks Scored in Maths : ");
        mathsMarks = sc.nextInt();
        
        System.out.print("Entre Marks Scored in Science : ");
        scienceMarks = sc.nextInt();
        
        System.out.print("Entre Marks Scored in English : ");
        englishMarks = sc.nextInt();
        
        System.out.print("Entre Marks Scored in Social Studies : ");
        socialStudiesMarks = sc.nextInt();
        
        System.out.print("Entre Marks Scored in Hindi : ");
        hindiMarks = sc.nextInt();
        System.out.println("\n--------------------------------------------");
        sc.close();
    }
    
    public int totalMarks()
    {
        totalM = mathsMarks + englishMarks + scienceMarks + socialStudiesMarks + hindiMarks;
        return totalM;
    }

    public float percentage()
    {
        percent = (float)totalM/5;
        return percent;
    }

    public String getGrades()
    {

        if(percent > 95)
        {
            grade = "A+";
        }

        else if(percent > 89)
        {
            grade = "A";
        }

        else if(percent > 79)
        {
            grade = "B";
        }

        else if(percent > 69)
        {
            grade = "C";
        }

        else if(percent > 59)
        {
            grade = "D";
        }

        else if(percent > 49)
        {
            grade = "E";
        }

        else
        {
            grade = "F";
        }

        return grade;
    }

    
    public static void main(String[] args) 
    {
        
        int tM;
        float percent;
        String grad;

        System.out.print("\n************* Welcome To Grade Calculator ! ************\n\n");
        System.out.println("Entre markes Scored in Given Subjects (out of 100)\n");
        
        GradeCalculator  gc = new GradeCalculator();
        
        gc.getMarks();
        tM = gc.totalMarks();
        percent = gc.percentage();
        grad = gc.getGrades();
        
        System.out.println();
        System.out.println("Total Marks are : " + tM + " / 500");
        
        System.out.println();
        System.out.println("Total Percentage is : " + percent + "%");
        
        System.out.println();
        System.out.println("Your Overall Grade is : " + grad );
        
        System.out.print("\n**************** Thanks for Using ! ***************\n\n");




    }
}
