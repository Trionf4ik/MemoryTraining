/** Program MemoryTrain it's a second step to create program "MemoryTraining"
@author Maksimov Roman
@version 0.2.3
*/
/** Подключение библиотек */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


/** Управляющий класс программы */
public class MemoryTrain
{
	public static void main (String[] args)
	{
		StartFrame start = new StartFrame();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setVisible(true);
	}
}

/** Создание рабочего окна программы*/
class StartFrame extends JFrame
{
/** Конструктор класса создающего фрейм*/
	public StartFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		//Определение размера экрана
		Dimension screenSize = kit.getScreenSize();
		
		width = defaultWidth;
		height = defaultHeight;
		// Размер окна
		setSize(width, height);
		// Позиция вывода окна
		setLocation(screenSize.width/4, screenSize.height/4);
		// Название окна
		setTitle("MemoryTraining");
		
		Image icon = kit.getImage("image/icon.jpg");
		setIconImage(icon);
		//Вывод панели с изображением 1 из 3-х;
		PaintImage panel = start();
		// Добавление панели к главному фрейму
		add(panel, BorderLayout.CENTER);
		
	}
	
/** Метод выводящий панель с произвольным фоновым изображением*/
	public PaintImage start()
		{
		double random = Math.random();
		if (random >0.66) {PaintImage paint = new PaintImage("image/brain_strong.jpg"); return paint;}
		else if (random> 0.33) {PaintImage paint = new PaintImage("image/brain_middle.jpg");return paint;}
		PaintImage paint = new PaintImage("image/brain.gif");
		return paint;
		}
	
/** Внутренний класс панели с фоновым изображением */
	class PaintImage extends JPanel
	{
/** Конструктор панели*/
	 public PaintImage(String adress)
	 {	
		label = new JLabel("Choise your level", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		add(label);
		
		try
		{
		mediumImg = ImageIO.read(new File(adress));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
/** Метод перерисовующий изображение на панели 
 Этот метод переопределяет базовый метод JPanel*/
		public void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		if (mediumImg ==null) {return;}
		g.drawImage(mediumImg, 0, 0, null);
		}
	
	}
	
	public static final int defaultWidth = 500;
	public static final int defaultHeight = 500;
	private Image mediumImg;
	private String defaultLevel = "Easy";
	private Image backgroundImage;
	private PaintImage panel;
	private int width;
	private int height;
	private JLabel label;
}