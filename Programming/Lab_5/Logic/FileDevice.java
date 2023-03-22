package Logic;

import Elements.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class FileDevice {
    private Scanner reader;
    private BufferedOutputStream output;
    private String fileName;

    public FileDevice(String fileName) throws FileNotFoundException {
        reader = new Scanner(new FileInputStream(fileName));
        output = new BufferedOutputStream(new FileOutputStream(fileName, true));
        this.fileName = fileName;
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

    public void clear() throws IOException {
        new FileOutputStream(fileName).close();
    }

    public void writeData(HashMap collection) throws IOException{
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        byte[] buf = writer.writeValueAsBytes(collection);
        output.write(buf);
        output.flush();
    }

    public void write(String text) throws IOException {
        byte[] buf = text.getBytes();
        output.write(buf);
        output.flush();
    }

    public HashMap readCollection() throws IOException {
        return new ObjectMapper().readValue(readFileAsString(),
               // new TypeReference<Map<String, Person>>(){}
        HashMap.class);
    }
}
