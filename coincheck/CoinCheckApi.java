package coincheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

public class CoinCheckApi {
	public static void main(String[] args) throws IOException {

		//CoinCheckのAPIの接続チェック
		String apiUrl = "https://coincheck.com/api/ticker";
		URL connectUrl = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) connectUrl.openConnection();
		System.out.println("レスポンスヘッダ:");
		System.out.println("レスポンスコード[" + con.getResponseCode() + "] " +
				"レスポンスメッセージ[" + con.getResponseMessage() + "]");

		//GETした結果をjson形式で出力する
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		if (null == encoding) {
			encoding = "UTF-8";

		}
		StringBuffer result = new StringBuffer();
		final InputStreamReader inReader = new InputStreamReader(in, encoding);
		final BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		// 1行ずつテキストを読み込む
		while ((line = bufReader.readLine()) != null) {
			result.append(line);
		}

		bufReader.close();
		inReader.close();
		in.close();

		System.out.println(result);

		 JSONObject json = new JSONObject(result.toString());
		 int last = json.getInt("last");
		 int bid = json.getInt("bid");
		 int ask = json.getInt("ask");
		 int low = json.getInt("low");
		 double volume = json.getDouble("volume");
		 int timestamp = json.getInt("timestamp");

		 List<Object> ticker = new ArrayList<Object>(Arrays.asList(last,bid,ask,low,volume,timestamp));

		 System.out.println(ticker);
	}
}
