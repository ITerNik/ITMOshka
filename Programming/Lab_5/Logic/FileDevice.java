package Logic;

import Elements.*;

import java.io.*;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class FileDevice {
    private Scanner reader;
    private BufferedOutputStream output;

    public FileDevice(String fileName) throws FileNotFoundException {
        reader = new Scanner(new FileInputStream(fileName));
        output = new BufferedOutputStream(new FileOutputStream(fileName, true));
    }

    public String readFileAsString() {
        String res = "";
        while (reader.hasNextLine()) {
            res += reader.nextLine() + '\n';
        }
        return res;
    }

    public Person[] getDataFromString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Person[] data = mapper.readValue(readFileAsString(), Person[].class);
            return data;
        } catch (IOException e) {
            System.out.println("Проблемы с чтением из файла");
            return new Person[]{};
        }
    }

    public void writeData(Person[] collection) {
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            byte[] buf = writer.writeValueAsBytes(collection);
            output.write(buf);
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
    }
}
