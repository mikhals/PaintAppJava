import java.awt.*;

public class MyStroke extends BasicStroke {

    BasicStroke stroke;

    private static float[] pattern = {10, 15};
    private static float[] pattern2 = {20,8,2,10};

    public MyStroke(){
    }

    public BasicStroke getDefaultStroke(int linewidth){
        return new BasicStroke(linewidth);
    }

    public BasicStroke getDashedStroke(int linewidth){
        return new BasicStroke(linewidth,CAP_BUTT,JOIN_BEVEL,1.0f,pattern,0);
    }
    public BasicStroke getDashedStroke2(int linewidth){
        return new BasicStroke(linewidth,CAP_BUTT,JOIN_BEVEL,1.0f,pattern2,0);
    }

    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    public BasicStroke getStroke() {
        return stroke;
    }

    //
//    public
//
//    public MyDashedStroke(float lineWidth){
//        super(lineWidth,CAP_BUTT,JOIN_BEVEL,1.0f,pattern,0);
//    }

}
