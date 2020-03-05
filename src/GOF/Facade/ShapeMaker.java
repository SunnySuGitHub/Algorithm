package GOF.Facade;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class ShapeMaker {

    private Circle circle;
    private Square square;

    public ShapeMaker() {
        circle = new Circle();
        square = new Square();
    }

    public void makeCircle() {
        circle.showShape();
    }

    public void makeSquare() {
        square.showShape();
    }

}
