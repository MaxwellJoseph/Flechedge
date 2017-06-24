package flechedge;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class Sprite	 {
	private Image image;
	private double positionX;
	private double positionY;
	private double velocityX;
	private double velocityY;
	private double width;
	private double height;
	
	public Sprite(String filename){
		image = new Image(filename);
		width = image.getWidth();
		height = image.getHeight();
		
		positionX = 0;
		positionY = 0;
		velocityX = 0;
		velocityY = 0;
	}
	
	
	public void setPosition(double x, double y) {
		positionX = x;
		positionY = y;
	}
	
	public void addPosition(double x, double y) {
		positionX += x;
		positionY += y;
	}
	
	public void setVelocity(double x, double y) {
		velocityX = x;
		velocityY = y;
	}
	
	
	public void addVelocity(double x, double y) {
		velocityX += x;
		velocityY += y;
	}
	
	public double getX(){
		return positionX;
	}
	
	public double getY() {
		return positionY;
	}
	
	public double getVX() {
		return velocityX;
	}
	
	public double getVY() {
		return velocityY;
	}
	
	public void update(double time) {
		positionX += velocityX * time;
		positionY += velocityY * time;
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(image, positionX, positionY);
	}
	
	public Rectangle2D getBoundary() {
		return new Rectangle2D(positionX, positionY, width, height);
	}
	
	public boolean intersects(Sprite s) {
		return s.getBoundary().intersects(this.getBoundary());
	}
	
	public void lunge() {
		positionX += 20;
	}
	
	public String toString() {
		return "Position: [" +positionX+"c" +positionY+"]" + "Velocity: [" +
	velocityX +","+velocityY+"]";
	}

}