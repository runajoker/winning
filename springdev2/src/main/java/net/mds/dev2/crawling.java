import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	public static void main(String[] args) throws ClientProtocolException, IOException {

		String ResponseText = "";

		@SuppressWarnings("deprecation")
		HttpClient client = new DefaultHttpClient();
		
		//url
		HttpGet get = new HttpGet("http://dominations.inven.co.kr/dataninfo/guide/?type=db&idx=141095");
		HttpResponse response = client.execute(get);
		HttpEntity resEntity = response.getEntity();
		if (resEntity != null) {
			ResponseText = EntityUtils.toString(resEntity, "UTF-8");
		}
		
		Document doc = Jsoup.parse(ResponseText);
		
		//selector
		Elements elements = doc.select("#dominationsDbGuideView > div > div > div > div > div");
		
		for(Element element : elements) {
			System.out.println("text"+element.text());
		}
	}

}
