import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

	public class Barreiras {

		private int barreiraX;
		private int barreiraY;
		private int speedX;
	    public Image barreiraImage;
	    private Rectangle r, rl;
	    private int count, score, scoreReal;
	   
	    
	    private Background bg = StartingClass.getBg1();

	    public Barreiras(int x, int y){
	    
	    	
	    	
	    	barreiraX = x * 300;
	    	barreiraY = 0; // não é necessário
	    	
	    	barreiraImage = StartingClass.getBarreira_img();
	    
	    	r = new Rectangle();
	    	rl = new Rectangle();
	    	
	    	
	    }

	    public void update() {
	        speedX = bg.getSpeedX();
	        barreiraX += speedX;
	        r.setBounds(barreiraX, barreiraY + 295, 40,80);
	        rl.setBounds(barreiraX+50, barreiraY +200, 1, 60);
	        
	       checkVerticalCollision(Pixel.rect);
	       checkPoints(Pixel.rect);
	    
	    }

		public int getBarreiraX() {
			return barreiraX;
		}

		
		
		public int getBarreiraY() {
			return barreiraY;
		}

	
		public Image getBarreiraImage() {
			return barreiraImage;
		}

		public Background getBg() {
			return bg;
		}

		public void setBarreiraX(int barreiraX) {
			this.barreiraX = barreiraX;
		}
		
		public void setBarreiraY(int barreiraY) {
			this.barreiraY = barreiraY;
		}

		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}

		public void setBarreiraImage(Image barreiraImage) {
			this.barreiraImage = barreiraImage;
		}

		public void setBg(Background bg) {
			this.bg = bg;
		}

		
		   public void checkVerticalCollision(Rectangle r1 ){
		    	if (r1.intersects(r)){
		    		System.out.println("collision");
		    		StartingClass.pixel.setSpeedX(0);
		    		StartingClass.pixel.setCenterX(barreiraX - 5);
		    	}
		   }	
	    
			public void checkPoints(Rectangle r2 ){
				
				
		    	if (r2.intersects(rl)){
		    		count = count + 1;	
		       		//System.out.println("point");
			       		if (count==6) {
				       		System.out.println("Ponto!");	// só aldrabices!
				       		count = 0;
				       		score = score + 1;
			       		}
			       	
			 }
		    	
			}
			       		
			    
			       		
				
		    	
		    
		    		
		    	

		public Rectangle getR() {
			return r;
		}

		public void setR(Rectangle r) {
			this.r = r;
		}
		
	
		}



	
