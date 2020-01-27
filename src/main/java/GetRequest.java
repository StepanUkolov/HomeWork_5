
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {
    static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) {

        CloseableHttpResponse resp1 = null;

        try {

            //Создаем клиента
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //Записываем Get запрос
            HttpGet httpGet = new HttpGet(sURL + "/checkTexts?text=диномическая&text=мадель+роботизиравоной+платформы");

            //Получаем xml ответ с сервера
            resp1 = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(resp1.getEntity()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
            //Закрываем поток
                resp1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
