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

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostBot {

	public static void SendTest() {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://clebot.haktes.org/");

		//String json = "{\"id\":1,\"name\":\"John\"}";

		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(new testData("Robert", "Fico", "Saso"));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	private static class testData {
		String name = "Fred";
		String sureName = "Krieg";
		String role = "testRole";

		public testData(String name, String sureName, String role) {
			super();
			this.name = name;
			this.sureName = sureName;
			this.role = role;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSureName() {
			return sureName;
		}

		public void setSureName(String sureName) {
			this.sureName = sureName;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

	}

}
