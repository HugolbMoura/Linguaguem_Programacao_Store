import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OCamlInterface {
    public static void callOCaml() {
        ProcessBuilder builder = new ProcessBuilder("./cart_calculations");
        builder.redirectErrorStream(true);  // Redirect errors to standard output

        try {
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        callOCaml();
    }
}
