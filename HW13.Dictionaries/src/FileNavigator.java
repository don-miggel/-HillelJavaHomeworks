import java.io.File;
import java.util.*;

public class FileNavigator {

    private final Map<String, List<FileData>> filesStored;

    public FileNavigator() {
        filesStored = new HashMap<>();
    }

    public void add(String path) {
        File extractedPath = new File(path);
        if (!extractedPath.isDirectory() && consistencyCheck(path)) {
            System.out.println("Wrong path or filename: " + extractFileFromPath(path) + " !");
            return;
        }

        if (!extractedPath.isDirectory() && !checkFilePresenceInStorage(path)) return;

        List<FileData> lstFileData = new ArrayList<>();
        String key = extractPath(extractedPath);
        // if a key is not there
        if (!filesStored.containsKey(key)) {
            // if key is not there, firstly we create an empty list associated with a key, no matter, whether
            // it be a file or a directory, we use extractPath private method, for extracting a path, no matter if a
            // path ending with a file or a dir
            filesStored.put(extractPath(extractedPath), new ArrayList<>());
            //check whether the path is a directory or a file
            if (extractedPath.isDirectory()) {
                for (File file : extractedPath.listFiles()) {
                    if (!file.isDirectory() && checkFilePresenceInStorage(path, file))
                        //we should check whether a path contains new files
                        lstFileData.add(new FileData(file.getName(), file.getTotalSpace() * Math.random() / 1024,
                                file.getAbsolutePath()));
                }
                filesStored.get(key).addAll(lstFileData);
            } else {
                filesStored.get(key).add(new FileData(extractedPath.getName(),
                        extractedPath.getTotalSpace() * Math.random() / 1024, extractedPath.getAbsolutePath()));
            }
            // key is already present
        } else {
            // we check anyway, whether passed path ending with a file or a directory, we have an Extension enum
            // which contains extensions, against which we compare in the extractPath private method
            if (extractedPath.isDirectory()) {
                for (File file : extractedPath.listFiles()) {

                    //we should check whether a path, that has already been put contains new files
                    if (!filesStored.get(key).contains(file) && !file.isDirectory() &&
                            checkFilePresenceInStorage(path, file)) {
                        // if so, we append these files to the existing list associated with a key
                        filesStored.get(key).add(new FileData(file.getName(), file.getTotalSpace() * Math.random() / 1024,
                                file.getAbsolutePath()));
                    }
                }
            } else {
                // else we try to put a new file to the already existing path in our file storage filesStored

                filesStored.get(key).add((new FileData(extractedPath.getName(),
                        extractedPath.getTotalSpace() * Math.random() / 1024, extractedPath.getAbsolutePath())));
            }
        }
        System.out.println(filesStored);
    }

    public List<FileData> find(String path) {

        File extractedPath = new File(path);
        // if a user occasionally has put a file at the end of the path, we check the path
        String key = extractPath(extractedPath);
        if (filesStored.containsKey(key))
            return filesStored.get(key);
        return null;
    }

