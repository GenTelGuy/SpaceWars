package clientCode;


public class GameMath {//This class contains STATIC mathematical functions relevant to game development.
	
	public static float generateShotXVel( float playerX, float playerY, float mouseX, float mouseY, float magnitude ){
		//This algorithm uses similar triangles to determine the appropriate x velocity for the projectile
		magnitude *= 1000;//Temporarily scale this up because the small numbers get rounded
		double hypotenuse =  Math.pow((Math.pow(mouseX - playerX, 2.0) + Math.pow(mouseY - playerY, 2.0)), 0.5);
		double ratio = magnitude / hypotenuse;
		double xMag = ratio * (mouseX - playerX);
		xMag /= 1000;
		
		return (float) xMag;
		
		
		
		
	}
	
	public static float generateShotYVel( float playerX, float playerY, float mouseX, float mouseY, float magnitude ){
		//This algorithm uses similar triangles to determine the appropriate y velocity for the projectile. No /0 errors
		magnitude *= 1000;//Temporarily scale this up because the small numbers get rounded
		double hypotenuse =  Math.pow( (Math.pow(mouseX - playerX, 2.0) + Math.pow(mouseY - playerY, 2.0)), 0.5);
		double ratio = magnitude / hypotenuse;
		double yMag = ratio * (mouseY - playerY);
		yMag /= 1000;
		return (float) yMag;
		
		
		
	}
	

}
