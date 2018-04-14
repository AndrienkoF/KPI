import time

from wiki_api import WikiApi


class Main():
    def mainWikiApi(self):
        WikiApi("Category:Computer science").main()


if __name__ == '__main__':
    startTime = time.time()
    start = Main()
    start.mainWikiApi()
    endTime = time.time()
    print(str(endTime - startTime) + " seconds has passed.")
