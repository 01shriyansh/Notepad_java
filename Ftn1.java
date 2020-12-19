import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;

class Ftn1 implements ActionListener
{
	Frame f,f1;
	Button b1,b2,b3,b4;
	Label l,l1;
	int number,n,s,e;
	TextField tt,t1;
	TextArea ta;
	public static String line;
	public static String pattern;
	 Pattern p;
	Matcher m;
	int flag=1;
	windowclose1 w;

	Ftn1(TextArea s,Frame fs)
	{	
		f1=fs;
		ta=s;
		line=ta.getText();
		line=line.replaceAll("\r","");
		f=new Frame();
		w=new windowclose1();
		f.addWindowListener(w);
		f.setSize(500,200);
		f.setBounds(200,200,500,200);
		f.setLayout(new GridBagLayout());
		l=new Label("Replace What: ");
		GridBagConstraints g=new GridBagConstraints();
		g.gridx=0;
		g.gridy=0;
		g.anchor=GridBagConstraints.CENTER;
		f.add(l,g);
		tt=new TextField(40);
		g.gridx=1;
		f.add(tt,g);
		b3=new Button("Replace");
		b3.addActionListener(this);
		g.gridx=2;
		f.add(b3,g);
		l1=new Label("Replace With: ");
		g.gridx=0;
		g.gridy=1;
		f.add(l1,g);
		t1=new TextField(40);
		g.gridx=1;
		f.add(t1,g);
		b1=new Button("Replace All");
		g.gridx=2;
		b1.addActionListener(this);
		f.add(b1,g);
		b2=new Button("Cancel");
		g.gridy=2;
		g.gridx=0;
		b2.addActionListener(this);
		f.add(b2,g);
		b4=new Button("Find Next");
		g.gridx=1;
		b4.addActionListener(this);
		f.add(b4,g);

		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b2)
		{
			f.setVisible(false);	
		}
		if(e.getSource()==b4)
		{
			number=ta.getCaretPosition();
			System.out.print(ta.getCaretPosition()+"\t"+line.length());
			if(number<line.length()){
			if(flag==1)
			{
				
				pattern=tt.getText();
				p=Pattern.compile(pattern);
				m=p.matcher(line);
				if(m.find(number)){	
				n=m.start();	
				System.out.println("found Value:  "+m.group()+"\t"+m.start());}
				else{System.out.println("No match");}
				ta.select(m.start(),m.end());
				f1.toFront();
				
				flag=0;
			}
			else{
		
				if(m.find()){
					n=m.start();
					ta.select(m.start(),m.end());
					f1.toFront();
				System.out.println("found Value:  "+m.group()+"\t"+m.start());}
				else{System.out.println("No match");}
				
			}}	
				
					
		}
		if(e.getSource()==b1)
		{
			if(flag==1)
			{
				
				pattern=tt.getText();
				p=Pattern.compile(pattern);
				m=p.matcher(line);
				if(m.find(number)){		
					ta.setText(m.replaceAll(t1.getText()));}
				else{
				Ftn2 notfound=new Ftn2();		f.setVisible(false);}
				flag=0;
			}
			else{
		
					
			if(m.find()){
					System.out.print("Match Found");
					
					ta.setText(m.replaceAll(t1.getText()));}
			else{
				Ftn2 not=new Ftn2();
				f.setVisible(false);}
				
			}	
				
					
		}
		if(e.getSource()==b3)
		{
				
				number=ta.getCaretPosition();
				String l=ta.getText();
				l=l.replaceAll("\r","");
				pattern=tt.getText();
				p=Pattern.compile(pattern);
				m=p.matcher(l);
				if(m.find(number)){
					ta.replaceRange(t1.getText(), m.start(), m.end());		
					
				l=ta.getText();
				l=l.replaceAll("\r","");	}	
				else
				{
				Ftn2 nost=new Ftn2();
				f.setVisible(false);}
				System.out.print(m.start()+"\t"+m.end());
				
			
		}	
	}

}	
