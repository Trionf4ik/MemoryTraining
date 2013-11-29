/** Этот модуль отвечает за контроль программы и всю ее логику
@author Maksimov Roman
@version 1.0.1
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
		button = new JButton(new NextAction());
		add(button, BorderLayout.NORTH);
		//setSize(500, 350);
		label = new JLabel("Step 1");
		add(label, BorderLayout.SOUTH);
		n=0;
		numberTask = 10;
		tasks = new Task[numberTask];
		tests = new Test[numberTask];
		tasks[n] = new Task();
		vTask = new TaskView(tasks[n]); 
		add(vTask, BorderLayout.CENTER);
		bTask = false;	
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
			label.setText("Step "+(n+1));
			revalidate();

		}
		else
		{	remove(vTask);
			tests[n] = new Test(tasks[n]);
			vTest = new TestView(tests[n]);			
			add(vTest, BorderLayout.CENTER);
			label.setText("Step "+(n+1));
			revalidate();
			n++;

		}
		bTask = !bTask;
	}
	else System.out.println("Training END!!!");
	}
	private JLabel label; //Текстовая метка, которая отображает состояние прохождения теста
	private TaskView vTask;//Панель вывода задания
	private TestView vTest;//Панель вывода теста
	private boolean bTask;//Следующим выводить задание? (true, false)
	private int numberTask;//Номер выводимого задания
	private Task [] tasks; // Массив всех заданий
	private Test [] tests; // Массив всех тестов
	private int n; //номер задания, которое отображается
	
}
/** Клас реализующий реакцию на нажатую кнопку "Next"*/
class NextAction extends AbstractAction
{
	public NextAction()
	{
		super("Next");
	}
	public void actionPerformed(ActionEvent event)
	{
		control.next();
	}
}
private ControlPanel control;
private JButton button;
}
