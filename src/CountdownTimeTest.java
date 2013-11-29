/** Этот модуль отвечает за контроль времени заданий и представление его пользователю в 
виде обратного отсчёта.
@author Maksimov Roman
@version 1.1.0
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer.*;
import javax.swing.event.*;

/** Этот класс тестирует работу данного модуля*/
public class CountdownTimeTest
{
	public static void main (String[] args) throws InterruptedException
	{
		CountdownTimeFrame time = new CountdownTimeFrame();
		time.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		time.setVisible(true);
	}
}
/** Этот класс создает тестовый фрейм для тестирования*/
class CountdownTimeFrame extends JFrame
{
	public CountdownTimeFrame ()
	{
	Toolkit kit = Toolkit.getDefaultToolkit();
	setSize(150, 100);
	setLocation(300, 300);
	setTitle("Time");
	countdown = new CountdownTime(5);
	add(countdown);
	
	}
	private CountdownTime countdown;
}
class CountdownTime extends JPanel
{
/** Класс выводит панель на которой отображается обратный отсчет времени
@param t - время обратного отсчета */
	public CountdownTime (int t)
	{ 
		booleanTest = false;
		time = t;
		label = new JLabel ("Start");
		add(label);
	}
	
/** Метод создает таймер который каждую секунду запускает метод countdownView()*/	
	public void countdown() 
	{
		Timer timer = new Timer(1000, new ActionListener(){
		public void actionPerformed (ActionEvent event)
		{
		countdownView();
		}});
		timer.start();
	}
/** Метод выводит на панель остаток времени. Если время вышло закрывает программу.*/
	public void countdownView()
	{	
		label.setText(""+time);
		time--;
		if (time<0) 
		{
			booleanTest=!booleanTest;
			System.exit(0);
		}
	}

	public boolean getBooleanTest()
	{
		return booleanTest;
	}
	private int time;
	private JLabel label;
	private boolean booleanTest;
}