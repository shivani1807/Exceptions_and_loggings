
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

import javax.swing.*;
/*
<applet code=”appcal” width=450 height=300>
</applet>
*/
public class Construction extends Applet implements ActionListener {
private static Logger log=Logger.getLogger(Construction.class.getName());
//private static final long serialVersionUID = 1L;
JButton b1;
JTextField t1,t2,t3,t4;
JLabel l1,l2,l3;
JPanel p;
public void init()
{
// TODO start asynchronous download of heavy resources

l1=new JLabel("material standard");
l2=new JLabel("total area");
l3=new JLabel("fully automated");
b1=new JButton("calculate cost");

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();

this.setLayout(new GridLayout(4,2));
this.add(l1);
this.add(t1);
this.add(l2);
this.add(t2);
this.add(l3);
this.add(t3);
this.add(b1);
this.add(t4);
b1.addActionListener(this);
log.info("application successfully created");


}
public void actionPerformed(ActionEvent ae)
{
	try {

	

	
String materialstandard;
double totalarea,totalcost=0.0;
int constructioncost;
String automated;
materialstandard=t1.getText();
totalarea=Double.parseDouble(t2.getText());
automated=t3.getText().toLowerCase();

if (ae.getSource()==b1)
{
if(materialstandard!="standard" || materialstandard!="above standard" || materialstandard!="high standard") {
	log.warning("incorrect material standard");
}

if(materialstandard.equals("standard")) {
constructioncost=1200;
totalcost=constructioncost*totalarea;
}
else if(materialstandard.equals("above standard")) {
constructioncost=1500;
totalcost=constructioncost*totalarea;
}
else if(materialstandard.equals("high standard")) {
constructioncost=1800;
totalcost=constructioncost*totalarea;
}
else if(materialstandard.equals("high standard") && (automated.equals("yes") || automated.equals("true"))) {
constructioncost=2500;
totalcost=constructioncost*totalarea;
}
//log.fine("construction cost is"+totalcost);
t4.setText(Double.toString(totalcost));
}
	}
	catch(Exception e) {
	Object logger;
	log.warning("error");
		
	}
}

}

