import xml.etree.cElementTree as ET


class ItemXML():
    def createXML(self, filename):
        root = ET.Element("data")
        tree = ET.ElementTree(root)
        tree.write(filename, encoding='utf-8', xml_declaration=True)

    def updateXML(self, item, filename):
        tree = ET.parse(filename)
        root = tree.getroot()
        if root.find(".//page[@url='" +item.url+ "']"):
            fragment = root.find(".//page[@url='" +item.url+ "']")
            ET.SubElement(fragment, "fragment", title=item.title, type="text").text = item.text
        else:
            fragment = ET.SubElement(root, "page", url=item.url, name=item.categoryName)
            ET.SubElement(fragment, "summary", type="text").text = item.summary
            ET.SubElement(fragment, "fragment", title=item.title, type="text").text = item.text
        tree = ET.ElementTree(root)
        tree.write(filename, encoding='utf-8', xml_declaration=True)
