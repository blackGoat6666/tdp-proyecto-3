package gui;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel
{
	ImageIcon imagen;
	String url;
	public Panel(String url)
	{
		this.url=url;
	}
	public void paint(Graphics g)
	{
		Dimension tamanio= getSize();
		imagen = new ImageIcon(getClass().getResource(url));
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paint(g);
	}
	public void changeImage (String url) {
		this.url=url;
	}
}