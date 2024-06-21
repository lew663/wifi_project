package zerobase.wifi.scraper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WifiScraper {

  private static final String URL = "http://openapi.seoul.go.kr:8088";
  private static final String KEY = "";
  private static final String TYPE = "json";
  private static final String SERVICE = "TbPublicWifiInfo";

  public static void main(String[] args) throws IOException {
    StringBuilder urlBuilder = new StringBuilder(URL); /*URL*/
    urlBuilder.append("/").append(URLEncoder.encode(KEY, StandardCharsets.UTF_8)); /*인증키 (sampler 호출시 제한됩니다.)*/
    urlBuilder.append("/").append(URLEncoder.encode(TYPE, StandardCharsets.UTF_8)); /*요청파일타입 (xml,fxml,xls,json) */
    urlBuilder.append("/").append(URLEncoder.encode(SERVICE, StandardCharsets.UTF_8)); /*서비스명 (대소문자 구분 필수입니다.)*/
    urlBuilder.append("/").append(URLEncoder.encode("1", StandardCharsets.UTF_8)); /*요청시작위치 (sample 사용시 5이내 숫자)*/
    urlBuilder.append("/").append(URLEncoder.encode("5", StandardCharsets.UTF_8)); /*요청종료위치(sample 사용시 5이상 숫자 선택 안 됨)*/
    // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

    URL url = new URL(urlBuilder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-type", "application/xml");
    System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
    BufferedReader rd;

    // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
      rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line);
    }
    rd.close();
    conn.disconnect();
    System.out.println(sb.toString());
  }
}
