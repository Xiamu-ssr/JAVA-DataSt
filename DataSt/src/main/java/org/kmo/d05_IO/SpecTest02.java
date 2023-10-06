package org.kmo.d05_IO;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * XML文件互动
 * */
public class SpecTest02 {
    private final String filePath = "src/main/resources/FileIO/SpecTest02/hello.xml";
    private final String filePath2 = "src/main/resources/FileIO/SpecTest02/";

    public void clear(String path){
        File f = new File(path);
        f.delete();
    }

    @Test
    public void test01() throws Exception {
        //1.创建对象
        SAXReader saxReader = new SAXReader();
        //2.read for document
        Document read = saxReader.read(filePath);
        //3.get root element
        Element rootElement = read.getRootElement();
        System.out.println(rootElement.getName());
        //4.get first-order e
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
        }
        //5.get one user
        Element user = rootElement.element("user");
        //6.get user's subelement text
        System.out.println(user.elementText("name"));
        //7.get user's attribute
        System.out.println(user.attribute("id").getValue());
        System.out.println(user.attribute(0).getValue());
        //8.get user's all attribute
        List<Attribute> attributes = user.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName()+":"+ attribute.getValue());
        }
        //9.get user's all Text
        List<Element> elements1 = user.elements();
        for (Element element : elements1) {
            System.out.println(element.getName()+"->"+element.getText().trim());
        }

    }
}
