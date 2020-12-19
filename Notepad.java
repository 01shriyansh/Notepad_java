import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import java.io.*;
class Notepad extends WindowAdapter implements ActionListener 
{
	Frame f;
	MenuBar mb;
	Menu m1,m2;
	MenuItem nw,opn,sve,ext,svas,fd,fdas;
	CheckboxMenuItem bld,itlc;
	TextArea t;
	String d,file,tocheak,text;
	File f1;
	int flag,set,flag2;
	FileDialog d2,d1;
	Dialog d4,d3,d5;
	Button b1,b2,b3,b7,b8,b9,b4,b5,b6;
	

	public Notepad() 
	{
		f=new Frame();
		f.setSize(400,400);
		t=new TextArea();
		f.add(t);
		flag=0;
		mb=new MenuBar();
		m1=new Menu("File");
		m2=new Menu("Edit");
		tocheak=t.getText();
		f.addWindowListener(this);
		nw=new MenuItem("New");
		opn=new MenuItem("Open");
		sve=new MenuItem("save");
		ext=new MenuItem("Exit");
		svas=new MenuItem("Save As");
		fd=new MenuItem("Find");
		fdas=new MenuItem("Find & Replace");
		nw.addActionListener(this);
		opn.addActionListener(this);
		sve.addActionListener(this);
		ext.addActionListener(this);		
		svas.addActionListener(this);
		fd.addActionListener(this);
		fdas.addActionListener(this);
		
		
		
		m2.add(fd);
		m2.add(fdas);
		
	
		m1.add(nw);
		m1.add(opn);
		m1.add(sve);
		m1.add(svas);
		m1.addSeparator();
		m1.add(ext);
		mb.add(m1);
		mb.add(m2);
	
		f.setMenuBar(mb);
		f.setVisible(true);
	
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		System.out.println(str+" was clicked");
		if(e.getSource()==ext)
		{
			text=t.getText();
			System.out.print(text.equals(tocheak));
			if(text.equals(tocheak))
			{
			System.exit(1);}
			else
			{
				ftn2();
				}
		
		}
		if(e.getSource()==fd)
		{
			Ftn fun=new Ftn(t,f);
		}
		if(e.getSource()==fdas)
		{
			Ftn1 g=new Ftn1(t,f);
		}
		if(e.getSource()==sve)
		{
			
			if(flag==0)
			{
				Saveas();
				
			}
			else
			{
				tocheak=t.getText();
				savefile();	
			}
		}
		if(e.getSource()==svas)
		{
			Saveas();
		}
		if(e.getSource()==opn)
		{
			
			text=t.getText();	
			System.out.print(tocheak+"	"+text);
			System.out.print(text.equals(tocheak));
			if(text.equals(tocheak))
			{
			opendialog();
			}
			else
			{
				ftn();
			}
			

		}
		if(e.getSource()==nw)
		{
			text=t.getText();
			System.out.print(text.equals(tocheak));
			if(text.equals(tocheak)){
				file="united";
				d=System.getProperty("user.dir");
				f.setTitle(file);
				flag=0;
				t.setText("");
				tocheak=t.getText();}
			else
			{
				d3=new Dialog(f,file);
				d3.setLayout(new GridBagLayout());
				d3.setSize(500,200);
				GridBagConstraints g=new GridBagConstraints();
				Label l3=new Label("Do you want to save changes.?");
				g.gridx=0;
				g.gridy=0;
				d3.add(l3,g);
				b4=new Button("Save");
				b4.addActionListener(this);
				g.gridy=1;	
				d3.add(b4,g);
				b5=new Button("Don't Save");
				b5.addActionListener(this);
				g.gridx=1;	
				d3.add(b5,g);
				b6=new Button("Cancel");
				b6.addActionListener(this);
				g.gridx=2;	
				d3.add(b6,g);
				d3.setVisible(true);
			}
		}
		if(e.getSource()==b1)
		{
			d5.setVisible(false);
			if(flag==0)
			{
				Saveas();
			}
			else{
				savefile();	
			System.exit(1);}	
		}
		if(e.getSource()==b2)
		{
			d5.setVisible(false);
			
			System.exit(1);
			
		}
		if(e.getSource()==b3)
		{	
			d5.setVisible(false);
		}
		if(e.getSource()==b4)
		{
			
			d3.setVisible(false);
			if(flag==0)
			{
				set=1;
				Saveas();
				file="united";
				d=System.getProperty("user.dir");
				f.setTitle(file);
				
			}
			else{
					
				savefile();	
				file="united";
				d=System.getProperty("user.dir");
				f.setTitle(file);	
				t.setText("");
				tocheak=t.getText();	
				flag=0;}
		}
		if(e.getSource()==b5)
		{
			d3.setVisible(false);
			t.setText("");
			tocheak=t.getText();
			file="united";
				d=System.getProperty("user.dir");
				flag=0;
				f.setTitle(file);
		}
		if(e.getSource()==b6)
		{	
			d3.setVisible(false);
		}	
		if(e.getSource()==b7)
		{
			
			d4.setVisible(false);
			if(flag==0)
			{
				flag2=1;
				Saveas();
			}
			else{
				flag=1;	
				savefile();
				opendialog();
				tocheak=t.getText();}
		}
		if(e.getSource()==b9)
		{
			d4.setVisible(false);
		}
		if(e.getSource()==b8)
		{
			d4.setVisible(false);
			opendialog();
		}
	}
	
