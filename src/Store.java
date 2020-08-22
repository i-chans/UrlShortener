import java.util.HashMap;
import java.util.Map;

final class Store {

    private final Map<String,String> urlStore = new HashMap<>();

    boolean saveUrl (String userUrl , String shortUrl){
        urlStore.put(userUrl , shortUrl);
        urlStore.put(shortUrl , userUrl);
        return true;
    }

    String getUrl(String url){
        if(url == null || url.length() == 0) return "Invalid Url";
        return urlStore.get(url);
    }

}
