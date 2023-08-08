package logging.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class FileParser {

    // this method simply opens a file and reads char by char
    // returns a read text
    public static String openAndParseFile(File file, char separator) {
        StringBuilder str = new StringBuilder("");
        try (java.io.FileReader fin = new java.io.FileReader(file.getPath())) {
            int i;

            do {
                i = fin.read();
                if (i != -1) {
                    str.append((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println(e);
        }
        str.append('\n');
        return str.toString();
    }

    public static String[] getKeys(File file, char sep){
        String fileText = openAndParseFile(file,sep).trim();

        int keysAmount = countSeparator(fileText, sep);
        String[] keys = new String[keysAmount];
        String currentText = fileText;

        int counter = 0;
        do {
            keys[counter++] = currentText.substring(0, currentText.indexOf(sep)).trim();
            currentText = currentText.substring(currentText.indexOf('\n')+1);
        } while (currentText.indexOf(sep) != -1 && counter < keys.length);

        return keys;

    }

    // We replace text in the file by the key, passed as one of params
    // this function is used by creating a new file in the FileLogger class
    public static void replaceTextInFile(String filePath, String key, String newValue, char sep) {
        Path logFilePath = Path.of(filePath);
        File myFile = new File(logFilePath.toUri());

        // retrieve text from the file, passed as a first param
        StringBuilder parsedText = new StringBuilder(openAndParseFile(myFile, sep));

        // index of the end of line character
        int idxOfEndPos = parsedText.indexOf("\n");
        // replace text in the file, starting from next character after ':' up to the end of line
        parsedText.replace(key.length() + 1, idxOfEndPos, newValue);

        // open log file for writing and write new path there
        try (FileWriter fwr = new FileWriter(myFile);) {

            if (myFile.canWrite())
                fwr.append(String.valueOf(parsedText)).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static String[] getDataFromFile(File file, char separator) {

        String parsedText = openAndParseFile(file, separator);

        return parseString(parsedText, separator);
    }

    // overload getDataFromFile method especially for usage in the StdoutLoggerConfigurationLoader class
    // since, we don't have to use such keys as MAX-SIZE and FILE for storing current logging file path
    public static String[] getDataFromFile(File file, char separator, String...keys){
        String[] values = new String[keys.length];
        String dataFromFile = openAndParseFile(file, separator);
        int counter = 0;
        for(String key : keys){
            if (dataFromFile.contains(key)){
                dataFromFile = dataFromFile.substring(dataFromFile.indexOf(key));
                values[counter++] = dataFromFile.substring(dataFromFile.indexOf(key)+key.length()+1,
                        dataFromFile.indexOf('\n')).trim();
            }
        }
        return values;
    }

    private static int countSeparator(String str, char sep) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sep)
                count++;
        }
        return count;
    }

    // In this method we extract all values, following after ':' characters
    private static String[] parseString(String str, char sep) {
        String[] values = new String[countSeparator(str, sep)];
        int arrCounter = 0;
        String currentStr = str;
        while (currentStr.indexOf(sep) != -1) {

            values[arrCounter++] = currentStr.substring(currentStr.indexOf(sep) + 1, currentStr.indexOf('\n')).trim();
            currentStr = currentStr.substring(currentStr.indexOf('\n') + 1);
        }
        return values;
    }

}
