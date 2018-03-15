class ItemRozetka():
    def __init__(self, title, img):
        self.title = title
        self.img = img


class RozetkaSpider():
    def parser(self, response):
        title = response.xpath('//*[@id="catalog_goods_block"]/div/div/div/div/div/div/div/a/text()')
        # price = response.xpath('//*[@class="g-price g-price-cheaper"]/div')
        img = response.xpath('//*[@class="g-i-tile-i-image fix-height with-variants"]/a/img/@src')
        item = ItemRozetka(title, img)
        return item

