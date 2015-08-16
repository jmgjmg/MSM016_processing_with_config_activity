package processing.test.manual_m0016;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap;

import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Manual_M0016 extends PApplet {

// simple processing example that randomly prints a String on the screen

String word = "Makespace";
String mouseString = "Mouse Pressed";

long lastUpdate=0;

boolean horizontal =true;

public void setup() {
  //Set the size of the stage, and the background to black.
  //size(1000,500);             
 
  background(0);
 
}

public void draw() {

  if ((mousePressed) &&((millis()-lastUpdate)>3000)) {
	  Intent intentConfig = new Intent(this, ConfigurarActivity.class);
	  startActivityForResult(intentConfig, 0);				
	  return;			    
   }
	  
	  
  //Draw a faint black rectangle over what is currently on the stage so it fades over time.
  fill(0,10);                   //fade 10% 
  rect(0,0,width,height);       //whole display/screen


  //Put it somewhere random on the stage, with a random size and colour
  float ts= random(30,70);      //random font size between 30 and 70
  float x= random(width);       //any position in the screen/display
  float y= random(height);      //any position in the screen/display
  textSize(ts);                 // set the font size to the random value
  float sw = textWidth(word);   //actual width of the text with this font and font size
  fill(0,0,0);                  //set colour to black
  if (horizontal) {
    translate(0,0);
    rotate (0);                 //horizontal text
    rect(x-2,y-ts-1,sw+4,ts+4);
    fill(random(255),random(255), random(255)); //set a random colour
    text(word, x, y);
  } else {
    translate(height,0);
    rotate (PI/2);              //vertical text
    rect(x-2,y-ts-1,sw+4,ts+4);
    fill(random(255),random(255), random(255));
    text(word, x, y);
  
  }
  horizontal =!horizontal;      //switch horizontal/vertical
  delay(200);
}
  public void settings() {  size(displayWidth, displayHeight);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Manual_M0016" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
  
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		 super.onActivityResult(requestCode, resultCode, data); 
		 lastUpdate=millis();
		 // See which child activity is calling us back.
         if (resultCode == RESULT_CANCELED) {}//DO NOTHING 
         else {	     
        	  fill(0,50);
        	  rect(0,0,width,height);	         	
        	  updateValues();
         }
	}  
		
	void updateValues(){
		  SharedPreferences settings = getSharedPreferences("MSM016", 0);        
		  word= settings.getString("nombre", word);
		  
	}
  
  
  
  
}
