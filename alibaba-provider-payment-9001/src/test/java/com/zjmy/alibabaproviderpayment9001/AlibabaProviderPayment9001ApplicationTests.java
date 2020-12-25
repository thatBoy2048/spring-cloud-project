package com.zjmy.alibabaproviderpayment9001;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class AlibabaProviderPayment9001ApplicationTests {


    public static void main(String[] args) throws IOException {
        String nacosUrl = "http://localhost:8848/nacos/v1/cs/configs?";
        Properties properties = new Properties();
        // 使用properties对象加载输入流
        properties.load((new FileInputStream("D:\\idea-Warehouse\\spring_cloud_project\\alibaba-provider-payment-9001\\src\\test\\java\\com\\zjmy\\alibabaproviderpayment9001\\resources\\application.properties")));
        //注册配置
        registerNacosConfig(properties, nacosUrl);
    }

    /**
     * 注册nacos配置
     */
    public static void registerNacosConfig(Properties properties, String nacosUrl) {
        properties.forEach((k, v) -> {
            final String kk = k.toString();
            final String vv = v.toString();
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("dataId", kk);
                params.add("namespace", "public");
                params.add("group", "SEATA_CONFIG_GROUP");
                params.add("content", vv);
                //发送Post数据并返回数据
                String resultVo = sendPostRequest(nacosUrl, params);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 向目的URL发送post请求
     *
     * @param url 目的url
     * @param params 发送的参数
     * @return ResultVO
     */
    public static String sendPostRequest(String url, MultiValueMap<String, String> params) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }

}
