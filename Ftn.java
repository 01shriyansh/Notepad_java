import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;

class Ftn implements ActionListener
{
	Frame f1 ;
	Dialog f;
	Button b1,b2;
	Label l;
	TextField tt;
	int number,c,s;
	TextArea ta;
	public static String line;
	public static String pattern;
	 Pattern p;
	Matcher m;
	int flag=1;
	windowclose1 w;


	Ftn(TextArea s, Frame f2)
	{	
		f1 = f2;
		f = new Dialog(f1,"Find");
		ta=s;
		line=ta.getText();
		line=line.replaceAll("\r","");
		// f=new Frame();
		
		w=new windowclose1();
		f.addWindowListener(w);
		f.setSize(500,200);
		f.setBounds(200,200,500,200);
		f.setLayout(new GridBagLayout());
		l=new Label("Find What: ");
		GridBagConstraints g=new GridBagConstraints();
		g.gridx=0;
		g.gridy=0;
		g.anchor=GridBagConstraints.CENTER;
		f.add(l,g);
		tt=new TextField(40);
		g.gridx=1;
		f.add(tt,g);
		b1=new Button("Find Text");
		g.gridx=0;
		g.gridy=1;
		b1.addActionListener(this);
		f.add(b1,g);
		b2=new Button("Cancel");
		g.gridx=1;
		b2.addActionListener(this);
		f.add(b2,g);

		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b2)
		{
			f.setVisible(false);	
		}
		if(e.getSource()==b1)
		{
			number=ta.getCaretPosition();
			System.out.print(ta.getCaretPosition()+"\t"+line.length());
			 {
			if(flag==1)
			{
				System.out.println(number+"\t");
				pattern=tt.getText();
				p=Pattern.compile(pattern);
				m=p.matcher(line);
				if(m.find(number)){		
				System.out.println("found Value:  "+m.group()+"\t"+m.start());}
				else{System.out.println("No match");}
				ta.select(m.start(),m.end());
				f1.toFront();
				
				flag=0;
			}
			else{
				
				if(m.find()){
					c=ta.getCaretPosition();
					ta.select(m.start(),m.end());
					f1.toFront();
				System.out.println("found Value:  "+m.group()+"\t"+m.start());}
				else{System.out.println("No match");
					s=ta.getCaretPosition();
					
					if(s==c){
						Ftn2 not=new Ftn2();
						s=ta.getCaretPosition();
						}
					else{
						flag=1;}
					}
			
				
			}}			 	
				
					
		}	
	}

}	
