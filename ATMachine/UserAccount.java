package ATMachine;

import java.util.Scanner;

public class UserAccount implements ATMachine
{
    private int userBalance;
    private String userName;

    void setBalance(int bal)
    {
        this.userBalance = bal;
    }

    public void setName(String name)
    {
        this.userName = name;
    }

    public String getName()
    {
        return userName;
    }

    public void withdraw(int amount)
    {
        try
        {
            
            if(userBalance < amount)
            {
                ArithmeticException e = new ArithmeticException();
                throw e;
            }
            else
            {
                userBalance = userBalance - amount;
                System.out.println("Amount Withdrawl Successful !!!\n");
            }

        }
        catch(ArithmeticException e)
        {
            System.out.println("Insufficient Balance !!!\n");
        }

    }

    public void deposite(int amount)
    {
        userBalance = userBalance + amount;
        System.out.println("Amount added Successfully !!!");
        // System.out.println("Available Balance : " + userBalance + "\n");
    }

    public int checkBalance()
    {
        return userBalance;
    }

    public static void main(String[] args) 
    {
        int flag = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n************* ATM Machine interface *************\n\n ");

        UserAccount user1 = new UserAccount();
        user1.setName("Varad Landge");
        String name = user1.getName();
        user1.setBalance(100000);

        System.out.println("Hii, " + name);
        System.out.println("Your current Balance is : " + user1.checkBalance());
        System.out.println("");

               
        
        while(flag == 0)
        {
            System.out.print("\n");
            System.out.println("What are you up to : ");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposite Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("\n");
            
            System.out.println("------------------------------------------------");
            System.out.print("\n");
            System.out.print("Entre the Corresponding Number : ");
            int choice = sc.nextInt();
            System.out.print("\n");

            switch(choice)
            {
                case 1:
                    System.out.println("================ Withdrawing ================\n");
                    System.out.print("Entre amount you want to Withdraw : ");
                    int amount = sc.nextInt();
                    user1.withdraw(amount);
                    System.out.println("=============================================\n");
                    break;
                    
                    case 2:
                    System.out.println("================ Deposit ================\n");
                    System.out.print("Entre amount you want to Deposite : ");
                    amount = sc.nextInt();
                    user1.deposite(amount);
                    System.out.println("\n==========================================\n");
                    break;
                    
                    case 3:
                    System.out.println("================= Balance ================\n");
                    int bal = user1.checkBalance();
                    System.out.println("Your current balance is : " + bal + "\n");
                    System.out.println("==========================================\n");
                    break;

                case 4: 
                    System.out.println("********* Thanks for Using the ATM interface !!! **********\n");
                    flag = 1;
                    break;

                default:
                    System.out.println("Entre a valid Input !!!\n");
                    break;

            }

        }

        sc.close();
        
    }

}
