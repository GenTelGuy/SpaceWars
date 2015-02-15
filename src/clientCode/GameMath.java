package clientCode;


public class GameMath {//This class contains STATIC mathematical functions relevant to game development.
	
	public static float generateShotXVel( float playerX, float playerY, float mouseX, float mouseY, float magnitude ){
		//This algorithm uses similar triangles to determine the appropriate x velocity for the projectile
		
		float hypotenuse = (float) (Math.pow(mouseX - playerX, 2) + Math.pow(mouseY - playerY, 2));
		float ratio = magnitude / hypotenuse;
		float xMag = ratio * (mouseX - playerX);
		
		return xMag;
		
		
		
	}
	
	public static float generateShotYVel( float playerX, float playerY, float mouseX, float mouseY, float magnitude ){
		//This algorithm uses similar triangles to determine the appropriate y velocity for the projectile. No /0 errors
		
		float hypotenuse = (float) (Math.pow(mouseX - playerX, 2) + Math.pow(mouseY - playerY, 2));
		float ratio = magnitude / hypotenuse;
		float yMag = ratio * (mouseY - playerY);
		
		return yMag;
		
		
		
	}
	

}
