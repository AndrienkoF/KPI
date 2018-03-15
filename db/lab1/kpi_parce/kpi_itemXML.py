import xml.etree.cElementTree as ET


class ItemXML():
    def createXML(self, item, filename):
        root = ET.Element("data")
        fragment = ET.SubElement(root, "page", url=item.url)
        for i in range(len(item.title)):
            ET.SubElement(fragment, "fragment", type="text").text = item.title[i]
        for i in range(len(item.img)):
            ET.SubElement(fragment, "fragment", type="image").text = item.img[i]
        tree = ET.ElementTree(root)
        tree.write(filename)
    
    def updateXML(self, item, filename):
        tree = ET.parse(filename)  
        root = tree.getroot()
        fragment = ET.SubElement(root, "page", url=item.url)
        for i in range(len(item.title)):
            ET.SubElement(fragment, "fragment", type="text").text = item.title[i]
        for i in range(len(item.img)):
            ET.SubElement(fragment, "fragment", type="image").text = item.img[i]
        tree = ET.ElementTree(root)
        tree.write(filename)
    
    def searchMAXTextXML(self, filename):
        tree = ET.parse(filename)  
        root = tree.getroot()
        maxQTextFrag = 0
        pageBlocks = root.findall(".//page[@url]")
        for page in pageBlocks:
            textFragment = page.findall(".//*[@type='text']")
            if maxQTextFrag < len(textFragment):
                maxQTextFrag = len(textFragment)
                urlmaxQTextFrag = page.get('url') 
        print("Max quantity of text = {0}" .format(maxQTextFrag))
        print("Max quantity of text (url) = {0}" .format(urlmaxQTextFrag))