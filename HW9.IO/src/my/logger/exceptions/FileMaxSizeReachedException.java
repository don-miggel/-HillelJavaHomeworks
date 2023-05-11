package my.logger.exceptions;

public class FileMaxSizeReachedException extends Exception {

    public FileMaxSizeReachedException(int maxSize, int currentSize, String filePath) {
        super("File: " + filePath + " has exceeded maximum possible file size: " + maxSize + " with its current size: " +
                currentSize);
    }
}
