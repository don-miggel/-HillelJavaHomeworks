package my.logger;

import my.logger.config.FileLoggerConfiguration;
import my.logger.exceptions.FileMaxSizeReachedException;
import my.logger.utils.FileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class FileLogger {

    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String msg) {
        if (config.getLoggingLevel().equals(LoggingLevel.INFO))
            return;
        logData(msg, "DEBUG");
    }

    public void info(String msg) {

        logData(msg, "INFO");
    }

    private void logData(String msg, String level) {
        // In this try section, we check exceeding of the max size
        // In case of it being occurred, we handle an exception, thrown by checkFileSize() method
        // and create a new file in the createNewFile() method
        try {
            checkFileSize();
        } catch (FileMaxSizeReachedException e) {
            createNewFile();
            System.out.println(e.getMessage());
        }
        // Create formatted string here, which will be written into a log file
        String formattedData = String.format(config.getLoggingFormat(), LocalDateTime.now(), level, "Message: " + msg);
        // Get path of the log file
        Path logFilePath = Path.of(config.getFilePath());
        File myFile = new File(logFilePath.toUri());

        // In this try section we write data to the opened file, we append data to the end of the file
        // or create it with the name, taken from the config file, if it is absent
        try (FileWriter fwr = new FileWriter(myFile, true);) {

            if (myFile.canWrite())
                fwr.append(String.valueOf(formattedData)).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
     /*
     *This private method checks the current file's size towards exceeding maximum possible file size,
     * pointed out in the configuration file
     * returns true, if exceeds, may throw IOException, since Files.size requires  either its handling or declaration
     * It is a previous version, is not used now!

     private boolean checkFileSize()  {

        boolean isExceed = false;
        try {
            isExceed= Files.size(Path.of(config.getFilePath())) >= config.getMaxFileSize();
        }catch (IOException e) {
            System.out.println(e);
        }
        return isExceed;
     }
     */

    /*
     *This private method checks the current file's size towards exceeding maximum possible file size,
     * pointed out in the configuration file
     * If exceeding occurred,this method throws FileMaxSizeReachedException with file parameters, that exceeded maxSize.
     */
    private void checkFileSize() throws FileMaxSizeReachedException {

        boolean isExceed;
        try {
            long currentSize = Files.size(Path.of(config.getFilePath()));
            isExceed = currentSize >= config.getMaxFileSize();
            if (isExceed)
                throw new FileMaxSizeReachedException(config.getMaxFileSize(), (int) currentSize, config.getFilePath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
     * If exceeding occurred of the maximum possible file size, we create a new file in this private method,
     * which name is re-written in the configuration file
     * It happens each time, as soon as exceeding occurred
     */
    private void createNewFile() {
        // get current log file path
        String currentFilePath = config.getFilePath();
        // extract path without file
        currentFilePath = currentFilePath.substring(0, currentFilePath.lastIndexOf('/') + 1);
        String timeFileCreated = LocalTime.now().toString();
        // Our time format looks like 17:54:15.033634600. So we extract time uo to the point and replace ':' to '_'
        timeFileCreated = timeFileCreated.substring(0, timeFileCreated.indexOf('.')).replace(':', '_');
        // create filename for new log file
        String fileName = "Log_" + LocalDate.now() + " " + timeFileCreated + ".txt";
        // set new path
        config.setFilePath(currentFilePath + fileName);
        // replace logging file with a new file by updating path
        FileParser.replaceTextInFile(config.getFileConfigPath(), "FILE", config.getFilePath(), ':');
        System.out.println("New file: " + config.getFilePath() + " created!");
    }
}
