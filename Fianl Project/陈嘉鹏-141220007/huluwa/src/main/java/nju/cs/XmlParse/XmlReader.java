package nju.cs.XmlParse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenjiapeng
 * @Description
 *            用于解析资源文件中信息统计中的xml文件，并动态加载其中对应的资源，
 *            以避免部分游戏信息写死在程序中。
 * @date 2018-01-06
 */
public class XmlReader {
    static Logger logger = Logger.getLogger("XmlReader");

    private static Document parse2Document(String filename){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            InputStream in = new FileInputStream(new File(filename));
//            InputStream in = XmlReader.class.getResourceAsStream(filename);
            document = reader.read(in);
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "读取xml文件发生异常" + ", filepath: " + filename);
            e.printStackTrace();
        }
        return document;
    }

    @SuppressWarnings("unchecked")
    public static <T> void castArray(T[] dst, XmlParse[] xmlParses){

        for(int i = 0; i < xmlParses.length; ++i)
            dst[i] = (T) xmlParses[i];

    }

    public static <T extends XmlParse> XmlParse[] parse(String filename, Class<T> tClass){
        ArrayList<XmlParse> data = new ArrayList<XmlParse>();
        try{
            XmlParse t = tClass.newInstance();
            Document document = parse2Document(filename);
            Element root = document.getRootElement();

            for(Iterator i = root.elementIterator(); i.hasNext();){
                Element ele = (Element)i.next();
                data.add(t.parseElement(ele));
            }

        }
        catch (Exception e){
            logger.log(Level.SEVERE, "xml文件解析异常");
            e.printStackTrace();
        }
        logger.info("XML Parse, parse " + filename);
        return data.toArray(new XmlParse[0]);
    }

}
