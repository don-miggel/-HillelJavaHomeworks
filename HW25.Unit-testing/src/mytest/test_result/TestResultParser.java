package mytest.test_result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TestResultParser {

    private final Map<String, Integer> testResults;

    {
        testResults = new HashMap<>();
    }

    private static final Set<String> KEY_WORDS = Set.of("tests started", "tests successful", "tests failed", "finished after");

    public void parse(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
 //       StringBuilder fileText = new StringBuilder();

        String readText;
        String extractedKey;
        while ((readText = reader.readLine()) != null) {
            extractedKey = extractKeyWord(readText);
            if(extractedKey != null) {

                // we wrap our line into additional '[' and ']', in order to make our lines identical for parsing
                // later these characters will be replaced with "" and trimmed
                int val = parseTextLine("["+readText+"]");
                this.fillMap(extractedKey, val);
 //               fileText.append("[").append(readText).append("]").append("\n");
            }
        }

         reader.close();
    }

    public void parse(File file) throws IOException{
        if(file == null ) throw new RuntimeException("");
       parse(file.getAbsolutePath());
    }

    public  void parse(Path path) throws IOException{
        parse(path.toString());

    }

    // here we put a line, like [[         6 containers successful ]] and get 6 as an int value
    // As well as from a string [Test run finished after 74 ms], we get 74 as a result
    private static int parseTextLine(String line){
        String interim = line.replace("]", "").replace("[","").trim();
        String parsedNumStr = interim.substring(0, interim.indexOf(' '));

        try {
            return Integer.parseInt(parsedNumStr);
        }catch (NumberFormatException e){
            parsedNumStr = interim.replace("ms","").trim();
            int idxLastSpace = parsedNumStr.lastIndexOf(' ');
            return Integer.parseInt(parsedNumStr.substring(idxLastSpace+1));
        }
    }

    private void fillMap(String k, int v){

        if(testResults.containsKey(k)) {
            int val = testResults.get(k);
            testResults.put(k, val + v);
        }else {
                testResults.put(k,v);
            }

    }

    public Map<String, Integer> getTestResults(){
        return testResults;
    }

    private static String extractKeyWord(String text){
        for (String kw : KEY_WORDS){
            if(text.contains(kw))
                return kw;
        }

        return null;
    }

    public static void main(String[] args) {
        TestResultParser testResultParser = new TestResultParser();
//            testResultParser.parse("E:\\JavaProjects\\HillelJavaHomeworks\\HW25.Unit-testing\\resFile.txt");
        try {
//            testResultParser.parse("E:\\JavaProjects\\HillelJavaHomeworks\\HW25.Unit-testing\\resFile.txt");
//            testResultParser.parse(Path.of("E:\\JavaProjects\\HillelJavaHomeworks\\HW25.Unit-testing\\resFile.txt"));
            testResultParser.parse(new File("E:\\JavaProjects\\HillelJavaHomeworks\\HW25.Unit-testing\\resFile.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var testResults = testResultParser.getTestResults();
        TestResult testResult  = new TestResult(testResults);
        System.out.println(testResult);
    }

}
