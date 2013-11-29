/** Этот класс предназначен для отображения теста задания в программе "MemoryTraining"
это седьмой шаг к рабочей программе
@author Maksimov Roman
@version 1.2.1
 */

 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.*;
 import javax.swing.event.*;
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
		setTitle("TEST_view_test");
		/** Значения имитирующие взаимодействие с классом Task */
		Task task = new Task();
		Test test = new Test(task);
		TestView panel = new TestView(test);
		add(panel);
	}

 }
 /** Класс отвечающий за вывод информации класса Task */
class TestView extends JPanel
{
	public TestView(Test t)
	{
		test = t;
		length = test.getTestLength();
		checkBoxes = new JCheckBox[length];
		answerArray = test.getAnswer();
		addTitle();
		addAnswers();
		//addButton();
		result = new Result();
	}
	public TestView(Test t, Result r)
	{
		this(t);
		result = r;
	}
	
 /** Метод выводит оглавление задания */
	public void addTitle ()
	{
		JPanel title = new JPanel();
		title.setSize(500, 100);
		JLabel titleLabel = new JLabel("Test #"+test.getId());
		
		setLayout(new BorderLayout());
		title.add(titleLabel);
		add(title, BorderLayout.NORTH);
	}
 /** Метод выводит непосредственно задание теста */
	public void addAnswers()
	{
		checkBoxPanel = new JPanel();
		for (int a=0; a<length; a++)
		{
		addCheckBox(a, answerArray[a]);
		}
		add(checkBoxPanel, BorderLayout.CENTER);
	}
 /** Метод добавляет переключатели для выбора ответов */
	public void addCheckBox (int counter, Answer answer)
	{
		if (counter<checkBoxes.length)
		{
		String stroke = ""+answer.getNumber();
		checkBoxPanel.setLayout(new GridLayout(5, 6));
		checkBoxes[counter] = new JCheckBox(stroke, false);
		checkBoxPanel.add(checkBoxes[counter]);	
		}
		else System.out.print ("Array CheckBoxes is Full! You may change programm!");
	}
 /** Метод выводит кнопку "ОК" и создает обработчик к ней */
	public ActionListener addListener ()
	{
		//JPanel button = new JPanel();
		//JButton ok = new JButton("OK");
		//button.add(ok);
		ActionListener listener = new ActionListener ()
			{
			public void actionPerformed (ActionEvent event)
			{
				for (int a =0; a<length; a++)
				{
					answerArray[a].setUserNumber(checkBoxes[a].isSelected());
					System.out.println(""+answerArray[a].getNumber()+" "+checkBoxes[a].isSelected());
				}
				result.update(test);
				System.out.println(""+result.getBalls());
			}
			};
		//ok.addActionListener(listener);
		return listener;
		//add(button, BorderLayout.SOUTH);
	}
	private Result result;
	private int length;
	private JCheckBox [] checkBoxes;
	private Answer [] answerArray;
	private Test test;
	private String [] label;
	private JPanel checkBoxPanel;
}