package flow;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.Input;
import objects.Output;

import java.io.File;
import java.io.IOException;


public final class InputFilesParserWriter {

    public InputFilesParserWriter() {
    }

    /**
     * Parseaza un fisier si returneaza informatiile din el in clasa
     * @param i = numarul testului
     * @return
     * @throws IOException
     */
    public Input parser(final int i) throws IOException {
        String fileName = "tests/test" + i + ".json";
        ObjectMapper objectMapper = new ObjectMapper();

        Input input = null;
        input = objectMapper.readValue(new File(fileName), Input.class);

        return input;
    }

    /**
     * Scrie in fisier din output, care contine rezultatele iteratiilor
     * @param i
     * @param childOut
     * @throws IOException
     */
    public void writer(final int i, final Output childOut) throws IOException {
        String fileName = "output/out_" + i + ".json";
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), childOut);
    }
}
