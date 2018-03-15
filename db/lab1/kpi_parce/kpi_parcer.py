class ItemKPI():
    def __init__(self, title, img, url):
        self.title = title
        self.img = img
        self.url = url

class KpiSpider():
    domain = 'http://kpi.ua'
    
    def parser(self, response, new_url):
        title = response.xpath('//*[@id="main"]//p/text()')
        img = response.xpath('//*[@id="main"]//@src')
        item = ItemKPI(title, img, new_url)
        return item
    
    def linkSelector(self, response):
        nextPage = response.xpath('//*[@id="main"]//a/@href')    
        return nextPage
            