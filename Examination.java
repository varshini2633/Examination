import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
class Examination
{
    public static void main(String args[])  
    {  
        JOptionPane.showMessageDialog(null,"ONLINE EXAMINATION");
        boolean again=true;
        int ln=0;
        Another ob=new Another();
        while(again==true)
        {
            JOptionPane.showMessageDialog(null," 1.Login\n 2.Update details\n 3.Start Exam\n 4.logout\n 5.Exit");
            String option=JOptionPane.showInputDialog("Enter your option:");
            int opt=Integer.valueOf(option);
            switch(opt)
            {
                case 1:
                    ob.login();
                    ln=1;
                    break;
                case 2:
                    if(ln==1)
                    {
                        ob.updatedetails();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 3:
                    if(ln==1)
                    {
                        Online on =new Online("Online test");
                        on.actionPerformed(null);
                        on.set();
                        on.check();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 4:
                    if(ln==1)
                    {
                        ob.logout();
                        ln=0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 5:
                    again=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    break;
            }
        }
    }  
}
class Online extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;

    int m[]=new int[10];      
    Online(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Submit");  
        b1.addActionListener(this);  
        b2.addActionListener(this);
        add(b1);
        add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Submit"))
        {
            JOptionPane.showMessageDialog(this,"Do you want to submit");
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(1);
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals(""+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);   
        }  
    
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: In 'os' O stands for __________?");  
            jb[0].setText("Order");
            jb[1].setText("Open ");
            jb[2].setText("Operating ");
            jb[3].setText("Optical ");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: 'DB' computer abbrevation usually means?");  
            jb[0].setText("DataBase");
            jb[1].setText("Double Byte");
            jb[2].setText("Data Block");
            jb[3].setText("Driver Boot");  
        }  
        if(current==2)  
        {  
            l.setText("Que3:  In 'LAN' L stands for?");  
            jb[0].setText("Local");
            jb[1].setText("Land ");
            jb[2].setText("Like");
            jb[3].setText("Live");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");
            jb[1].setText("Swing");
            jb[2].setText("Applet");
            jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Byte code is executed by _________?");  
            jb[0].setText("JVM");
            jb[1].setText("JDK");
            jb[2].setText("GCC");
            jb[3].setText("g++");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("get");
            jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one among these is not a Predefined class? ");  
            jb[0].setText("Swing");
            jb[1].setText("Actionperformed");
            jb[2].setText("ActionEvent");  
            jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: which one among these is not a function of Object class?");  
            jb[0].setText("toString");
            jb[1].setText("finalize");
            jb[2].setText("equals");  
            jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: which function is not present in Applet class?");  
            jb[0].setText("init");
            jb[1].setText("main");
            jb[2].setText("start");
            jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");
            jb[1].setText("JList");
            jb[2].setText("JButtonGroup");  
            jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
}  
public class Another
{
    public String name,password,email;
    void login()
    {
        name=JOptionPane.showInputDialog("enter your Name:");
        email=JOptionPane.showInputDialog("enter your email:");
        password=JOptionPane.showInputDialog("enter your password:");
    }
    void updatedetails()
    {
        String ch;
        JOptionPane.showMessageDialog(null," Your Name: "+name+"\n Your email: "+email+"\n Your password: "+password);
        ch=JOptionPane.showInputDialog("enter your choice\n (NOTE:\n name-->1 \n email-->2 \nemail--3):");
        int choice=Integer.valueOf(ch);
        switch(choice)
        {
            case 1:
                name=JOptionPane.showInputDialog("enter your Name: ");
                JOptionPane.showMessageDialog(null," Your updated Name: "+name);
                break;
            case 2:
                email=JOptionPane.showInputDialog("enter your email: ");
                JOptionPane.showMessageDialog(null," Your updated email : "+email);
                break;
            case 3:
                password=JOptionPane.showInputDialog("enter your password:");
                JOptionPane.showMessageDialog(null," Your password: "+password);
                break;
            default:
                JOptionPane.showMessageDialog(null,"You entered invalid option");
                break;
            }
            JOptionPane.showMessageDialog(null,"UPDATED DETAILS:\n Your Name: "+name+"\n Your email: "+email+"\n Your password: "+password);
    }
    void logout()
    {
        name=null;
        password=null;
        email=null;
        JOptionPane.showMessageDialog(null,"Logged Out successfully");
    }
}