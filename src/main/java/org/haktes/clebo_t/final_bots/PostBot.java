package org.haktes.clebo_t.final_bots;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostBot {

	public static void SendTest() {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://clebot.haktes.org/");

		String json = "{\"id\":1,\"name\":\"John\"}";
		StringEntity entity;
		try {
			entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			CloseableHttpResponse response = client.execute(httpPost);
			System.out.println("Status: " + response.getStatusLine().getStatusCode());

			HttpEntity responseEntity = response.getEntity();
			// Read the contents of an entity and return it as a String.
			String content = EntityUtils.toString(responseEntity);
			System.out.println(content);

			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
