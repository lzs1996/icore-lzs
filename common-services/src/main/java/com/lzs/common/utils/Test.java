package com.lzs.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.io.ClassPathResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2024-05-03 20:38:00
 */
public class Test {
    public static void main(String[] args) {
        try {
//            // 创建XML Mapper
            XmlMapper xmlMapper = new XmlMapper();
            // 从XML字符串读取数据并解析为JsonNode
            ClassLoader classLoader = Test.class.getClassLoader();
            File xmlFile = new File(classLoader.getResource("pepper.xml").getFile());
            JsonNode jsonNode = xmlMapper.readTree(xmlFile);
            // 创建JSON Mapper
            ObjectMapper jsonMapper = new ObjectMapper();
            // 将JsonNode转换为JSON字符串
            String json = jsonMapper.writeValueAsString(jsonNode);
            System.out.println("JSON格式数据:");
            System.out.println(json);

//            System.out.println(xmlToJava());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String xmlToJava(){
        try {
            //读取Resource目录下的XML文件
            ClassPathResource resource = new ClassPathResource("pepper.xml");
//        Resource resource = new ClassPathResource("classpath:protocols/SubSystems.xml");
            //利用输入流获取XML文件内容
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder buffer = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            br.close();
            //XML转为JAVA对象
            return JSONObject.toJSONString(xmlToObject(buffer.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "解析错误";
    }


    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        try {
            xmlObject = unmarshaller.unmarshal(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (reader != null) {
            reader.close();
        }
        return xmlObject;
    }


    public static String xmlToObject(String xmlString) throws XMLStreamException, UnsupportedEncodingException, JAXBException {
        InputStream stream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
        JAXBContext jaxbContext2 = JAXBContext.newInstance(String.class);
        Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader someSource = factory.createXMLEventReader(stream);
        JAXBElement<String> userElement = jaxbUnmarshaller2.unmarshal(someSource, String.class);
        return userElement.getValue();
    }
}
