import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
class MultimediaApplet extends JApplet
{
	public void init()
	{
		getAudioClip(getCodeBase(), "Bread.mp4");
	}
}