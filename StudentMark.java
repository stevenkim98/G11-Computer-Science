/* Program Name: Mark Manager Program
   Author: Dennis Tismenko
   Date Created: May 18, 2015
   Last Revision: May 19, 2015
   Description: Mark Manager Program with ability to edit name and grade. 
   Version: 1.5
   */
import java.awt.*;
import hsa.Console;

public class StudentMark
{
    static Console c, d, e;          // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	// d = new Console ();
	//Declare variables
	boolean exitCondition = false; //used later for console loop
	boolean changedName = false;
	boolean changedGrade = false;
	boolean printReturn;
	int yCor; //Y coordinate for output table
	int x = 0; //number of students used for the array
	String input, getName; //used later for console input
	double[] grade;
	String[] name;
	String[] keywords = {"/help", "/editName", "/editGrade", "/print", "/exit"};
	//Establish Fonts
	Font title = new Font ("DINPro-Bold", Font.PLAIN, 40);

	//Output
	c.setFont (title);
	c.drawString ("MarkBook Program", 180, 40);
	c.setCursor (5, 1);
	c.print ("This program will allow you to create and modify students and their grades.\nThen, this program will organize your data into a readable table.");

	//Delay
	try
	{
	    Thread.sleep (500);
	}
	catch (InterruptedException ex)
	{
	    Thread.currentThread ().interrupt ();
	}

	//Prompt

	c.print ("\n\nPlease begin by entering the total number of students (min 4): ");
	x = c.readInt ();
	while (x < 4)
	{
	    c.print ("Enter a valid input: ");
	    x = c.readInt ();
	}
	grade = new double [x];
	name = new String [x];
	for (int i = 0 ; i < x ; i++)
	{
	    c.print ("Enter the name of student " + (i + 1) + ": ");
	    name [i] = c.readLine ();
	    //Number between (1-100)
	    do
	    {
		c.print ("Enter " + name [i] + "'s grade: ");
		grade [i] = c.readDouble ();
	    }
	    while (grade [i] < 0 || grade [i] > 100);

	}

	//Delay
	try
	{
	    Thread.sleep (1000);
	}
	catch (InterruptedException ex)
	{
	    Thread.currentThread ().interrupt ();
	}
	//Part 2: Editing the mark
	c.clear ();
	c.println ("Welcome to your console. Your basic commands include '/help', '/editName', \n'/editGrade', '/print', and '/exit'.\n");
	while (exitCondition == false)
	{
	    input = c.readLine ();
	    //KEYWORD /help
	    if (input.equalsIgnoreCase (keywords [0]))
	    {
		d = new Console ();
		d.println ("COMMAND HELP CENTER (commands are not case-sensitive)\n");
		d.println ("/help -- Opens up this menu..............................");
		d.println ("/editName -- Allows you to edit an existing name.........");
		d.println ("/editGrade -- Allows you to edit an existing user's grade");
		d.println ("/print -- Displays all names and grades in a table.......");
	    }
	    //KEYWORD /editName
	    else if (input.equalsIgnoreCase (keywords [1]))
	    {
		c.println ("Enter the existing user's name that you want to edit:");
		getName = c.readLine ();
		changedName = false; //Value of the boolean must reset before the check.
		for (int j = 0 ; j < x ; j++)
		{
		    if (getName.equalsIgnoreCase (name [j]))
		    {
			c.println ("What is the desired name for this user: ");
			name [j] = c.readLine ();
			changedName = true;
			c.println ("Saved.");
		    }
		}
		if (changedName == false)
		{
		    c.println ("User not found.");
		}
	    }
	    //KEYWORD /editGrade
	    else if (input.equalsIgnoreCase (keywords [2]))
	    {
		c.println ("Enter the user's name whose grade you want to edit:");
		getName = c.readLine ();
		changedGrade = false; //Value of the boolean must reset before the check.
		for (int j = 0 ; j < x ; j++)
		{
		    if (getName.equalsIgnoreCase (name [j]))
		    {
			c.println ("What is the desired mark for this user: ");
			grade [j] = c.readDouble ();
			while (grade [j] < 0 || grade [j] > 100)
			{
			    c.print ("Enter a valid mark: ");
			    grade [j] = c.readDouble ();
			}
			changedGrade = true;
			c.println ("Saved.");
		    }
		}
		if (changedGrade == false)
		{
		    c.println ("User not found.");
		}
	    }
	    //KEYWORD /print
	    else if (input.equalsIgnoreCase (keywords [3]))
	    {
		//e = new Console (); //not transferring values//
		c.clear ();
		c.setCursor (1, 5);
		c.print ("Student");
		c.setCursor (1, 26);
		c.print ("Mark");
		c.setCursor (2, 1);
		for (int l = 0 ; l < 35 ; l++)
		{
		    c.print ("-");
		}
		for (int m = 0 ; m < x ; m++)
		{
		    yCor = (m + 3);
		    c.setCursor (yCor, 1);
		    c.print (name [m]);
		    c.setCursor (yCor, 22);
		    c.print (grade [m]);
		}
		c.drawLine (161, 1, 161, 600);
		c.drawLine (278, 1, 278, 600);
		return;

	    }
	    //KEYWORD /exit
	    else if (input.equalsIgnoreCase (keywords [4]))
	    {
		exitCondition = true;
	    }
	    //Invalid input
	    else
	    {
		c.println ("That is not a valid command. Type /help for more commands.");
	    }
	}



	// Place your program here.  'c' is the output console
    } // main method
} // StudentMark class


