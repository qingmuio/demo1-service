package io.qingmu.demo1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(21_000-9_000);
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request build = new Request.Builder().get()
                .url("https://gateway.qingmu.io/demo1-service/hello2")
                .build();
        while (true){

            try{
                final long timeMillis = System.currentTimeMillis();
                final Response response = okHttpClient.newCall(build).execute();
                final ResponseBody body = response.body();
                System.out.println(body.byteString() + ",--->耗时："+(System.currentTimeMillis()-timeMillis) +" ms");

                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println("error");
            }

        }

    }
}
