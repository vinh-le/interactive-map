import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StateFrame extends JFrame implements ActionListener
{
	private String name;
	private JPanel content;
	private JPanel radioButtons;
	private JLabel selection;
	private JRadioButton visit, want, never;
	private boolean visited;
	private boolean wantToVisit;
	private boolean neverBeen;
	private JButton doneButton;
	private MapFrame frame;
	private JLabel message;
	private ButtonGroup radioGroup;
	private State state;
	
	public StateFrame(String n, MapFrame f)
	{
		name = n;
		setTitle(name);
		setSize(500,200);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				
		visited = false;
		wantToVisit = false;
		neverBeen = true;
		
		message = new JLabel("Welcome to the great state of " + name + "!", JLabel.CENTER);
		message.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		selection = new JLabel("Please select one of the following:");
			
		radioButtons = new JPanel(new FlowLayout());
		visit = new JRadioButton("Have visited this state", false);
		want = new JRadioButton("Want to visit this state", false);
		never = new JRadioButton("Have never been to this state", true);
		
		radioButtons.add(visit);
		radioButtons.add(want);
		radioButtons.add(never);
		
     	RadioButtonHandler handler = new RadioButtonHandler();
      	visit.addItemListener(handler);
      	want.addItemListener(handler);
      	never.addItemListener(handler);

      	radioGroup = new ButtonGroup();
      	radioGroup.add(visit);
      	radioGroup.add(want);
      	radioGroup.add(never);
		
		content = new JPanel(new BorderLayout());
		content.add(selection, BorderLayout.NORTH);
		content.add(radioButtons, BorderLayout.CENTER);
		
		frame = f;
		doneButton = new JButton("Done");
		doneButton.addActionListener(this);
		setLayout(new BorderLayout());
		add(doneButton, BorderLayout.SOUTH);
		add(message, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);
		state = null;

	}
	
	public String getName()
	{
		return name;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String buttonPressed = ((JButton)e.getSource()).getText();
		if(buttonPressed.equals("Done"))
		{
			frame.setEnabled(true);
			setVisible(false);
			frame.deselectAll();	
		}	
			
	}
	
	public void setVisit(boolean b)
	{
		visited = b;
	}
	
	public void setWant(boolean b)
	{
		wantToVisit = b;
	}
	
	public void setNever(boolean b)
	{
		neverBeen = b;
	}
	
	public boolean getVisit()
	{
		return visited;
	}
	
	public boolean getWant()
	{
		return wantToVisit;
	}
	
	public boolean getNever()
	{
		return neverBeen;
	}
	
	private class RadioButtonHandler implements ItemListener {
      public void itemStateChanged( ItemEvent e )
      {
         if ( e.getSource() == visit ) 
         {
         	setVisit(true);
         	setWant(false);
         	setNever(false);
         }
         else if ( e.getSource() == want) 
         {
         	setVisit(false);
         	setWant(true);
         	setNever(false);
         }
         else if ( e.getSource() == never) 
         {
         	setVisit(false);
         	setWant(false);
         	setNever(true);
         }
      }
   }
	
}

