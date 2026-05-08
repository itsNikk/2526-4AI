package Exercises.SharedFileLogger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SharedLogger {

    private final FileWriter fw;
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public SharedLogger(String percorso) throws IOException {
        this.fw = new FileWriter(percorso, false);
    }

    public synchronized void writeToFile(String messaggio) {
        String riga = "[" + LocalTime.now().format(FMT) + "]"
                + " [" + Thread.currentThread().getName() + "] "
                + messaggio;
        try {
            fw.write(riga + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(riga);
    }

    public synchronized void close() {
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
