package my.serverclient.server;

public class MyFile {

    private String sender;
    private String path;
    private String name;
    private double size;

    public MyFile(String sender, String path, String name, double size) {

        this.sender = sender;
        this.path = path;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "sender='" + sender + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
