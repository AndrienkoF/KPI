import wikipediaapi
from wiki_itemXML import ItemXML

class ItemWikiApi:
    def __init__(self, categoryName, summary, url, title, text):
        self.categoryName = categoryName
        self.summary = summary
        self.url = url
        self.title = title
        self.text = text


class WikiApi:
    def __init__(self, category):
        self.category = category
        self.wiki_wiki = wikipediaapi.Wikipedia('en')

    def print_sections(self, sections, summary, url, categoryName, level=0):
        for s in sections:
            self.print_sections(s.sections, summary, url, categoryName, level + 1)
            item = ItemWikiApi(categoryName, summary, url, s.title, s.text)
            ItemXML().updateXML(item, self.filename)


    def print_categorymembers(self, categorymembers, level=0, max_level=0):
        for c in categorymembers.values():
            self.filename = "xmls/" + str(c.pageid) + '.xml'
            if self.filename.find("Category:") == -1:
                print("Title: %s" % (c.title))
                page_py = self.wiki_wiki.page(c.title)
                print("URL: %s" % (page_py.fullurl))
                ItemXML().createXML(self.filename)
                self.print_sections(page_py.sections, page_py.summary, page_py.fullurl, c.title)
            if c.ns == wikipediaapi.Namespace.CATEGORY and level <= max_level:
                self.print_categorymembers(c.categorymembers, level + 1)

    def main(self):
        cat = self.wiki_wiki.page(self.category)
        self.print_categorymembers(cat.categorymembers)
