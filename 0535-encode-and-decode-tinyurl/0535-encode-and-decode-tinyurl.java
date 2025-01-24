public class Codec {

    private int id = 0;
    private static final String URL = "http://tinyurl.com/";
    private Map<Integer, String> map = new HashMap<>(); 

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(id, longUrl);
        return (URL + id++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int id = Integer.parseInt(shortUrl.replace(URL, ""));
        return map.get(id);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));