package mytest;

import org.junit.jupiter.api.Test;
import org.junit.platform.console.ConsoleLauncher;

import java.io.*;
import java.util.Arrays;

public class ProjectTestRunner {

    private PrintWriter pw;
    private PrintWriter pwErr;

    public ProjectTestRunner(){
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        pwErr = new PrintWriter(new OutputStreamWriter(System.err));
    }

    public ProjectTestRunner(String outFileResName, String errFileName) throws IOException {
        FileWriter fileResWriter = new FileWriter(outFileResName);
        FileWriter fileErrWriter = new FileWriter(errFileName);
        pw = new PrintWriter(fileResWriter);
        pwErr = new PrintWriter(fileErrWriter);
    }


    @Test
    public void runTestByName(String name){
        ConsoleLauncher.run(pw, pwErr, String.format("-c %s", name));

    }


    public void  runTestByClassName(Class<?> cls){
        String name = cls.getName();
//        pw = new PrintWriter(new OutputStreamWriter(System.out));
//        pwErr = new PrintWriter(new OutputStreamWriter(System.err));

        ConsoleLauncher.run(pw, pwErr, String.format("-c %s", name));
    }


    public void runTestByStringClassNames(String...names){
//        pw = new PrintWriter(new OutputStreamWriter(System.out));
//        pwErr = new PrintWriter(new OutputStreamWriter(System.err));
        for(String name : names){
            ConsoleLauncher.run(pw, pwErr, String.format("-c %s", name));
        }

    }


    public void runTestByClassNames(Class<?>...classes){
//        pw = new PrintWriter(new OutputStreamWriter(System.out));
//        pwErr = new PrintWriter(new OutputStreamWriter(System.err));
        String clsName;
        for(Class<?> cls : classes){
            clsName = cls.getName();
            ConsoleLauncher.run(pw, pwErr, String.format("-c %s", clsName));
        }
    }

    public void runTestByPackage(String packagePath){

        traverseFolder(packagePath);

        /*
        File[] files = new File(packName).listFiles();
        if(files == null || files.length == 0){
            System.out.println("Empty resource!");
            return;
        }
        String clsName;
        for(File file : files){
            clsName = file.getName();
            if(!file.isDirectory()) {
                // file name should end with "Test"
                System.out.println(file.getName());
                // separate class name from its extension
                clsName = file.getName().substring(0, clsName.lastIndexOf('.'));
                if(checkTestFileName(clsName) ) {
                    // get file name with its parent folder separated with comma
                    String testFileWithParentFolder = file.getParentFile().getName()+"."+clsName;
                    ConsoleLauncher.run(pw, pwErr, String.format("-c %s",testFileWithParentFolder));

                }

            }

        }

         */
    }

    private void traverseFolder(String filePathToTest){

        File[] files = new File(filePathToTest).listFiles();
        if(files == null || files.length == 0){
            System.out.println("Empty resource!");
            return;
        }
        String clsName;
        for(File file : files){
            clsName = file.getName();
            if(!file.isDirectory()) {
                // file name should end with "Test"
                // separate class name from its extension
                clsName = file.getName().substring(0, clsName.lastIndexOf('.'));
                if(checkTestFileName(clsName) ) {
                    // get file name with its parent folder separated with comma
                    String testFileWithParentFolder = file.getParentFile().getName()+"."+clsName;
                    String pathToTestFile = refineClassTestPath(file.getPath());
                    runTestByName(pathToTestFile);

                }

            }else {
                traverseFolder(file.getAbsolutePath());
            }

        }
    }

    // By using this method, we transform let's say path
    // E:\JavaProjects\HillelJavaHomeworks\HW25.Unit-testing\src\mytest\one\SimpleMathLibrary1Test.java
    // into mytest.one.SimpleMathLibrary1Test - we need this format to execute our tests contained in these
    // test files
    private String refineClassTestPath(String path){
        int idxOfSrc = path.lastIndexOf("src");
        String refinedPath =  path.substring(idxOfSrc);
        int firstSlash = refinedPath.indexOf('\\');
        refinedPath = refinedPath.substring(firstSlash + 1, refinedPath.indexOf('.'));
        return refinedPath.replace('\\','.');
    }

    private static boolean checkTestFileName(String fileName){

        return fileName.endsWith("Test");
    }
}
