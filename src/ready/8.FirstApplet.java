/** Мой первый апплет на Java 
@author Maksimov Roman
@version 1.0.0
*/
import javax.swing.*;

public class FirstApplet extends JApplet
{
	public void init()
	{
	JLabel label = new JLabel("This is the first applet by Maksimov Roman!", JLabel.CENTER);
	add(label);
	}
}