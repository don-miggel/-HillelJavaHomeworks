package mytest;

import mytest.array_analyzer.ArrayAnalyzer;
import mytest.array_analyzer.ArrayAnalyzerTest;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var projectTestRunner = new ProjectTestRunner("resFile.txt", "errFile.txt");
//        var projectTestRunner = new ProjectTestRunner();
        projectTestRunner.runTestByStringClassNames(SimpleMathLibraryTest.class.getName());
        projectTestRunner.runTestByClassNames(SimpleMathLibraryTest.class);
//        projectTestRunner.runTestByClassNames(ArrayAnalyzerTest.class);
        // The main point, we may have nested folders and Test classes inside that folders, which end with "Test"
        // No matter how deeply folders are nested,
        projectTestRunner.runTestByPackage("E:\\JavaProjects\\HillelJavaHomeworks\\HW25.Unit-testing\\src\\mytest");
 //       projectTestRunner.runTestByClassName(ArrayAnalyzerTest.class);


    }
}
