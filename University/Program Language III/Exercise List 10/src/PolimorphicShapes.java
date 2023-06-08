import Figuras.*;
import java.util.List;
import java.util.ArrayList;

public class PolimorphicShapes {

    public static void main(String[] args) {

        List<Shape2D> shape2DList = new ArrayList<>();
        shape2DList.add( new Circle( 2 ) );
        shape2DList.add( new Rectangle( 2,3 ) );
        shape2DList.add( new Square( 3 ) );
        shape2DList.add( new Triangle( 2, 5, 7, 2 ) );

        //Imprimindo
        for( Shape2D shape2D: shape2DList ) {
            System.out.println( shape2D.toString() );
        }


    }
}