	public static void main(String args[])
	{
		Notepad n=new Notepad();
		
	}
	
	public void savefile()
	{
		String c=t.getText();
		char arr[];
		arr=c.toCharArray();	
		System.out.print(d+file);
			f1=new File(d,file);
			f.setTitle(file);
			try{
				FileOutputStream fos=new FileOutputStream(f1);
				
					for (int i = 0; i < arr.length; i++)
					{
    						fos.write(arr[i]);
					}
				fos.close();
			}
			catch(IOException e2)
			{
			System.out.println(e2.getMessage());
			}
	}
	public void Saveas()
	{
			
				
				d2=new FileDialog(f,"Save As",FileDialog.SAVE);
				
				d2.setVisible(true);
				String c=t.getText();
				char arr[];
				arr=c.toCharArray();	
				
				String dp=d2.getDirectory();

				if(dp==null){
						System.out.print("return null");	
					}
				else{
				tocheak=t.getText();
				file=d2.getFile();
				file=file+".txt";
				d=d2.getDirectory();
				f.setTitle(file);
				f1=new File(d,file);
					System.out.println(d+file);
				
				
					try{	
						flag=1;
						FileOutputStream fos=new FileOutputStream(f1);
						
							for (int i = 0; i < arr.length; i++)
							{
    								fos.write(arr[i]);
							}
							fos.close();
					}
					catch(IOException e1)
					{
						System.out.println(e1.getMessage());
					}
				if(set==1){
					t.setText("");
					tocheak=t.getText();
					set=0;}
				}
				if(flag2==1)
				{	opendialog();
				}
	}
	
	public void opendialog()
	{
				
				flag2=0;
				d1=new FileDialog(f,"Open",FileDialog.LOAD);
				d1.setVisible(true);
				String fi=d1.getDirectory();
				if(fi==null){
					System.out.print("returns null");
				}
			else{
				
				flag=1;
				file=d1.getFile();
				d=d1.getDirectory();
				f.setTitle(file);
				f1=new File(d,file);
				
				try{
				FileInputStream fis1=new FileInputStream(f1);
				int ch;
				t.setText(" ");
				while((ch=fis1.read())!=-1)			
					t.appendText(Character.toString((char)ch));
				
				tocheak=t.getText();	
				fis1.close();	
				}
				catch(IOException e1)
				{
				System.out.println(e1.getMessage());
				}
				tocheak=t.getText();	
			}
	} 
	public void ftn(){
				d4=new Dialog(f,file);
				d4.setLayout(new GridBagLayout());
				d4.setSize(500,200);
				GridBagConstraints g=new GridBagConstraints();
				Label l4=new Label("Do you want to save changes.?");
				g.gridx=0;
				g.gridy=0;
				d4.add(l4,g);
				b7=new Button("SAVE");
				b7.addActionListener(this);
				g.gridy=1;	
				d4.add(b7,g);
				b8=new Button("Don't Save");
				b8.addActionListener(this);
				g.gridx=1;	
				d4.add(b8,g);
				b9=new Button("Cancel");
				b9.addActionListener(this);
				g.gridx=2;	
				d4.add(b9,g);
				d4.setVisible(true);	
			
	}

	public void ftn2()
	{
	
				if(text.equals(tocheak)){ System.exit(1);}
				else
				{
					d5=new Dialog(f,file);
				d5.setLayout(new GridBagLayout());
				d5.setSize(500,200);
				GridBagConstraints g=new GridBagConstraints();
				Label l3=new Label("Do you want to save changes.?");
				g.gridx=0;
				g.gridy=0;
				d5.add(l3,g);
				b1=new Button("Save");
				b1.addActionListener(this);
				g.gridy=1;	
				d5.add(b1,g);
				b2=new Button("Don't Save");
				b2.addActionListener(this);
				g.gridx=1;	
				d5.add(b2,g);
				b3=new Button("Cancel");
				b3.addActionListener(this);
				g.gridx=2;	
				d5.add(b3,g);
				d5.setVisible(true);
				}					
				
	}
			
		public void windowClosing(WindowEvent e)
		{
			text=t.getText();
			System.out.print(text.equals(tocheak));
			if(text.equals(tocheak))
			{Window w=e.getWindow();
			w.setVisible(false);
			w.dispose();
			System.exit(1);}
			else
			{
				ftn2();
				}
			
		
		}
}	
	
	