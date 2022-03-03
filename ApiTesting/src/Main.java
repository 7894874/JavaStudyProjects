//import org.junit.runner.Request;
//
//package okhttp3.guide;
//
//import java.io.IOException;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//
//
//        Respond();
//

















//
//
//
//    }
//
//
//
//    private static void Respond() {
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://community-open-weather-map.p.rapidapi.com/forecast?q=san%20francisco%2Cus&units=metric&lang=en&cnt=2&id=13244")
//                .get()
//                .addHeader("x-rapidapi-key", "290bc2eb7amshb5b9def75e2b37ap1afae3jsn3330fd771dc0")
//                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//
//    }
//
//
//}
