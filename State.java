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

public class State
{
	private String file;
	private Image state;
	private String name;
	
	public State(String fileName)
	{
		name = "";
		file = fileName;
		String fileLoc = String.format("/default/%s.png", fileName);
		
		try														
		{
			URL url = getClass().getResource(fileLoc);
			state = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
		
		fileName = fileName.replaceAll("_", " ");
		String[] temp = fileName.split(" ");
		for(int i = 0; i < temp.length; i++)
			temp[i] = temp[i].substring(0,1).toUpperCase() + temp[i].substring(1);
		for(String s: temp)
			name += s  + " ";
		name = name.substring(0, name.length()-1);
	}
	
	public void draw(Graphics2D g2, int x, int y)
	{
		g2.drawImage(state, x, y, null);
	}
	
	public Image getImage()
	{
		return state;
	}
	
	public void select()
	{
		String fileLoc = String.format("/selected/%s.png", file);
		
		try														
		{
			URL url = getClass().getResource(fileLoc);
			state = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	public void deselect()
	{
		String fileLoc = String.format("/default/%s.png", file);
		
		try														
		{
			URL url = getClass().getResource(fileLoc);
			state = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	public void travelSelect()
	{
		String fileLoc = String.format("/travelLog/%s.png", file);
		
		try														
		{
			URL url = getClass().getResource(fileLoc);
			state = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	public void regionSelect()
	{
		String fileLoc = String.format("/region/%s.png", file);
		
		try														
		{
			URL url = getClass().getResource(fileLoc);
			state = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	public String getName()
	{
		return name;
	}
}