    public List<FileData> filterBySize(double sizeLimit) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (String path : filesStored.keySet()) {
            for (FileData fileData : filesStored.get(path)) {
                if (fileData.getSize() < sizeLimit) {

                    filteredFiles.add(fileData);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        File extractedPath = new File(path);
        // if a user occasionally has put a file at the end of the path, we check the path
        String key = extractPath(extractedPath);
        if (filesStored.containsKey(key))
            filesStored.remove(key);
    }

    public List<FileData> sortBySize() {
        List<FileData> storedFilesFlattened = new ArrayList<>();
        for (String path : filesStored.keySet())
            storedFilesFlattened.addAll(filesStored.get(path));
        storedFilesFlattened.sort(new FileDataComparator());
        return storedFilesFlattened;
    }


    // This method is intended for determining whether a received path has a file or a dir on its ending
    // if the last part of the path contains a '.' character, which matches to some of the extensions, hence it is a file
    //even though even dirs may contain a point in its name
    //Firstly, we determine the index of th last slash to  extract the last part of the path
    //Then we extract a point from the previously extracted last part of the path
    // In the loop we compare against extensions from Extensions enum, if matches => the path is ending with a file
    // and we have to return a path before that file, which will become a key in the filesStored
    // if there is no match => it is ending with a directory, we simply return a path as it is
    private String extractPath(File file) {
        int lastIndOfSlash = file.getPath().lastIndexOf('\\');

        String extractedFile = file.getPath().substring(lastIndOfSlash + 1);
        int lastIndOfPoint = extractedFile.lastIndexOf('.');
        // if we have a point in the last part of the path and it matches to the extensions in the Extensions enum,
        // hence it is a file
        if (lastIndOfPoint != -1) {
            String extension = extractedFile.substring(lastIndOfPoint + 1).toUpperCase();

            for (Extensions ext : Extensions.values()) {
                if (ext.toString().equals(extension)) {

                    return file.getPath().substring(0, lastIndOfSlash);
                }
            }
        }

        return file.getPath();
    }

    //implement 7** task
    // we pass a path as a String and firstly check whether a path exists(subtracting a file if a path ends with a file)
    // Then if it does, we loop all the files in the directory(the part after the last slash is either a folder or a file)
    // If pointed out file is not found, we return false
    // we use a helper private method  extractFileFromPath to extract a filename
    private boolean consistencyCheck(String path) {
        File extractedPath = new File(extractPath(new File(path)));
        String refinedPath = extractPath(extractedPath);

        // if a path doesn't exist, return false
        if (!extractedPath.exists()) return false;

        for (File file : extractedPath.listFiles()) {

            if (file.getName().equals(extractFileFromPath(path))) {
                return false;
            }
        }

        return true;
    }

    // relates to 7** task too
    private boolean checkFilePresenceInStorage(String path) {

        for (List<FileData> files : filesStored.values()) {
            for (FileData fd : files) {
                if (extractFileFromPath(path).equals(fd.getFileName())) {
                    System.out.println("File " + fd.getFileName() + " has already been added to the storage !");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkFilePresenceInStorage(String path, File file) {

        for (List<FileData> files : filesStored.values()) {
            for (FileData fd : files) {
                if (fd.getFileName().equals(file.getName())) {
                    System.out.println("File " + fd.getFileName() + " has already been added to the storage !");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkPathMatch(String path) {

        File extractedPath = new File(extractPath(new File(path)));
        File file = new File(extractFileFromPath(path));
        return extractedPath.getAbsolutePath().equals(file.getAbsolutePath());

    }

    private String extractFileFromPath(String path) {
        File file = new File(path);
        if (file.isDirectory()) return null;

        int lastIndOfSlash = file.getPath().lastIndexOf('\\');

        return file.getPath().substring(lastIndOfSlash + 1);
    }

    public static void main(String[] args) {
        FileNavigator fng = new FileNavigator();
        // adding files from a path
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries\\HW13.Dictionaries.iml");
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries\\new1.txt");
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries\\11.docx");
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries\\new1.txt");
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries\\11.docx");
        // test find method
        System.out.println("found files (that were added):" + fng.find("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries"));
        // try to add files from a dir, that have already been added
        // as it is seen from the output, we cannot add files, if they previously have already been added
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries");
        // test filterBySize
        System.out.println("Filtered by size: " + fng.filterBySize(50000000));
        //test remove
        fng.remove("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries");
        System.out.println("found files (that were added):" + fng.find("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries"));
        // adding files from a directory
        fng.add("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries");
        // testing files after adding from a directory
        System.out.println("found files (after adding):" + fng.find("E:\\JavaProjects\\HillelJavaHomeworks\\HW13.Dictionaries"));
        //sort by size
        fng.sortBySize();
        System.out.println("sorted by file size" + fng.sortBySize());
    }
}
