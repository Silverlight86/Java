package Misc;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/*
 * Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure and returns all folder names that start with startingLetter. The XML format is given in the example below.

    For example, for the letter 'u' and an XML file:
    
    <?xml version="1.0" encoding="UTF-8"?>
    <folder name="c">
        <folder name="program files">
            <folder name="uninstall information" />
        </folder>
        <folder name="users" />
    </folder>
    the function should return a collection with items "uninstall information" and "users" (in any order).
 */

public class Folders {
  public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    List<String> result = new ArrayList<>();

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("folder");
    for (int i = 0; i < nList.getLength(); i++) {
      Node node = nList.item(i);
      Node nameItem = node.getAttributes().getNamedItem("name");
      if (nameItem.getNodeValue() != null && nameItem.getNodeValue().charAt(0) == startingLetter) {
        result.add(nameItem.getNodeValue());
      }
    }

    return result;
  }

  public static void main(String[] args) throws Exception {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<folder name=\"c\">"
                 + "<folder name=\"program files\">"
                 + "<folder name=\"uninstall information\" />"
                 + "</folder>"
                 + "<folder name=\"users\" />"
                 + "</folder>";

    Collection<String> names = folderNames(xml, 'u');
    for (String name : names)
      System.out.println(name);
  }
}
