public class Codec {

    private String baseUrl = "http://tinyurl.com/";
    Map<Integer,String> encodeMap = new HashMap<>();
    private int counter = 1;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        encodeMap.put(counter, longUrl);
        return baseUrl + "" + counter++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.valueOf(shortUrl.replace(baseUrl, ""));
        return encodeMap.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));