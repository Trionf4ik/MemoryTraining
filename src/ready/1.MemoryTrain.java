/** Program MemoryTrain create for brain training
@author Maksimov Roman
@version 0.2.1
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class MemoryTrain
{
	public static void main (String[] args)
	{
		StartFrame start = new StartFrame();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setVisible(true);
	}
}
class StartFrame extends JFrame
{
	public StartFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		//Определение размера экрана
		Dimension screenSize = kit.getScreenSize();
		width = defaultWidth;
		height = defaultHeight;
		setSize(width, height);
		setLocation(screenSize.width/4, screenSize.height/4);
		setTitle("MemoryTraining");
		Image icon = kit.getImage("image/icon.jpg");
		setIconImage(icon);
		label = new JLabel("Choise your level", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		add(label);
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		addButton("Easy");
		addButton("Medium");
		addButton("Hight");
	}
	/** This method add radio button on panel*/
	public void addButton (String level)
	{
		boolean isDefault = level==defaultLevel;
		JRadioButton button = new JRadioButton(level, isDefault);
		battonPanel.add(button);
		group.add(button);
		listener = new 
		ActionListenet ()
		{
			public actionPerfomed(ActionEvent event)
			{
				if (level=="Medium") label.setFont(new Font("Arial", Font.PALIT, 35));
			}
		}
	}
	buttonPanel.addActionListener(listener);
	public static final int defaultWidth = 500;
	public static final int defaultHeight = 500;
	private String defaultLevel = "Easy";
	private JPanel buttonPanel;
	private ButtonGroup group;
	private int width;
	private int height;
	private JLabel label;
}