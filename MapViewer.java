/** 
 * Vinh Le
 * 1st Period
 * Gallatin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.*;

public class MapViewer
{
	public static void main(String args[])
	{
    	new MapFrame();
	}
}

class MapFrame extends JFrame implements ActionListener, MouseListener
{
	private MapComponent component;
	private JPanel top;
	private JPanel stateSelector;
	private JPanel topFunctions;
	private JPanel capitalSearch;
	private JPanel travelLog;
	private JPanel regions;
	private String[] states;
	private JLabel titleBar;
	private JTextField input;
	private JTextField output;
	private JPanel inputLine;
	private JButton go;
	
	private ArrayList<StateFrame> stateFrames;
	private StateFrame texas;
	private StateFrame oregon;
	private StateFrame washington;
	private StateFrame california;
	private StateFrame nevada;
	private StateFrame idaho;
	private StateFrame utah;
	private StateFrame arizona;
	private StateFrame montana;
	private StateFrame wyoming;
	private StateFrame colorado;
	private StateFrame newMexico;
	private StateFrame northDakota;
	private StateFrame southDakota;
	private StateFrame nebraska;
	private StateFrame kansas;
	private StateFrame oklahoma;
	private StateFrame minnesota;
	private StateFrame iowa;
	private StateFrame missouri;
	private StateFrame arkansas;
	private StateFrame louisiana;
	private StateFrame wisconsin;
	private StateFrame illinois;
	private StateFrame indiana;
	private StateFrame michigan;
	private StateFrame ohio;
	private StateFrame pennsylvania;
	private StateFrame newYork;
	private StateFrame vermont;
	private StateFrame newHampshire;
	private StateFrame maine;
	private StateFrame massachusetts;
	private StateFrame rhodeIsland;
	private StateFrame connecticut;
	private StateFrame newJersey;
	private StateFrame delaware;
	private StateFrame maryland;
	private StateFrame westVirginia;
	private StateFrame kentucky;
	private StateFrame virginia;
	private StateFrame tennessee;
	private StateFrame northCarolina;
	private StateFrame southCarolina;
	private StateFrame mississippi;
	private StateFrame alabama;
	private StateFrame georgia;
	private StateFrame florida;
	private StateFrame hawaii;
	private StateFrame alaska;
	
	private TreeMap<String, String> capitals;
	
	private JRadioButton visit, want, never, normal;
	private ButtonGroup radioGroup;
	
	private JCheckBox west, midwest, south, northeast;

	private static String[] WEST_STATES = {"California", "Alaska", "Hawaii", "Washington", "Oregon", "Idaho",
		"Nevada", "Utah", "Montana", "Wyoming", "Colorado", "New Mexico", "Arizona"};
	private static String[] MIDWEST_STATES = {"North Dakota", "South Dakota", "Nebraska", "Kansas", "Minnesota",
		 "Iowa", "Missouri", "Wisconsin", "Michigan", "Illinois", "Indiana", "Ohio"};
	private static String[] SOUTH_STATES = {"Texas", "Oklahoma", "Arkansas", "Louisiana", "Mississippi",
		 "Tennessee", "Alabama", "Georgia", "Florida", "South Carolina", "North Carolina", "Virginia", 
		 "West Virginia", "Maryland", "Delaware", "Kentucky"};
	private static String[] NORTHEAST_STATES = {"Pennsylvania", "New York", "Vermont", "New Hampshire", "Maine",
		 "Massachusetts", "Connecticut", "Rhode Island", "New Jersey"};
	
	private static int STATEFRAME_X = 1250;
	private static int STATEFRAME_Y = 350;
	
	
	
	public MapFrame()
	{	
		capitals = new TreeMap<String, String>();
		capitals.put("Montgomery", "Alabama");
		capitals.put("Juneau", "Alaska");
		capitals.put("Phoenix", "Arizona");
		capitals.put("Little Rock", "Arkansas");
		capitals.put("Sacramento", "California");
		capitals.put("Denver", "Colorado");
		capitals.put("Hartfort", "Connecticut");
		capitals.put("Dover", "Delaware");
		capitals.put("Tallahassee", "Florida");
		capitals.put("Atlanta", "Georgia");
		capitals.put("Honolulu", "Hawaii");
		capitals.put("Boise", "Idaho");
		capitals.put("Springfield", "Illinois");
		capitals.put("Indianapolis", "Indiana");
		capitals.put("Des Moines", "Iowa");
		capitals.put("Topeka", "Kansas");
		capitals.put("Frankfort", "Kentucky");
		capitals.put("Baton Rouge", "Louisiana");
		capitals.put("Augusta", "Maine");
		capitals.put("Annapolis", "Maryland");
		capitals.put("Boston", "Massachusetts");
		capitals.put("Lansing", "Michigan");
		capitals.put("St. Paul", "Minnesota");
		capitals.put("Jackson", "Mississippi");
		capitals.put("Jefferson City", "Missouri");
		capitals.put("Helena", "Montana");
		capitals.put("Lincoln", "Nebraska");
		capitals.put("Carson City", "Nevada");
		capitals.put("Concord", "New Hampshire");
		capitals.put("Trenton", "New Jersey");
		capitals.put("Sante Fe", "New Mexico");
		capitals.put("Albany", "New York");
		capitals.put("Raleigh", "North Carolina");
		capitals.put("Bismarck", "North Dakota");
		capitals.put("Columbus", "Ohio");
		capitals.put("Oklahoma City", "Oklahoma");
		capitals.put("Salem", "Oregon");
		capitals.put("Harrisburg", "Pennsylvania");
		capitals.put("Providence", "Rhode Island");
		capitals.put("Columbia", "South Carolina");
		capitals.put("Pierre", "South Dakota");
		capitals.put("Nashville", "Tennessee");
		capitals.put("Austin", "Texas");
		capitals.put("Salt Lake City", "Utah");
		capitals.put("Montpelier", "Vermont");
		capitals.put("Richmond", "Virginia");
		capitals.put("Olympia", "Washington");
		capitals.put("Charleston", "West Virginia");
		capitals.put("Madison", "Wisconsin");
		capitals.put("Cheyenne", "Wyoming");
		
		
		
		states = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
		 "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
		  "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
		   "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
		    "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
		     "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		      "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
		 
		stateFrames = new ArrayList<StateFrame>(); 
			    
		texas = new StateFrame("Texas", this); 	   	
		stateFrames.add(texas);
		
		oregon = new StateFrame("Oregon", this); 	    	
		stateFrames.add(oregon);
		
		washington = new StateFrame("Washington", this); 	     	
		stateFrames.add(washington);
		
		california = new StateFrame("California", this); 	     	
		stateFrames.add(california);
		
		nevada = new StateFrame("Nevada", this); 	     	
		stateFrames.add(nevada);
		
		idaho = new StateFrame("Idaho", this); 	     	
		stateFrames.add(idaho);
		
		utah = new StateFrame("Utah", this); 	    	
		stateFrames.add(utah);
		
		arizona = new StateFrame("Arizona", this); 	    	
		stateFrames.add(arizona);
		
		montana = new StateFrame("Montana", this); 	     	
		stateFrames.add(montana);
		
		wyoming = new StateFrame("Wyoming", this); 	     	
		stateFrames.add(wyoming);
		
		colorado = new StateFrame("Colorado", this); 	    	
		stateFrames.add(colorado);
		
		newMexico = new StateFrame("New Mexico", this); 	     	
		stateFrames.add(newMexico);
		
		northDakota = new StateFrame("North Dakota", this); 	     	
		stateFrames.add(northDakota);
		
		southDakota = new StateFrame("South Dakota", this); 	     	
		stateFrames.add(southDakota);
		
		nebraska = new StateFrame("Nebraska", this); 	    	
		stateFrames.add(nebraska);
		
		kansas = new StateFrame("Kansas", this); 	    	
		stateFrames.add(kansas);
		
		oklahoma = new StateFrame("Oklahoma", this); 	    	
		stateFrames.add(oklahoma);
		
		minnesota = new StateFrame("Minnesota", this); 	    	
		stateFrames.add(minnesota);
		
		iowa = new StateFrame("Iowa", this); 	     	
		stateFrames.add(iowa);
		
		missouri = new StateFrame("Missouri", this); 	     	
		stateFrames.add(missouri);
		
		arkansas = new StateFrame("Arkansas", this); 	    	
		stateFrames.add(arkansas);
		
		louisiana = new StateFrame("Louisiana", this); 	    	
		stateFrames.add(louisiana);
		
		wisconsin = new StateFrame("Wisconsin", this); 	     	
		stateFrames.add(wisconsin);
		
		illinois = new StateFrame("Illinois", this); 	    	
		stateFrames.add(illinois);
		
		indiana = new StateFrame("Indiana", this); 	     	
		stateFrames.add(indiana);
		
		michigan = new StateFrame("Michigan", this); 	     	
		stateFrames.add(michigan);
		
		ohio = new StateFrame("Ohio", this); 	     	
		stateFrames.add(ohio);
		
		pennsylvania = new StateFrame("Pennsylvania", this); 	    	
		stateFrames.add(pennsylvania);
		
		newYork = new StateFrame("New York", this); 	     	
		stateFrames.add(newYork);
		
		vermont = new StateFrame("Vermont", this); 	     	
		stateFrames.add(vermont);
		
		newHampshire = new StateFrame("New Hampshire", this); 	    	
		stateFrames.add(newHampshire);
		
		maine = new StateFrame("Maine", this); 	    	
		stateFrames.add(maine);
		
		massachusetts = new StateFrame("Massachusetts", this); 	    	
		stateFrames.add(massachusetts);
		
		rhodeIsland = new StateFrame("Rhode Island", this); 	     	
		stateFrames.add(rhodeIsland);
		
		connecticut = new StateFrame("Connecticut", this); 	     	
		stateFrames.add(connecticut);
		
		newJersey = new StateFrame("New Jersey", this); 	     	
		stateFrames.add(newJersey);
		
		delaware = new StateFrame("Delaware", this); 	     	
		stateFrames.add(delaware);
		
		maryland = new StateFrame("Maryland", this); 	     	
		stateFrames.add(maryland);
		
		westVirginia = new StateFrame("West Virginia", this); 	   	
		stateFrames.add(westVirginia);
		
		kentucky = new StateFrame("Kentucky", this); 	    	
		stateFrames.add(kentucky);
		
		virginia = new StateFrame("Virginia", this); 	    	
		stateFrames.add(virginia);
		
		tennessee = new StateFrame("Tennessee", this); 	    	
		stateFrames.add(tennessee);
		
		northCarolina = new StateFrame("North Carolina", this); 	     	
		stateFrames.add(northCarolina);
		
		southCarolina = new StateFrame("South Carolina", this); 	   	
		stateFrames.add(southCarolina);
		
		mississippi = new StateFrame("Mississippi", this); 	    	
		stateFrames.add(mississippi);
		
		alabama = new StateFrame("Alabama", this); 	    	
		stateFrames.add(alabama);
		
		georgia = new StateFrame("Georgia", this); 	     	
		stateFrames.add(georgia);
		
		florida = new StateFrame("Florida", this); 	   	
		stateFrames.add(florida);
		
		hawaii = new StateFrame("Hawaii", this); 	     	
		stateFrames.add(hawaii);
		
		alaska = new StateFrame("Alaska", this); 	    	
		stateFrames.add(alaska);
		
		for(StateFrame s: stateFrames)
			s.setLocation(STATEFRAME_X, STATEFRAME_Y);
		    
		setTitle("Welcome to the United States!"); // Sets up the basic frame and draws the map
		setSize(1200, 900);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		component = new MapComponent();
		top = new JPanel(new BorderLayout());
		titleBar = new JLabel("Welcome to the United States!", JLabel.CENTER);
		titleBar.setFont(new Font("Sans Serif", Font.PLAIN, 46));
		top.add(titleBar, BorderLayout.NORTH);
		
		topFunctions = new JPanel(new GridLayout(1, 3));
		capitalSearch = new JPanel(new GridLayout(3, 1)); // putting in stuff for capital search
		capitalSearch.add(new JLabel("Capital Search:"));
		inputLine = new JPanel(new BorderLayout());
		go = new JButton("Go!");
		go.addActionListener(this);
		
		input = new JTextField("Enter a name of a capital city to see what state it is in!");
		output = new JTextField();
		output.setEditable(false);
		inputLine.add(input, BorderLayout.CENTER);
		inputLine.add(go, BorderLayout.EAST);
		capitalSearch.add(inputLine);
		capitalSearch.add(output);
		
		
		RadioButtonHandler handler = new RadioButtonHandler();
		radioGroup = new ButtonGroup();
		travelLog = new JPanel(new GridLayout(5,1));
		travelLog.add(new JLabel("Travel Log:"));
		visit = new JRadioButton("States you have visited", false);
		want = new JRadioButton("States you want to visit", false);
		never = new JRadioButton("States you haven't visited", false);
		normal = new JRadioButton("Default map", true);
		visit.addItemListener(handler);
		want.addItemListener(handler);
		never.addItemListener(handler);
		normal.addItemListener(handler);
		radioGroup.add(visit);
		radioGroup.add(want);
		radioGroup.add(never);
		radioGroup.add(normal);
		travelLog.add(visit);
		travelLog.add(want);
		travelLog.add(never);
		travelLog.add(normal);
		
		CheckBoxHandler checkHandler = new CheckBoxHandler();

		west = new JCheckBox("West");
		midwest = new JCheckBox("Midwest");
		south = new JCheckBox("South");
		northeast = new JCheckBox("Northeast");
		west.addItemListener(checkHandler);
		midwest.addItemListener(checkHandler);
		south.addItemListener(checkHandler);
		northeast.addItemListener(checkHandler);

		
		
		regions = new JPanel(new GridLayout(5,1));
		regions.add(new JLabel("Region:"));
		regions.add(west);
		regions.add(midwest);
		regions.add(south);
		regions.add(northeast);
		
		
		topFunctions.add(capitalSearch);
		topFunctions.add(travelLog);
		topFunctions.add(regions);
		
		top.add(topFunctions, BorderLayout.CENTER);
		
		stateSelector = new JPanel(new GridLayout(50,1));
		for(String state: states)
		{
			JButton temp = new JButton(state);
			stateSelector.add(temp);
			temp.addActionListener(this);
			temp.addMouseListener(this);
		}
			
		
		getContentPane().setBackground(new Color(128, 113, 113)); // Change this later to a better color


		setLayout(new BorderLayout());
		add(component, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		add(stateSelector, BorderLayout.EAST);
		setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e)
	{
		radioGroup.clearSelection();
		normal.setSelected(true);
		String buttonPressed = ((JButton)e.getSource()).getText();
		if(buttonPressed.equals("Go!"))
		{
			deselectAll();
			String city = input.getText();
			if(!capitals.containsKey(city))
				output.setText(city + " is not a capital city of the US!");
			else
			{
				String state = capitals.get(city);
				output.setText(city + " is the capital city of " + state + "!");
				for(State st: component.getStates())
					if(st.getName().equals(state))
						st.select();
			}
		}
		else
		{
			for(State state: component.getStates())
			{
				if(buttonPressed.equals(state.getName()))
					state.select();
				else
					state.deselect();
				component.repaint();
			}
			for(StateFrame s: stateFrames)
			{
				if(s.getName().equals(buttonPressed))
				{
					s.setVisible(true);
					this.setEnabled(false);
				}
					
			}
		}
		
		
			
			
	}
	
	public void deselectAll()
	{
		for(State state: component.getStates())
			state.deselect();
		component.repaint();
	}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
   	public void mouseClicked(MouseEvent event) {}
   	public void mouseEntered(MouseEvent event)
   	{
   		String buttonPressed = ((JButton)event.getSource()).getText();
   	  west.setSelected(false);
   	  midwest.setSelected(false);
   	  south.setSelected(false);
   	  northeast.setSelected(false);
   	  if(never.isSelected() || visit.isSelected() || want.isSelected())
      	{
      		normal.setSelected(true);
      		never.setSelected(false);
      		visit.setSelected(false);
      		want.setSelected(false);
      	}
		for(State state: component.getStates())
		{
			if(buttonPressed.equals(state.getName()))
				state.select();
			else
				state.deselect();
			component.repaint();
		}
   	}
   	public void mouseExited(MouseEvent event)
   	{
   		deselectAll();
   	}
   	
   	private class RadioButtonHandler implements ItemListener
   	{

      public void itemStateChanged( ItemEvent e )
      {
      west.setSelected(false);
   	  midwest.setSelected(false);
   	  south.setSelected(false);
   	  northeast.setSelected(false);
      	deselectAll();
         if ( e.getSource() == visit ) 
         {
         	for(StateFrame sf: stateFrames)
         	{
         		if(sf.getVisit() == true)
         		{	
         			for(State s: component.getStates())
					{
						if(s.getName().equals(sf.getName()))
							s.travelSelect();
					}
         		}
         	}
         }
         else if ( e.getSource() == want) 
         {
         	for(StateFrame sf: stateFrames)
         	{
         		if(sf.getWant() == true)
         		{	
					for(State s: component.getStates())
					{
						if(s.getName().equals(sf.getName()))
							s.travelSelect();
					}
         		}
         	}
         }
         else if ( e.getSource() == never) 
         {
        	for(StateFrame sf: stateFrames)
         	{
         		if(sf.getNever() == true)
         		{	
					for(State s: component.getStates())
					{
						if(s.getName().equals(sf.getName()))
							s.travelSelect();
					}
         		}
         	}
         	
         }
         else if( e.getSource() == normal)
         {
         	deselectAll();
         }
         component.repaint();
      }
   }
   	
   public String lowerCase(String s)
   {
   		String ret = "";
   		s = s.replaceAll(" ", "_");
		String[] temp = s.split(" ");
		for(int i = 0; i < temp.length; i++)
			temp[i] = temp[i].substring(0,1).toLowerCase() + temp[i].substring(1);
		for(String st: temp)
			ret += st  + " ";
		return ret.substring(0, ret.length()-1);
   }
   
   	private class CheckBoxHandler implements ItemListener
   	{
      public void itemStateChanged( ItemEvent e )
      {
      	if(never.isSelected() || visit.isSelected() || want.isSelected())
      	{
      		normal.setSelected(true);
      		never.setSelected(false);
      		visit.setSelected(false);
      		want.setSelected(false);
      	}

      	if(e.getSource() == west)
      		if(e.getStateChange() == ItemEvent.SELECTED)
      		{
      			for(String s: WEST_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.regionSelect();
      				}
      			}
      		}
      		else
      		{
      			for(String s: WEST_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.deselect();
      				}
      			}
      		}
      	else if(e.getSource() == midwest)
      		if(e.getStateChange() == ItemEvent.SELECTED)
      		{
      			for(String s:  MIDWEST_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.regionSelect();
      				}
      			}
      		}
      		else
      		{
      			for(String s: MIDWEST_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.deselect();
      				}
      			}
      		}
      	else if(e.getSource() == south)
      		if(e.getStateChange() == ItemEvent.SELECTED)
      		{
      			for(String s:  SOUTH_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.regionSelect();
      				}
      			}
      		}
      		else
      		{
      			for(String s: SOUTH_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.deselect();
      				}
      			}
      		}
      	else if(e.getSource() == northeast)
      		if(e.getStateChange() == ItemEvent.SELECTED)
      		{
      			for(String s:  NORTHEAST_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.regionSelect();
      				}
      			}
      		}
      		else
      		{
      			for(String s: NORTHEAST_STATES)
      			{
      				for(State st: component.getStates())
      				{
      					if(s.equals(st.getName()))
      						st.deselect();
      				}
      			}
      		}
      	component.repaint();
      }
   	}
}