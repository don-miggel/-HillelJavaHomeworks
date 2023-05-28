import java.nio.file.Files;
import java.nio.file.Path;

public class FileData implements Comparable<FileData> {

    private final String fileName;
    private final double size;
    private final String path;

    public FileData(String fileName, double size, String path){

        this.fileName = fileName;
        this.size = size;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public double getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }

    @Override
    public int compareTo(FileData o) {
        return (int) (getSize() - o.getSize());
    }
}
