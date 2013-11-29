import java.awt.*;
import java.awt.font.*;
import javax.swing.*;
import java.awt.event.*;
public class ResultView extends JPanel
{
	public ResultView (Result r)
	{
		result = r;
		balls = result.getBalls();
		time = result.getTime();
		
		lBalls = new JLabel("<html><head>  <style> .brd { font: 32pt sans-serif; border: 4px double black; padding: 10px; width: 500 px; height: 150px} </style> </head> <body> <div class='brd'><p>Your balls: "+balls+"</p><p>Your traning time:"+time+"</p><p>You cope! But you can do better!</p></div></body></html>", JLabel.CENTER);
		//lTime = new JLabel("Your traning time:"+time, JLabel.CENTER);
		//lNote = new JLabel("You cope! But you can do better!", JLabel.CENTER);
		//setLayout(new GridLayout(1,1));
		add(lBalls);
		//add(lTime);
		//add(lNote);
	}
	private Result result;
	private int balls;
	private int time;
	private JLabel lBalls;
	private JLabel lTime;
	private JLabel lNote;
}