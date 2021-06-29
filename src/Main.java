import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//   Tool [] tools = new Tool[3];
//   tools[0] = new Drum(20);
//   tools[1] = new Tube(30);
//   tools[2]= new Guitar(18);

        ArrayList<Tool> tools = new ArrayList<>();
        tools.add(new Tube(30));
        tools.add(new Drum(20));
        tools.add(new Guitar(18));
        for (Tool tool : tools) {
            tool.play();
        }
    }
}
