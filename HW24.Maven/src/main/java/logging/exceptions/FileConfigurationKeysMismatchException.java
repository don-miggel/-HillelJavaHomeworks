package logging.exceptions;

import java.util.Set;

public class FileConfigurationKeysMismatchException extends RuntimeException{

    public FileConfigurationKeysMismatchException(Set<String> neededKeys){
        super("You have passed invalid keys. You should pass only keys: "+neededKeys);
    }
}
