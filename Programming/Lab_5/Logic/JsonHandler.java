package logic;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import elements.Person;

public class JsonHandler implements Closeable {
    private Scanner input;
    private BufferedOutputStream output;
    private File file;

    public JsonHandler(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        input = new Scanner(new FileInputStream(file));
        output = new BufferedOutputStream(new FileOutputStream(file, true));

    }

    private String readFileAsString() {
        String res = "";
        while (input.hasNextLine()) {
            res += input.nextLine() + '\n';
        }
        return res;
    }


    public void clear() throws IOException {
        new FileOutputStream(file).close();
    }

    public void writeData(Hashtable collection) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        byte[] buf = mapper.writeValueAsBytes(collection);
        output.write(buf);
        output.flush();
    }

    public void write(String text) throws IOException {
        byte[] buf = text.getBytes();
        output.write(buf);
        output.flush();
    }

    public Hashtable readCollection() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Hashtable<String, Person>> typeRef = new TypeReference<>() {
        };
        String res = readFileAsString();
        mapper.registerModule(new JavaTimeModule());
        if (res.isBlank()) {
            return new Hashtable<String, Person>();
        }
        return mapper.readValue(res, typeRef);
    }

    @Override
    public void close() throws IOException {
        output.close();
        input.close();
    }
}
