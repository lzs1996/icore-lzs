package com.lzs.common.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author :liuzhensheng
 * @description :
 * @create :2024-05-03 23:36:00
 */
public class XMLTraversalExample {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("common-services/src/main/resources/stu.xml");
            test002(document.getDocumentElement());
            traverse(document.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void traverse(Node node) {

        NodeList nodeList = node.getChildNodes();
        for (int i = 0;i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                test002(childNode);
            }
        }
    }

    public static void test002(Node node){
        String nodeName = node.getNodeName();
        String nodeValue = node.getTextContent();
        System.out.println("节点名: " + nodeName +", 节点值：" + nodeValue);
    }
}
