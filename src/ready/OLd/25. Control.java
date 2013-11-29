/** Этот модуль отвечает за контроль программы и всю ее логику
@author Maksimov Roman
@version 1.4.2
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
/** Класс для теста данного модуля */
public class Control
{
	public static void main (String[] args)
	{
		ControlFrame frame = new ControlFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
/** Класс создает новый фрейм для вывода данных
в нем есть внутренние класы в которых реализована вся логика*/
	class ControlFrame extends JFrame
{
/** Конструктор главного фрейма программы */
	public ControlFrame ()
	{
	Toolkit kit = Toolkit.getDefaultToolkit();
	setSize(1000, 700);
	setLocation(50, 100);
	setTitle("Control");
	control = new ControlPanel();

	add(control);
	}
/** Класс отвечающий за панель модуля тестирования в которой выводятся задания 
и тесты к заданиям*/
	
	/** Клас реализующий реакцию на нажатую кнопку "Next"*/


private ControlPanel control;
private JButton button;
}

class NextAction extends AbstractAction
{
	public NextAction(ControlPanel panel)
	{
		super("Next");
		control = panel;
	}
	public void actionPerformed(ActionEvent event)
	{
		control.next();
	}
	private ControlPanel control;
}

class ControlPanel extends JPanel
	{
/** Конструктор класса 
@param numberTask - количество заданий в одном цикле тренировки
@param bTask - булевое значение хранящее переменную задание или тест следующее
нужно выводить true - задание, false - тест
@param label - переменная хранит данные строки состояния внизу панели
@param tasks - масив заданий 
@param tests - масив тестов
@param n - номер задания которое отображается в данный момент
*/
	public ControlPanel()
	{
		setLayout(new BorderLayout());
		nextAction = new NextAction(this);
		button = new JButton(nextAction);
		add(button, BorderLayout.NORTH);
		label = new JLabel("Step 1");
		add(label, BorderLayout.SOUTH);
		n=0;
		numberTask = 5;
		Task.zeroing();
		tasks = new Task[numberTask];
		tests = new Test[numberTask];
		tasks[n] = new Task();
		vTask = new TaskView(tasks[n]); 
		add(vTask, BorderLayout.CENTER);
		bTask = false;
		result = new Result();
		
	}
/** Метод который отвечает за то чтоб за показом задания
следовал показ теста к этому заданию, a за тестом новое задание*/
	public void next()
	{
	if (n<numberTask)
	{
		if (bTask) 
		{ 	remove(vTest);
			tasks[n] = new Task();
			vTask = new TaskView(tasks[n]); 
			add(vTask, BorderLayout.CENTER);
			label.setText("Step "+tasks[n].getId());
			revalidate();
		}
		else
		{	remove(vTask);
			tests[n] = new Test(tasks[n]);
			vTest = new TestView(tests[n], result);	
			listener = vTest.addListener();
			button.addActionListener(listener);
			add(vTest, BorderLayout.CENTER);
			label.setText("Step "+tests[n].getId());
			revalidate();
			n++;
		}
		bTask = !bTask;
		
	}
	else 
	{	
		System.out.println("Training END!!!");
		remove(vTest);
		add(new ResultView(result));
		label.setText("End!");
		revalidate();
	}
	}
	private NextAction nextAction;
	private JButton button;
	private JLabel label; //Текстовая метка, которая отображает состояние прохождения теста
	private TaskView vTask;//Панель вывода задания
	private TestView vTest;//Панель вывода теста
	private boolean bTask;//Следующим выводить задание? (true, false)
	private int numberTask;//Номер выводимого задания
	private Task [] tasks; // Массив всех заданий
	private Test [] tests; // Массив всех тестов
	private int n; //номер задания, которое отображается
	private Result result; //Результаты тестирования
	private ActionListener listener;
}