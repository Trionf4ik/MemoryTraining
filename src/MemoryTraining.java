/** Program training brain

@author Roman Maksimov
@version 0.0.3
*/

// Connection liblraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class MemoryTraining
{
	public static void main (String[] args)
	{
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class MainFrame extends JFrame 
{
	public MainFrame ()
		{
		//Set fullscreen size
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(width, height);
		setLocation(screenSize.width/4, screenSize.height/4);
		// Set Icon and Title
		Image icon = kit.getImage("image/Icon.jpg");
		setIconImage(icon);
		setTitle("MemoryTraining");
		// add first panel
		//FirstPanel panel = new FirstPanel();
		//add(panel);
		//Button panel
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		addRadioButton("Easy");
		addRadioButton("Medium");
		addRadioButton("High");
		add(buttonPanel, BorderLayout.CENTER);
		}	
	void addRadioButton(String level)
		{
			boolean selected= defaultLevel == level;
			JRadioButton button = new JRadioButton(level, selected);
			group.add(button);
			buttonPanel.add(button);
			button.addActionListener(new
			 ActionListener()
			{	public void actionPerfomed (ActionEvent event)
				{
					if (level=="High") setBackground(Color.Red);
					//panel = setImage("image/brain_strong.jpg");
					else if (level == "Medium") setBackground(Color.BLUE);
					//panel = FirstPanel.setImage ("image/brain_middle.jpg");
					else setBackground(Color.GREEN);
					//panel = FirstPanel.setImage
	
					//add(panel, BordetLayout.SOUTH);
				}
			});
		}

	private String level;
	private String defaultLevel ="Easy";
	private JPanel buttonPanel;
	private static int width = 500;
	private static int height = 500;
	private FirstPanel panel;
	private ButtonGroup group;
}

class FirstPanel extends JPanel
{
	public FirstPanel ()
	{
		adr = "image/brain.gif";
		try
		{
		image = ImageIO.read(new File(adr));
		}
		catch (IOException e)
		{ e.printStackTrace();}
		
	}
		public FirstPanel (String adress)
	{
		this ();
		adr = adress;
	}
	static FirstPanel setImage(String adress)
	{
		adr = adress;
		return FirstPanel(adr);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, null);
		String label = "Choose your level";
		g2.setPaint(Color.WHITE);
		Font defaultFont = new Font("Serif", Font.PLAIN, fontSize);
		g2.setFont(defaultFont);
		g2.drawString(label, 150, 100);
	}
	private String adr;
	private Image image;
	private static int fontSize=29;
}

