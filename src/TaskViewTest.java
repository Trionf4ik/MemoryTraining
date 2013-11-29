/** Этот класс предназначен для отображения заданий в программе "MemoryTraining"
это третий шаг к рабочей программе
@author Maksimov Roman
@version 2.1.1
 */

 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.*;
 import java.util.*;
 
 /** 
 Это управляющий класс предназначеный для тестирования класса TaskView
 */
 public class TaskViewTest
 {
	public static void main (String[] args)
	{
		NewFrame frame = new NewFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
 }
  /** Этот клас создает окно для тестирования класа TaskView  */
 class NewFrame extends JFrame
 {
   /** Конструктор класса  */
	public NewFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(500, 500);
		setLocation(150, 150);
		setTitle("TEST");
		/** Значения имитирующие взаимодействие с классом Task */
		Task task1 = new Task();
		int n = task1.getId();
		long [] p = task1.getPointNumber();
		TaskView panel = new TaskView(task1);
	//	TaskView panel = new TaskView(n, new long [] {117, 276, 403});
		
		add(panel);
	}

 }
 /** Класс отвечающий за вывод информации класса Task */
 class TaskView extends JPanel
 {
 /** Конструктор класса  c простыми параметрами*/
	public TaskView(int numberTask, long [] digital)
	{
		setLayout(new GridLayout(digital.length+1, 1));
		addTitle(numberTask);
		addValue(digital);
	}
 /** Конструктор класса  c обектом класса Task*/
	public TaskView(Task taskSet)
	{
		this(taskSet.getId(), taskSet.getPointNumber());
	}
 /** Метод выводит название задания в окне программы*/
	public void addTitle(long numberTask)
	{
		String t = "Task-" + numberTask;
		title = new JLabel(t, JLabel.CENTER);
		add(title);
	}
 /** Метод выводит елементы задания в окне программы*/
	public void addValue(long [] digital)
	{
		for(long i : digital)
		{

			String v = "____________________________"+i+"____________________________ ";
			JLabel value = new JLabel(v, JLabel.CENTER);
			add(value,BorderLayout.CENTER);
		}
	
	}
	private JLabel title;
	
 }