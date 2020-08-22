import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

final class Reader {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String reader(String msg) throws IOException {
        System.out.println(msg);
        return br.readLine();
    }

}
