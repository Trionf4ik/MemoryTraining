import java.awt.*;
import java.awt.font.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class ResultView extends JPanel
{
	public ResultView (Result r) throws FileNotFoundException
	{
		result = r;
		balls = result.getBalls();
		time = result.getTime();
		lBalls = new JLabel("<html><head>  <style> .brd { font: 32pt sans-serif; border: 4px double black; padding: 10px; width: 500 px; height: 150px} </style> </head> <body> <div class='brd'><p>Your balls: "+balls+"</p><p>Your traning time:"+time+"</p><p>You cope! But you can do better!</p></div></body></html>", JLabel.CENTER);
		add(lBalls);
		try
		{
		 PrintWriter out = new PrintWriter(new FileOutputStream("data\\result.txt"), true);
		 out.println("This file stores result memory training");
		 out.println(balls);
		 out.println(time);
		}
		catch(FileNotFoundException e)
		{
		 System.out.println("File result.txt not found");
		}
	}
	private Result result;
	private int balls;
	private int time;
	private JLabel lBalls;
	private JLabel lTime;
	private JLabel lNote;
}