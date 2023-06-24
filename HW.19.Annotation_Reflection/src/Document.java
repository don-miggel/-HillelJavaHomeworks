

public class Document {

    public Document(){}

    @BeforeSuite
    public void prepared(){
        System.out.println("Document prepared");
    }

    @Test(4)
    public void fulfilled(){
        System.out.println("Document fulfilled");
    }

    @Test(6)
    public void approved(){
        System.out.println("Document approved");
    }

    @Test(7)
    public void signed(){
        System.out.println("Document signed");
    }

    @Test
    public void attached(){
        System.out.println("Document attached");
    }

    @Test(8)
    public void received(){
        System.out.println("Document received");
    }

    @Test(3)
    public void sent(){
        System.out.println("Document sent");
    }

    @AfterSuite
    public void archived(){
        System.out.println("Document archived");
    }
}
