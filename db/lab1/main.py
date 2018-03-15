import random
from urllib.request import urlopen

from lxml import etree

from kpi_parce.kpi_itemXML import ItemXML
from kpi_parce.kpi_parcer import KpiSpider
from rozetka_parce.rozetka_parcer import RozetkaSpider
from rozetka_parce.rozetka_itemXML import ItemXML2


class Main():
    def mainKpi(self):
        start_url =  "http://kpi.ua/en/mainpage"
        filename = "kpi.xml"

        response = etree.parse(urlopen(start_url), etree.HTMLParser())
        spider = KpiSpider()
        
        parcedItem = spider.parser(response, start_url)
        ItemXML().createXML(parcedItem, filename)
        
        for i in range(1,10):
            nextPage = spider.linkSelector(response)
            if nextPage:
                numPage = random.randint(1,30)
                response = etree.parse(urlopen(spider.domain + nextPage[numPage]), etree.HTMLParser())
                ItemXML().updateXML(spider.parser(response, nextPage[numPage]), filename)
        
                print(spider.domain + nextPage[numPage])

        ItemXML().searchMAXTextXML(filename)
           
            #-------------VAR1---------------------------------------------------------------------            
            # nextPageLinkSelector = 'http://kpi.ua/en/mainpage?page=%s'%i
            # if nextPageLinkSelector:
            #     print(nextPageLinkSelector)
            #     response = etree.parse(urlopen(nextPageLinkSelector), etree.HTMLParser())
            #     ItemXML().updateXML(spider.parser(response, nextPageLinkSelector), filename)

            #-------------VAR2---------------------------------------------------------------------
            # nextPageLinkSelector = response.xpath('//*[@id="block-system-main"]/div/div/div[2]/ul/li[%s]/a/@href'%random.randint(1,20))

            # if nextPageLinkSelector:
            #     print(domain + nextPageLinkSelector[0])
            #     response = etree.parse(urlopen(domain + nextPageLinkSelector[0]), etree.HTMLParser())
            #     ItemXML().updateXML(spider.parser(response, nextPageLinkSelector[0]))
        

        
    def mainRosetka(self):
        start_url =  "https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/"
        filenameXML = "rozetka.xml"
        filenameXSLT = "rozetka.xslt"

        response = etree.parse(urlopen(start_url), etree.HTMLParser())
        spider = RozetkaSpider()
        item = spider.parser(response)

        ItemXML2().createXML(item, filenameXML)
        ItemXML2().convertToHTML(filenameXML, filenameXSLT)
        
        
if __name__ == '__main__':
    start = Main()
    # start.mainKpi()
    start.mainRosetka()
