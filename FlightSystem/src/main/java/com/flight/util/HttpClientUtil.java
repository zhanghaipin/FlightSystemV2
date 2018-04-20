package com.flight.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public static String doGet(String url, Map<String, String> param) {

		String resultString = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();
			HttpGet httpGet = new HttpGet(uri);
//			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36");
//			httpGet.setHeader("Upgrade-Insecure-Requests", "1");
//			httpGet.setHeader("If-None-Match", "W/\"d015-xPprfdof9EVd5T1QspTIAg\"");
//			httpGet.setHeader("Host", "flight.qunar.com");
//			httpGet.setHeader("Cookie","QN99=1605; QN1=eIQjmVq8YRVfwZepVZkJAg==; _i=RBTKSfH-inKxBegx6zXoF9NERmqx; QN269=7962D060220511E8ACB5FA163E233FC1; QunarGlobal=10.86.213.127_7b357813_1626fb1972d_38c5|1522295100251; QN601=e585676e2280e22e38d949092bd026ee; QN48=tc_aaa683e26ee06f1a_1626fdbdcc0_680d; QN170=183.36.82.157_8f8fe0_0_%2F3E8O1QhwH0EJKFkUcAxnWDKK%2F%2BawLC9Dn338UcxTj8%3D; F235=1523622706815; QN205=s%3Dbaidu; QN277=s%3Dbaidu; csrfToken=qnPX1NV32uaFoUEF8YtHuxcMWZT47DFq; QN163=0; PHPSESSID=ta9agrr0br58mu1pgmtjk1mm72; _vi=2wA3LAvFtz2g53kVFyx_25oefEPGQyiZE5UvItjhb4jHu2d5PsZSz21rrm3a6PQRG8hFRNdkoH_ctTCQxQClPHo59RFc3UsrKqNZSmhCceWrlmrdQ_-zWcjVk_x8hmWGFsrRml75UYAjXOCYJ_8Dy9M76OcFE7r1DKK_pDA9z-4W; Hm_lvt_75154a8409c0f82ecd97d538ff0ab3f3=1522295102,1523622739; Hm_lpvt_75154a8409c0f82ecd97d538ff0ab3f3=1523622739; QN621=1490067914133%3DDEFAULT%26fr%3Dqunarindex; QN667=B; QN668=51%2C55%2C52%2C53%2C56%2C52%2C53%2C59%2C56%2C50%2C50%2C50%2C51");
//			httpGet.setHeader("Connection", "keep-alive");
//			httpGet.setHeader("Cache-Control", "max-age=0");
//			httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8");
//			httpGet.setHeader("Accept-Encoding", "gzip, deflate");
//			httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {		
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}
	
	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}
}
