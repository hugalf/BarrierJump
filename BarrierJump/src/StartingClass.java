import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

	public class StartingClass extends Applet implements Runnable, KeyListener {

		private static final long serialVersionUID = 1L; // não sei o que é
		public static Pixel pixel;
	     private Image image, background_img, pixel_img;
		private static Image barreira_img;
		 
	     public static Barreiras barreira;
	     
	     private Graphics second;
	     private URL base;
	     private static Background bg1;
	      
	     private ArrayList<Barreiras>barreiraarray = new ArrayList<Barreiras>();
	      
	     @Override
	     public void init() {

	         setSize(800, 480);
	         setBackground(Color.BLACK);
	         setFocusable(true);
	         addKeyListener(this);
	         Frame frame = (Frame) this.getParent().getParent();
	         frame.setTitle("Barrier Jump");
	         try {
	             base = getDocumentBase();
	         } catch (Exception e) {
	             // TODO: handle exception
	         }
	         
	 		// Image Setups
	 		pixel_img = getImage(base, "data/Pixel_img.png");
	 		background_img = getImage(base, "data/Background_img.png");
	 		barreira_img = getImage(base, "data/barreira_img.png");

	     }

	     @Override
	     public void start() {
	         
	         bg1 = new Background(0,0);    
	         
	        //inicializar Barreiras
         	for (int i = 0; i < 200; i++) {
 			
	 			Barreiras t = new Barreiras(i, i); //bastava definir uma variável
	 			barreiraarray.add(t);
 			}
	         
	     
	         
	        //inicializar Pixel
	         pixel = new Pixel();
	         
	         Thread thread = new Thread(this);
	         thread.start();
	     
	  	     }
	     
	     

	     @Override
	     public void stop() {
	         // TODO Auto-generated method stub
	     }

	     @Override
	     public void destroy() {
	         // TODO Auto-generated method stub
	     }

	     @Override
	     public void run() {
	         while (true) {
	             pixel.update();             
	             bg1.update();
	             updateBarreiras();
	             
	             repaint();
	             
	             try {
	                 Thread.sleep(17);
	             } catch (InterruptedException e) {
	                 e.printStackTrace();
	             }
	          }
	     }
	     
	     @Override
	     public void update(Graphics g) {
	         if (image == null) {
	             image = createImage(this.getWidth(), this.getHeight());
	             second = image.getGraphics();
	         }

	         second.setColor(getBackground());
	         second.fillRect(0, 0, getWidth(), getHeight());
	         second.setColor(getForeground());
	         paint(second);

	         g.drawImage(image, 0, 0, this);

	     }

	     @Override
	     public void paint(Graphics g) {
	        
	    	 g.drawImage(background_img, bg1.getBgX(), bg1.getBgY(), this);      
	    	 
	    	 //deteção de colisões
	    	 g.setColor (Color.white);
	    	 g.drawRect((int)Pixel.rect.getX(), (int)Pixel.rect.getY(), (int)Pixel.rect.getWidth(), (int)Pixel.rect.getHeight());
	    	 
	    	
	         g.drawImage(pixel_img, pixel.getCenterX() - 61, pixel.getCenterY() - 63, this);
	         paintBarreiras(g);
	         
	     }
	     
	     // update e paint barreiras
	     
	 	private void updateBarreiras() {

			for (int i = 0; i < barreiraarray.size(); i++) {
				Barreiras t = (Barreiras) barreiraarray.get(i);
				t.update();
			}
		}

		private void paintBarreiras(Graphics g) {
			for (int i = 2; i < barreiraarray.size(); i++) {
				Barreiras t = (Barreiras) barreiraarray.get(i);
				g.drawImage(t.getBarreiraImage(), t.getBarreiraX(), t.getBarreiraY() + 295, this);
			}
		}
	     

	  	@Override
	     public void keyPressed(KeyEvent e) {

	         switch (e.getKeyCode()) {

	         case KeyEvent.VK_LEFT:
	             pixel.moveLeft();
	             pixel.setMovingLeft(true);
	             break;

	         case KeyEvent.VK_RIGHT:
	             pixel.moveRight();
	             pixel.setMovingRight(true);
	             break;

	         case KeyEvent.VK_SPACE:
	             pixel.jump();
	             break;
	         }
	     }

	     @Override
	     public void keyReleased(KeyEvent e) {
	         switch (e.getKeyCode()) {

	         case KeyEvent.VK_LEFT:
	             pixel.stopLeft();
	             break;

	         case KeyEvent.VK_RIGHT:
	             pixel.stopRight();
	             break;

	         case KeyEvent.VK_SPACE:
	        	 pixel.jump();
	             break;
	         }
	     }

	     @Override
	     public void keyTyped(KeyEvent e) {
	         // TODO Auto-generated method stub
	     }

		public Pixel getPixel() {
			return pixel;
		}

		public Image getImage() {
			return image;
		}

		public Image getBackground_img() {
			return background_img;
		}

		public Image getPixel_img() {
			return pixel_img;
		}

		public Graphics getSecond() {
			return second;
		}

		public URL getBase() {
			return base;
		}

		public static Background getBg1() {
			return bg1;
		}

		public void setPixel(Pixel pixel) {
			StartingClass.pixel = pixel;
		}

		public void setImage(Image image) {
			this.image = image;
		}

		public void setBackground_img(Image background_img) {
			this.background_img = background_img;
		}

		public void setPixel_img(Image pixel_img) {
			this.pixel_img = pixel_img;
		}

		public void setSecond(Graphics second) {
			this.second = second;
		}

		public void setBase(URL base) {
			this.base = base;
		}

		public static void setBg1(Background bg1) {
			StartingClass.bg1 = bg1;
		}

		public static Image getBarreira_img() {
			return barreira_img;
		}

		public static Barreiras getBarreira() {
			return barreira;
		}

		public void setBarreira_img(Image barreira_img) {
			StartingClass.barreira_img = barreira_img;
		}

		public static void setBarreira(Barreiras barreira) {
			StartingClass.barreira = barreira;
		}

		public ArrayList<Barreiras> getBarreiraarray() {
			return barreiraarray;
		}

		public void setBarreiraarray(ArrayList<Barreiras> barreiraarray) {
			this.barreiraarray = barreiraarray;
		}

	
	}
