/** Этот модуль предназначена для запуска тренировки памяти
@author Maksimov Roman
@version 1.0.0
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/** Этот класс создает новый фрейм для тестирования модуля */
public class NewGame
{
	public static void main(String[] args)
	{
		NewGameFrame game = new NewGameFrame();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	}
}

/** Непосредственно модуль способный запускать процесс тренировки */
class NewGameFrame extends JFrame
{

	public NewGameFrame()
	{
	/** Создаем фрейм и задаем его параметры: Размер, Размещение, Название*/
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(500, 500);
		setLocation(150, 150);
		setTitle("New Game");
	/** Создаем новое задание но пока не выводим его на екран*/	
		task = new Task();
		view = new TaskView(task);
		view.setVisible(false);
		add(view);
	/** Создаем главное меню в котором кнопка "New" - Отвечает за запуск процесса тренировки*/	
		JMenuBar mainMenu = new JMenuBar();
		setJMenuBar(mainMenu);
		JMenu file = new JMenu("File");
		mainMenu.add(file);
		StartAction newAction = new StartAction();
		JMenuItem newItem = file.add(newAction);	
	}

	/** Этот класс отвечает за действия после нажатия клавиши "New" в главном меню*/
	class StartAction extends AbstractAction
{
	public StartAction()
	{
		super("New");
	}
	public void actionPerformed (ActionEvent event)
	{
	// Делаем новое задание видимым
	view.setVisible(true);
	}
}	
	private Task task;
	private TaskView view;
}

