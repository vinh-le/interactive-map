/** 
 * Vinh Le
 * 1st Period
 * Gallatin
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

/**
 * MapComponent is the central canvas for the MapFrame that is responsible for drawing the map and any change in colors/selections
 */
public class MapComponent extends JComponent
{
	//ivate Image backgroundMap;
	private State texas; // each state is its own object and is drawn individually
	private State oregon;
	private State washington;
	private State california;
	private State nevada;
	private State idaho;
	private State utah;
	private State arizona;
	private State montana;
	private State wyoming;
	private State colorado;
	private State newMexico;
	private State northDakota;
	private State southDakota;
	private State nebraska;
	private State kansas;
	private State oklahoma;
	private State minnesota;
	private State iowa;
	private State missouri;
	private State arkansas;
	private State louisiana;
	private State wisconsin;
	private State illinois;
	private State indiana;
	private State michigan;
	private State ohio;
	private State pennsylvania;
	private State newYork;
	private State vermont;
	private State newHampshire;
	private State maine;
	private State massachusetts;
	private State rhodeIsland;
	private State connecticut;
	private State newJersey;
	private State delaware;
	private State maryland;
	private State westVirginia;
	private State kentucky;
	private State virginia;
	private State tennessee;
	private State northCarolina;
	private State southCarolina;
	private State mississippi;
	private State alabama;
	private State georgia;
	private State florida;
	private State hawaii;
	private State alaska;
	private ArrayList<State> states;
	
	public static final int X_SHIFT = 150; //keep to shift entire map around if needed
	public static final int Y_SHIFT = 125;
	
	/**
	 * Constructs the component
	 */
	public MapComponent()
	{
//		try														
//		{
//			URL url = getClass().getResource("/default/map.png");
//			backgroundMap = ImageIO.read(url);
//		}
//		catch(Exception e)
//		{
//		}
		states = new ArrayList<State>(); // instantiation of all states
		texas = new State("texas");
		oregon = new State("oregon");
		washington = new State("washington");
		california = new State("california");
		nevada = new State("nevada");
		idaho = new State("idaho");
		utah = new State("utah");
		arizona = new State("arizona");
		montana = new State("montana");
		wyoming = new State("wyoming");
		colorado = new State("colorado");
		newMexico = new State("new_mexico");
		northDakota = new State("north_dakota");
		southDakota = new State("south_dakota");
		nebraska = new State("nebraska");
		kansas = new State("kansas");
		oklahoma = new State("oklahoma");
		minnesota = new State("minnesota");
		iowa = new State("iowa");
		missouri = new State("missouri");
		arkansas = new State("arkansas");
		louisiana = new State("louisiana");
		wisconsin = new State("wisconsin");
		illinois = new State("illinois");
		indiana = new State("indiana");
		michigan = new State("michigan");
		ohio = new State("ohio");
		pennsylvania = new State("pennsylvania");
		newYork = new State("new_york");
		vermont = new State("vermont");
		newHampshire = new State("new_hampshire");
		maine = new State("maine");
		massachusetts = new State("massachusetts");
		rhodeIsland = new State("rhode_island");
		connecticut = new State("connecticut");
		newJersey = new State("new_jersey");
		delaware = new State("delaware");
		maryland = new State("maryland");
		westVirginia = new State("west_virginia");
		kentucky = new State("kentucky");
		virginia = new State("virginia");
		tennessee = new State("tennessee");
		northCarolina = new State("north_carolina");
		southCarolina = new State("south_carolina");
		mississippi = new State("mississippi");
		alabama = new State("alabama");
		georgia = new State("georgia");
		florida = new State("florida");
		hawaii = new State("hawaii");
		alaska = new State("alaska");
		
		
		states.add(texas); // add all states to ArrayList to be accessed in MapViewer
		states.add(oregon);
		states.add(washington);
		states.add(california);
		states.add(nevada);
		states.add(idaho);
		states.add(utah);
		states.add(arizona);
		states.add(montana); 
		states.add(wyoming);
		states.add(colorado);
		states.add(newMexico);
		states.add(northDakota);
		states.add(southDakota);
		states.add(nebraska);
		states.add(kansas);
		states.add(oklahoma);
		states.add(minnesota);
		states.add(iowa);
		states.add( missouri);
		states.add(arkansas); 
		states.add(louisiana); 
		states.add(wisconsin); 
		states.add(illinois); 
		states.add(indiana);
		states.add(michigan);
		states.add(ohio); 
		states.add(pennsylvania); 
		states.add(newYork); 
		states.add(vermont); 
		states.add(newHampshire); 
		states.add(maine); 
		states.add(massachusetts); 
		states.add(rhodeIsland); 
		states.add(connecticut); 
		states.add(newJersey); 
		states.add(delaware); 
		states.add(maryland);
		states.add(westVirginia); 
		states.add(kentucky); 
		states.add(virginia); 
		states.add(tennessee); 
		states.add(northCarolina); 
		states.add(southCarolina);
		states.add(mississippi); 
		states.add(alabama);
		states.add(georgia); 
		states.add(florida); 
		states.add(hawaii); 
		states.add(alaska);
	}
	
