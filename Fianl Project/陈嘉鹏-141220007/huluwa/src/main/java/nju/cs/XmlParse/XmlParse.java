package nju.cs.XmlParse;

import org.dom4j.Element;

/**
 * @author chenjiapeng
 * @Description
 *          解析接口，要解析的类型需要实现对于单个Element元素的解析
 * @date 2018-01-06
 */
public interface XmlParse {
    public XmlParse parseElement(Element e);
}
