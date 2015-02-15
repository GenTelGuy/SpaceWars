package clientCode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Projectile {
	
	public int xPos;
	public int yPos;
	public float xVel;
	public float yVel;
	
	private int scaleTimer = 0;
	
	public int teamID;
	
	public Projectile(int x, int y, float xVel, float yVel, int id){
		xPos = x;
		yPos = y;
		this.xVel = xVel;
		this.yVel = yVel;
		teamID = id;
	}
	
	public void render(GameContainer gc, Graphics g){
		//Fancy polar drawing code
		for(int i = 0; i < 360; i += 5){
			float theta = (float) (i * Math.PI / 180) * (scaleTimer % 30);
			float r = (float)(Math.cos(i));
			float scale = scaleTimer % 30;
			g.drawRect(xPos + (float)(r * Math.cos(theta)) * scale, yPos + (float)(r * Math.sin(theta)) * scale, 2, 2);
		}
	}
	
	public void update(GameContainer gc, int delta){
		//used to expand or shrink the rotating electron-cloud-like effect
		scaleTimer += (float)(delta / 10f);
		if(scaleTimer >= 360){
			scaleTimer = 0;
		}
		
		xPos += xVel;
		yPos += yVel;
	}

}
