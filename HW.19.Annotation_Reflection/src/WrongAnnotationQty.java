

public class WrongAnnotationQty extends Exception{

    public WrongAnnotationQty(){
        super("Test class should contain one @BeforeSuite and one @AfterSuite annotations");
    }
}
