import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        Store store = new Store();
        UrlGenerator urlGenerator = new UrlGenerator(store);
        Reader read = new Reader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int userInput;
        boolean entry = true;

        String message = "1. Create a Shortened URL\n" +
                "2. Fetch an URL\n" +
                "3. Exit";

        while(entry){

            userInput = Integer.parseInt(read.reader(message));

            if(userInput == 1)
                System.out.println(urlGenerator.createUrl(read.reader("Enter an url")));
            else if (userInput == 2)
                System.out.println(store.getUrl(read.reader("Enter an url")));
            else if (userInput == 3)
                entry = false;

        }

    }
}
