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
   
   public Player(int x, int y, int id){
      this.xPos = x;
      this.yPos = y;
      this.xVel = 0;
      this.yVel = 0;
      this.xAccel = 0;
      this.yAccel = 0;
      
      this.accelMagnitude = 0.125f;
      
      this.decelFactor = 0.5f; 
      
      this.id = id;
   }
}