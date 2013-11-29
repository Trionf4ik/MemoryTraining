/**Этот класс ответственный за создание меню программы MemoryTraining
@author Maksimov Roman
@version 2.0.0
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

/**код отвечающий за тестирование этого модуля */
public class MenuTest
{

	public static void main (String[] args)
	{
		MenuFrame menu = new MenuFrame();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
	}
	
}
/** создает окно программы с меню */
class MenuFrame extends JFrame
{
	public MenuFrame()
	{
	Toolkit kit = Toolkit.getDefaultToolkit();
//Задание имени окна
	setTitle("Menu");
//Задание размеров окна
	setSize(500, 500);
//Задание места вывода окна
	setLocation(150,150);
//Создание главного меню
	JMenuBar bar = new JMenuBar();
//Добавление главного
	setJMenuBar(bar);
//Создание главного пункта меню
	JMenu fileMenu = new JMenu("File");
	
//Тестовые временные событие нажатия пунктов главного меню 
	TestAction NewAction =new TestAction("New");
	TestAction RezultsAction =new TestAction("Rezults");
	TestAction DocumentationAction =new TestAction("Documentation");
	
//Создание подпунктов главного меню и кнопок их быстрого доступа
	JMenuItem newItem = fileMenu.add(NewAction);
	newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
	JMenuItem resultsItem = fileMenu.add(RezultsAction);
	resultsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));

//Событие выход из программы
	JMenuItem exitItem = fileMenu.add ( new 
		AbstractAction ("Exit")
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
	exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
	
//Добавление пунктов меню и клавиш быстрого доступа
	JMenu viewMenu = new JMenu("View");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem documantationItem = helpMenu.add(DocumentationAction);
	documantationItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
	JMenuItem aboutItem = helpMenu.add(new AboutAction());
	aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
	bar.add(fileMenu);
	bar.add(viewMenu);
	bar.add(helpMenu);
	
//Контекстное меню
	JPopupMenu rmMenu = new JPopupMenu();
	rmMenu.add(new AboutAction());
	rmMenu.add(DocumentationAction);
	JPanel rmPanel = new JPanel();
	rmPanel.setComponentPopupMenu(rmMenu);
	rmPanel.addMouseListener(new MouseAdapter() {});
	add(rmPanel);
	
	}	
}

//Обработка тестового события
class TestAction extends AbstractAction
{
	TestAction(String name) {super(name);}
	public void actionPerformed (ActionEvent event)
	{
		System.out.println("activate "+getValue(Action.NAME));
	}
}

//Обработка события About
class AboutAction extends AbstractAction
{	
	AboutAction() {super("About");}
	public void actionPerformed(ActionEvent event)
	{
		JOptionPane.showMessageDialog(null, "Maksimov Roman is author this program \n Version of program 2.0.0", "About program", 1);
	}
}