import java.io.*;

/**
 * Created by 217dr on 20.06.2017.
 */
public class CreateFile {

    private String fileName = null;

    public CreateFile(String fileName) {
        this.fileName = fileName;
    }

    public File createFile() throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println(fileName + " file is created.");
        } else {
            System.out.println(fileName + " file already exists.");
        }
        return file;
    }

    public File fillTheFile(File file) throws IOException {
        long start = System.currentTimeMillis();
        Writer fw = new BufferedWriter(new FileWriter(file), 2 * 2048);
        for (long i = 0; i <= 5; i++) {
            String str = new RandomString(8).nextString();
            fw.write(str + "\n");
        }
        fw.close();
        long elapsedTime = (System.currentTimeMillis() - start) / 60000;
        System.out.println(elapsedTime);
        return file;
    }


    public static void main(String[] args) throws IOException {
        CreateFile file = new CreateFile("E:\\first.txt");
        File myFile = file.createFile();
        file.fillTheFile(myFile);
    }

}
