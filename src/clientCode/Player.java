package clientCode;
import java.io.Serializable;

public class Player implements Serializable{
   private static final long serialVersionUID = 1L;
   int xPos;//x and y positions
   int yPos;
   float xVel;//x and y velocities
   float yVel;
   float xAccel;//x and y acceleration
   float yAccel;
   
   
   
   float accelMagnitude;
   
   float decelFactor;
   
   int id;
   
   
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
   }
}