package com.trekt.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;

public class RectangleButton {


	    private float x, y, width, height;
		private boolean enabled = false;

	    //private TextureRegion buttonUp;
	    //private TextureRegion buttonDown;

	    private Rectangle bounds;

	    private boolean isPressed = true;

	    public RectangleButton(float x, float y, float width, float height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	       // this.buttonUp = buttonUp;
	       // this.buttonDown = buttonDown;
	        
	        bounds = new Rectangle(x, y, width, height);

	    }

	    public boolean isClicked(int screenX, int screenY) {
	        if (bounds.contains(screenX, screenY)){
				if (enabled) {

					return true;
				}
			}

			return false;
	    }

//	    public void draw(SpriteBatch batcher) {
//	        if (isPressed) {
//	            batcher.draw(buttonDown, x, y, width, height);
//	        } else {
//	            batcher.draw(buttonUp, x, y, width, height);
//	        }
//	    }

	    public boolean isTouchDown(int screenX, int screenY) {

	        if (bounds.contains(screenX, screenY)) {
	        	
	           
	            return true;
	        }

	        return false;
	    }

	    
	    public void setPressed (Boolean pressed){
	    	this.isPressed = pressed;
	    }
	    
	    public boolean isPressed() {
	    	return this.isPressed;
	    }

		public float getX() {
			return x;
		}

		public void setX(float x) {
			this.x = x;
		}

		public float getY() {
			return y;
		}

		public void setY(float y) {
			this.y = y;
		}

		public float getWidth() {
			return width;
		}

		public void setWidth(float width) {
			this.width = width;
		}

		public float getHeight() {
			return height;
		}

		public void setHeight(float height) {
			this.height = height;
		}
		
		public Rectangle getBounds(){
			return this.bounds;
		}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}


