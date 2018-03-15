import xml.etree.cElementTree as ET  
import lxml.html
from lxml import etree

class ItemXML2():
    def createXML(self, item, filename):
        root = ET.Element("contents")
        for i in range(0,10):
            part = ET.SubElement(root, "part", title=item.title[i])
            ET.SubElement(part, "chapter", image=item.img[i]) 
        tree = ET.ElementTree(root)
        tree.write(filename)

    def convertToHTML(self, filenameXML, filenameXSLT):
        xslt_doc = etree.parse(filenameXSLT)
        xslt_transformer = etree.XSLT(xslt_doc)
        source_doc = etree.parse(filenameXML)
        output_doc = xslt_transformer(source_doc)
        output_doc.write("rozetka.html", pretty_print=True)
    
