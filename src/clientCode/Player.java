package clientCode;
import java.io.Serializable;
import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	int xPos;//x and y positions
	int yPos;
	float xVel;//x and y velocities
	float yVel;
	float xAccel;//x and y acceleration
	float yAccel;

	public Vector<Projectile> projectiles;

	float accelMagnitude;

	float decelFactor;

	int id;

	public Player(int x, int y, int id){
		this.xPos = x;
		this.yPos = y;
		this.xVel = 0;
		this.yVel = 0;
		this.xAccel = 0;
		this.yAccel = 0;

		this.accelMagnitude = 0.125f;

		this.decelFactor = 0.05f; 

		this.id = id;
		projectiles = new Vector<Projectile>();
	}


	//Proper use of these functions is: set the x and y accelerations, then decelerate, then accelerate, then move.
	public void accelerate(){

		xVel += xAccel;
		yVel += yAccel;

	}

	public void decelerate(){

		xAccel -= xVel * decelFactor;
		yAccel -= yVel * decelFactor;


	}


	public void move(){

		xPos += xVel;
		yPos += yVel;

	}

	public void render(GameContainer gc, Graphics g){
		g.drawRect(xPos, yPos, 64, 64);
		renderProjectiles(gc, g);
	}

	public void update(GameContainer gc, int delta){
		updateProjectiles(gc, delta);
	}

	public void renderProjectiles(GameContainer gc, Graphics g){
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).render(gc, g);
		}
	}

	public void updateProjectiles(GameContainer gc, int delta){
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update(gc, delta);
		}
	}

}