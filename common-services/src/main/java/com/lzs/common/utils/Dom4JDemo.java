package com.lzs.common.utils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2024-05-03 22:50:00
 */
public class Dom4JDemo {

    public static void main(String[] args) throws Exception {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        ClassLoader classLoader = Dom4JDemo.class.getClassLoader();
        Document document = reader.read(new File(classLoader.getResource("pepper.xml").getFile()));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element stu = (Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()){
                Element stuChild = (Element) iterator1.next();
//                System.out.println("节点名："+stuChild.getName()+"---节点值："+(stuChild.isTextOnly()?stuChild.getStringValue():""));
                System.out.println("节点名："+stuChild.getName());
                System.out.println(stuChild.getTextTrim());
            }
        }
    }

}
