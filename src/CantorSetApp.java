import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class CantorSetApp extends PApplet {
    private static CantorSetApp app;
    private ArrayList<Line> lines;
    private int nextIndex;

    public static void main(String[] args){
        PApplet.main("CantorSetApp");
    }

    public CantorSetApp(){
        app = this;
        lines = new ArrayList<Line>();
        nextIndex = 0;
    }

    public void settings(){
        size(1000, 500);
    }

    public void setup(){
        background(255);

        //translate(width/4, height/2);
        strokeWeight(3);
        cantor(50, 50, 900);
        cantor(50, 250, 900); // repeat at a lower level
    }

    public void draw(){
        if (nextIndex < lines.size()){
            lines.get(nextIndex).display();
            nextIndex++;
        }
    }

    public void cantor(float x, float y, float len) {
        if (len >= 2) {
            Line line = new Line(new PVector(x, y), new PVector(x+len, y));
            lines.add(line);
            //line(x, y,x + len, y);
            y += 20;
            cantor(x, y,len/3);
            cantor(x + len*2/3, y,len/3);
        }
    }

    public static CantorSetApp getApp(){
        return app;
    }
}
