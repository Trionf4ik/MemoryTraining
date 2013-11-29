/** Этот класс предназначен для отображения теста задания в программе "MemoryTraining"
это седьмой шаг к рабочей программе
@author Maksimov Roman
@version 1.0.1
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
		setTitle("TEST");
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
	public TestView(Test testSet)
	{
		test = testSet;
		addTitle();
		addAnswers();
		addButton();
	}
 /** Метод выводит оглавление задания */
	public void addTitle ()
	{
		JPanel title = new JPanel();
		title.setSize(500, 100);
		JLabel titleLabel = new JLabel("Test #"+1);
		
		setLayout(new BorderLayout());
		title.add(titleLabel);
		add(title, BorderLayout.NORTH);
	}
 /** Метод выводит непосредственно задание теста */
	public void addAnswers()
	{
		checkBoxPanel = new JPanel();
		Answer [] answerArray = test.getAnswer();
		for (int a=0; a<answerArray.length; a++)
		{
		addCheckBox(a, answerArray[a]);
		System.out.println(""+a.isSelected());
		}
		add(checkBoxPanel, BorderLayout.CENTER);
	}
 /** Метод добавляет переключатели для выбора ответов */
	public void addCheckBox (int counter, Answer answer)
	{
		String stroke = " "+answer.getNumber();
		checkBoxPanel.setLayout(new GridLayout(5, 6));
		JCheckBox temp = new JCheckBox(stroke, false);
		checkBoxPanel.add(temp);		
	}
 /** Метод выводит кнопку "ОК" и создает обработчик к ней */
	public void addButton ()
	{
		JPanel button = new JPanel();
		JButton ok = new JButton("OK");
		button.add(ok);
		ActionListener listener = new ActionListener ()
			{
			public void actionPerformed (ActionEvent event)
			{
				for (int a=0; a<answerArray.length; a++)
				{
				if a.isSelected()
				System.out.println("OK");
				
			}
			});
		ok.addActionListener(listener);

		add(button, BorderLayout.SOUTH);
	}
	private Test test;
	private JPanel checkBoxPanel;
}