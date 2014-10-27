



/*Match Game Card Program Example



						Written by
					  Jennifer Bailey
					    10/27/2014
					    
Description: This program will deal two random face down cards.
When the cards are clicked they will turn face up
*/

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class CardProgramExample
{

	public static void main(String[] args)
	{
		 EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new PonyFrame();
               frame.setTitle("Make Ponys Angry!");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
	}
}
	
class PonyFrame extends JFrame
{
	public PonyFrame()
	{
		add(new PonyPanel());
		pack();
	}
}
	
	class PonyPanel extends JPanel implements MouseListener
	{

		PonyCard cards[] = new PonyCard[4];
		
		public PonyPanel()
		{
			for(int i = 0; i < cards.length; i++)
			{
				System.out.println("Making card");
				cards[i] = new PonyCard();
			}
			this.addMouseListener(this);
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			Graphics2D g2D = (Graphics2D)g;
			
			for(int i = 0; i < cards.length; i++)
			{
				
				g2D.drawImage(cards[i].displayImage(),
						i*125,125,125,125,null);
				cards[i].setX(i*125);
				cards[i].setY(125);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			System.out.println("The mouse was pressed!");
			for(int i = 0; i < cards.length; i++)
			{
				if(cards[i].contains(e.getX(), e.getY()))
				{
					cards[i].setFaceUp(true);
				}
			}
			
			repaint();
		}
		
		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(800,800);
		
		}
		


		@Override
		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

	

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseClicked(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
class PonyCard 
{
	private int x;
	private int y;
	private Image faceUpImage;
	private Image faceDownImage;
	private boolean isFaceUp;

	public PonyCard()
	{
		x = 0;
		y = 0;
		faceUpImage = new ImageIcon("PonyCard1.png").getImage();
		faceDownImage = new ImageIcon("CardBack.jpg").getImage();
		isFaceUp = false;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

	
	public boolean isFaceUp()
	{
		return isFaceUp;
	}
	
	public Image displayImage()
	{
		System.out.println("in display image");
		if(isFaceUp)
		{
				return faceUpImage;
		}
		else
		{
			System.out.println("returning faceDownImage" + faceDownImage.getWidth(null));
			return faceDownImage;
		}
	}
	
	public boolean contains(int px, int py)
	{
		Rectangle bounds = new Rectangle(
				x,y,faceUpImage.getWidth(null),
				faceUpImage.getHeight(null));
		return bounds.contains(new Point(px, py));
	}

	
	public void setFaceUp(boolean isFaceUp)
	{
		this.isFaceUp = isFaceUp;
	}
}




