// simple processing example that randomly prints a String on the screen

String word = "Makespace";
String mouseString = "Mouse Pressed";

boolean horizontal =true;

void setup() {
  //Set the size of the stage, and the background to black.
  //size(1000,500);             
  size(displayWidth, displayHeight);
  background(0);
  smooth();
}

void draw() {

  if(mousePressed) {
    textSize(30);               //set the font size
    fill(0,0,0);                //set colour to black
    float sw = textWidth(mouseString); //actual width of the text with this font and font size
    translate(0,0);             //top left corner of the display/screen
    rotate (0);                 //horizontal text
    rect(0,0,sw+4,34);          //draw a black box with the size of the text plus some margin
    fill(255,255, 255);         //change colour to white
    text("mouseString", 2, 32); //write text at the top left corner
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