	/**
	 * Calls the UI delegate's paint method, if the UI delegate is non-null. 
	 * We pass the delegate a copy of the Graphics object to protect the rest
	 * of the paint code from irrevocable changes (for example, Graphics.translate).
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//g2.drawImage(backgroundMap, 0, 0, null);
		
		texas.draw(g2, 254+X_SHIFT, 279+Y_SHIFT);
		
		oregon.draw(g2, 40+X_SHIFT, 50+Y_SHIFT);
		washington.draw(g2, 66+X_SHIFT, 8+Y_SHIFT);
		california.draw(g2, 28+X_SHIFT, 125+Y_SHIFT);
		nevada.draw(g2, 81+X_SHIFT, 138+Y_SHIFT);
		idaho.draw(g2, 135+X_SHIFT, 25+Y_SHIFT);
		utah.draw(g2, 157+X_SHIFT, 158+Y_SHIFT);
		arizona.draw(g2, 130+X_SHIFT, 248+Y_SHIFT);
		montana.draw(g2, 170+X_SHIFT, 26+Y_SHIFT);
		wyoming.draw(g2, 211+X_SHIFT, 109+Y_SHIFT);
		colorado.draw(g2, 229+X_SHIFT, 186+Y_SHIFT);
		newMexico.draw(g2, 215+X_SHIFT, 260+Y_SHIFT);
		northDakota.draw(g2, 314+X_SHIFT, 49+Y_SHIFT);
		southDakota.draw(g2, 310+X_SHIFT, 104+Y_SHIFT);
		nebraska.draw(g2, 307+X_SHIFT, 157+Y_SHIFT);
		kansas.draw(g2, 330+X_SHIFT, 215+Y_SHIFT);
		oklahoma.draw(g2, 316+X_SHIFT, 269+Y_SHIFT);
		minnesota.draw(g2, 403+X_SHIFT, 50+Y_SHIFT);
		iowa.draw(g2, 409+X_SHIFT, 150+Y_SHIFT);
		missouri.draw(g2, 424+X_SHIFT, 205+Y_SHIFT);
		arkansas.draw(g2, 439+X_SHIFT, 278+Y_SHIFT);
		louisiana.draw(g2, 448+X_SHIFT, 344+Y_SHIFT);
		wisconsin.draw(g2, 458+X_SHIFT, 87+Y_SHIFT);
		illinois.draw(g2, 482+X_SHIFT, 166+Y_SHIFT);
		indiana.draw(g2, 534+X_SHIFT, 175+Y_SHIFT);
		michigan.draw(g2, 492+X_SHIFT, 73+Y_SHIFT);
		ohio.draw(g2, 573+X_SHIFT, 163+Y_SHIFT);
		pennsylvania.draw(g2, 628+X_SHIFT, 148+Y_SHIFT);
		newYork.draw(g2, 636+X_SHIFT, 88+Y_SHIFT);
		vermont.draw(g2, 711+X_SHIFT, 82+Y_SHIFT);
		newHampshire.draw(g2, 730+X_SHIFT, 75+Y_SHIFT);
		maine.draw(g2, 738+X_SHIFT, 29+Y_SHIFT);
		massachusetts.draw(g2, 720+X_SHIFT, 118+Y_SHIFT);
		rhodeIsland.draw(g2, 745+X_SHIFT, 136+Y_SHIFT);
		connecticut.draw(g2, 721+X_SHIFT, 136+Y_SHIFT);
		newJersey.draw(g2, 705+X_SHIFT, 158+Y_SHIFT);
		delaware.draw(g2, 699+X_SHIFT, 188+Y_SHIFT);
		maryland.draw(g2, 651+X_SHIFT, 190+Y_SHIFT);
		westVirginia.draw(g2, 611+X_SHIFT, 196+Y_SHIFT);
		kentucky.draw(g2, 518+X_SHIFT, 223+Y_SHIFT);
		virginia.draw(g2, 608+X_SHIFT, 204+Y_SHIFT);
		tennessee.draw(g2, 507+X_SHIFT, 263+Y_SHIFT);
		northCarolina.draw(g2, 594+X_SHIFT, 249+Y_SHIFT);
		southCarolina.draw(g2, 610+X_SHIFT, 288+Y_SHIFT);
		mississippi.draw(g2, 488+X_SHIFT, 304+Y_SHIFT);
		alabama.draw(g2, 536+X_SHIFT, 300+Y_SHIFT);
		georgia.draw(g2, 575+X_SHIFT, 296+Y_SHIFT);
		florida.draw(g2, 552+X_SHIFT, 369+Y_SHIFT);
		hawaii.draw(g2, 16+X_SHIFT, 390+Y_SHIFT);
		alaska.draw(g2, 57+X_SHIFT, 394+Y_SHIFT);
	}
	
	public ArrayList<State> getStates()
	{
		return states;
	}
}