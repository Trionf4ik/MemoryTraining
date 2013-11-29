/** Этот класс предназначен для отображения теста задания в программе "MemoryTraining"
это седьмой шаг к рабочей программе
@author Maksimov Roman
@version 1.0.0
 */

 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.*;
 import java.util.*;
 
 /** 
 Это управляющий класс предназначеный для тестирования класса TaskView
 */
 public class TestViewTest
 {
	public static void main (String[] args)
	{
		TestViewFrame frame = new TestViewFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
 }
  /** Этот клас создает окно для тестирования класа TaskView  */
 class TestViewFrame extends JFrame
 {
   /** Конструктор класса  */
	public TestViewFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(500, 500);
		setLocation(150, 150);
		setTitle("TEST");
		/** Значения имитирующие взаимодействие с классом Task */
		Task task = new Task();
		Test test = new Test(task);
		int n = task1.getId();
		long [] p = task1.getPointNumber();
		TestView panel = new TestView(test);
		
		add(panel);
	}

 }
 /** Класс отвечающий за вывод информации класса Task */
class TestView extends JPanel
{
	public TestView(Test testSet)
	{
		test = testSet;
		addAnswer()
	}
	public void addAnswer ()
	{
		JLabel Title = new JLabel("Test #"+1);
		add(title);
	}
	private Test test;
}