package com.dom.food.ultilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

public class ImgBB {

    private String apiKey;

    @Value("${imgbb.apiKey}")
    public void setSecret(String apiKey) {
        this.apiKey = apiKey;
    }

    public ImgBB() {
    }

    public String upload(String imgString) throws JSONException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.imgbb.com/1/upload?key=" + apiKey);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("image", imgString));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();

            if (respEntity != null) {
                JSONObject jsonObject = new JSONObject(EntityUtils.toString(respEntity));
                return (jsonObject.getJSONObject("data").getString("display_url"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
