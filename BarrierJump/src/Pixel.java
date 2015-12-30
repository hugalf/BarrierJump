import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class Pixel {

		// Constants are Here
		
	
		final int GROUND = 400;
		final int JUMP_HEIGHT = -17;
		final int JUMP_SPEED = 1;
		final int MOVE_SPEED =5;
		
		//retangulo para deteção de colisões
		public static Rectangle rect = new Rectangle(0, 0, 0, 0);
		public static Line2D linha = new Line2D.Double(0, 0, 0, 0);
		
		private int centerX = 100;
		private int centerY = GROUND;
		private boolean jumped = false;
		private boolean movingLeft = false;
		private boolean movingRight = false;

		private int speedX = 0;
		private int speedY = JUMP_SPEED;
		
		private Background bg1 = StartingClass.getBg1();
		
		
		public void update() {
			
		rect.setRect(centerX - 60, centerY - 60	, 40, 40);
			
			// Moves Character or Scrolls Background accordingly.
		if (speedX < 0) {
			centerX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);

		}
		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}
		if (speedX > 0 && centerX > 200){
			bg1.setSpeedX(-MOVE_SPEED);
		}
		
	

			
			// Updates Y Position
			
			centerY += speedY;
			if (centerY + speedY >= GROUND) {
				centerY = GROUND;
			}

			// Handles Jumping
			if (jumped == true) {
				speedY += JUMP_SPEED;

				if (centerY + speedY >= GROUND) {
					centerY = GROUND;
					speedY = 0;
					jumped = false;
				}		
		}
			
			if (centerX + speedX <= 40) {
				centerX = 41;
			}
	
		}

			
		public void moveRight() {
				speedX = 6;	
		}

		public void moveLeft() {
				speedX = -6;
		}

		public void stopRight() {
			setMovingRight(false);
			stop();
		}

		public void stopLeft() {
			setMovingLeft(false);
			stop();
		}

		private void stop() {
			if (isMovingRight() == false && isMovingLeft() == false) {
				speedX = 0;
			}


			if (isMovingRight() == false && isMovingLeft() == true) {
				moveLeft();
			}


			if (isMovingRight() == true && isMovingLeft() == false) {
				moveRight();
			}
		}
		
		public void jump() {
			if (jumped == false) {
				speedY = JUMP_HEIGHT;
				jumped = true;
			}
		}
		
		public int getCenterX() {
			return centerX;
		}
		public int getCenterY() {
			return centerY;
		}
		public boolean isJumped() {
			return jumped;
		}
		public boolean isMovingLeft() {
			return movingLeft;
		}
		public boolean isMovingRight() {
			return movingRight;
		}
		public int getSpeedX() {
			return speedX;
		}
		public int getSpeedY() {
			return speedY;
		}
		public Background getBg1() {
			return bg1;
		}
		public void setCenterX(int centerX) {
			this.centerX = centerX;
		}
		public void setCenterY(int centerY) {
			this.centerY = centerY;
		}
		public void setJumped(boolean jumped) {
			this.jumped = jumped;
		}
		public void setMovingLeft(boolean movingLeft) {
			this.movingLeft = movingLeft;
		}
		public void setMovingRight(boolean movingRight) {
			this.movingRight = movingRight;
		}
		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}
		public void setSpeedY(int speedY) {
			this.speedY = speedY;
		}
		public void setBg1(Background bg1) {
			this.bg1 = bg1;
		}
	
}		
