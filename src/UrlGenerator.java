import java.util.Random;
import java.util.stream.Stream;

class UrlGenerator {

    private static class Pair {

        private final int min;
        private final int max;

        Pair(final int min, final int max) {
            this.min = min;
            this.max = max;
        }

    }

    private final Pair small = new Pair(65, 91);
    private final Pair large = new Pair(97, 122);
    private final Random r = new Random(System.currentTimeMillis());
    private final Store store;
    private final String MYDOMAIN = "www.can.co/";

    UrlGenerator(Store store) {
        this.store = store;
    }


    private String generate () {

        return MYDOMAIN + Stream.generate(() -> {
            int coin = r.ints(1, 0, 2).findFirst().getAsInt();
            return (coin == 0) ? small : large;
        }).map(pair -> {
            int v = r.ints(1, pair.min, pair.max).findFirst().getAsInt();
            return Character.toString((char) v);
        })
                .limit(10)
                .reduce("",(a,b) -> a+b);

    }



    String createUrl(String userUrl){

        String previousShortUrl = store.getUrl(userUrl);
        if (previousShortUrl != null) return previousShortUrl;

        String shortUrl = generate();

        while (!store.saveUrl(userUrl, shortUrl)) {
            shortUrl = generate();
        }

        return shortUrl;
    }

}


