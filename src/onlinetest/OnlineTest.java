/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinetest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;


/**
 *
 * @author Saurabh
 */
public class OnlineTest extends WindowAdapter implements ActionListener {
        Frame f;
	Label l,l2;
        Checkbox cb1,cb2,cb3,cb4,cb5;
        CheckboxGroup cg;
        Panel p;
        Button b2,b1;
        int count = 0,current=0,x=1,y=1,now=0;
        int m[] = new int[10];
        
        OnlineTest()
        {
            f  = new Frame("Test");
            GridLayout gl = new GridLayout(6,1);
            f.setLayout(gl);
            f.setVisible(true);
            f.setSize(400,400);
            l = new Label();
            f.add(l);
            cg = new CheckboxGroup();
            cb1 = new Checkbox("",cg,false);
            cb2 = new Checkbox("",cg,false);
            cb3 = new Checkbox("",cg,false);
            cb4 = new Checkbox("",cg,false);
            f.add(cb1);
            f.add(cb2);
            f.add(cb3);
            f.add(cb4);
            p = new Panel();
            p.setLayout(new GridLayout(1,1));
            //b1 = new Button("Previous");
            b2 = new Button("Next");
            //p.add(b1); 
            p.add(b2);
            f.add(p);
            //b1.addActionListener(this);
            b2.addActionListener(this);
            set();
        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b2)
            {
                if(check())
                    count++;
                current++;
                set();
               
                if(current==9)
                {
                    b2.setLabel("Result");
                }
              //   b1.setEnabled(true);
            }
            
            /*if(e.getSource()==b1)
            {
                current--;
                set();
                  b2.setLabel("Next");
                if(current==0)
                b1.setEnabled(false);
            }
            */
            if(e.getActionCommand().equals("Result"))
            {
                if(check())
                    count++;
                current++;
                Dialog d1 = new Dialog(f,"find");
               d1.setLayout(new FlowLayout());
	        d1.addWindowListener(this);
	    	d1.setSize(350,150);
	        d1.setResizable(false);
	         d1.setLocationRelativeTo(null);
                 b1 = new Button("OK");
                 b1.addActionListener(this);
                  l2 = new Label("Correct Ans = "+count);
                  d1.add(l2);
                 d1.add(b1);
                  d1.setVisible(true);
                  
                
                
            }
            if(e.getSource()==b1)
                System.exit(0);
        }
        
    public static void main(String[] args) {
        OnlineTest ot = new OnlineTest();
        // TODO code application logic here
    }

    boolean check() {
       	        if(current==0)
			return(cb2.getState());
		if(current==1)
			return(cb3.getState());
		if(current==2)
			return(cb4.getState());
		if(current==3)
			return(cb1.getState());
		if(current==4)
			return(cb3.getState());
		if(current==5)
			return(cb3.getState());
		if(current==6)
			return(cb2.getState());
		if(current==7)
			return(cb4.getState());
		if(current==8)
			return(cb2.getState());
		if(current==9)
			return(cb3.getState());
		return false;
    }
    
    void set()
    {
        if(current==0)
		{
			l.setText("Que1: Which one among these is not a datatype");
			cb1.setLabel("int");cb2.setLabel("Float");cb3.setLabel("boolean");cb4.setLabel("char");	
		}
		if(current==1)
		{
			l.setText("Que2: Which class is available to all the class automatically");
			cb1.setLabel("Swing");cb2.setLabel("Applet");cb3.setLabel("Object");cb4.setLabel("ActionEvent");
		}
		if(current==2)
		{
			l.setText("Que3: Which package is directly available to our class without importing it");
			cb1.setLabel("swing");cb2.setLabel("applet");cb3.setLabel("net");cb4.setLabel("lang");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			cb1.setLabel("lang");cb2.setLabel("Swing");cb3.setLabel("Applet");cb4.setLabel("awt");
		}
		if(current==4)
		{
			l.setText("Que5: Which institute is best for java coaching");
			cb1.setLabel("Utek");cb2.setLabel("Aptech");cb3.setLabel("SSS IT");cb4.setLabel("jtek");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			cb1.setLabel("class");cb2.setLabel("int");cb3.setLabel("get");cb4.setLabel("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			cb1.setLabel("Swing");cb2.setLabel("Actionperformed");cb3.setLabel("ActionEvent");cb4.setLabel("Button");
		}
		if(current==7)
		{
			l.setText("Que8: which one among these is not a function of Object class");
			cb1.setLabel("toString");cb2.setLabel("finalize");cb3.setLabel("equals");cb4.setLabel("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que9: which function is not present in Applet class");
			cb1.setLabel("init");cb2.setLabel("main");cb3.setLabel("start");cb4.setLabel("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component");
			cb1.setLabel("JButton");cb2.setLabel("JList");cb3.setLabel("JButtonGroup");cb4.setLabel("JTextArea");
		}
    }
}
