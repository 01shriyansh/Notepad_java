import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;

class Ftn2 
{
		Frame f;
		Label l;
		windowclose1 w;
	Ftn2()
	{
		f=new Frame();
		w=new windowclose1();
		f.addWindowListener(w);
		f.setSize(500,200);
		l=new Label(" *Match Not Found* ");
		f.add(l);
		f.setVisible(true);
	}
}