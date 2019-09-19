package io.qingmu.demo1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final RestTemplate restTemplate = new RestTemplate();
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request build = new Request.Builder().get()
                .url("https://gateway.qingmu.io/demo1-service/hello2")
                .build();
        while (true){

            try{
                final Response response = okHttpClient.newCall(build).execute();
                final ResponseBody body = response.body();
                System.out.println(body.byteString());
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println("error");
            }

        }

    }
}
