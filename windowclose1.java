import java.awt.*;
import java.awt.event.*;
import java.io.*;
class windowclose1 extends WindowAdapter
	{

		
		public void windowClosing(WindowEvent e)
		{
			Window w=e.getWindow();
			w.setVisible(false);
			w.dispose();
			
		}
	}