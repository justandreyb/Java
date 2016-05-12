package drawing;

public class Factory {
    public Shape getShape(String object, double posFX, double posFY, double posLX, double posLY) {
        switch(object) {
            case "btnLine": 
                return new drawing.Shapes.Line(posFX, posFY, posLX, posLY);
            case "btnCircle": 
                return new drawing.Shapes.Circle(posFX, posFY, posLX, posLY);
            case "btnEllipse": 
                return new drawing.Shapes.Ellipse(posFX, posFY, posLX, posLY);
            case "btnRectangle": 
                return new drawing.Shapes.Rectangle(posFX, posFY, posLX, posLY);
            case "btnRoundRectangle": 
                return new drawing.Shapes.RoundRectangle(posFX, posFY, posLX, posLY);
            default:
                //Do smt
                return null;
        } 
    }
}
