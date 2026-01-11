public class Codec {

    private Map<String, String> map = new HashMap<>();
    private int id = 0;
    private final String base = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(id++);
        map.put(key, longUrl);
        return base + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(base, "");
        return map.get(key);
    }
}

