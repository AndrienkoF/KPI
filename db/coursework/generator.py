from pymongo import MongoClient
from bson.objectid import ObjectId
import generator
import random
import time

def strTimeProp(start, end, format, prop):
    stime = time.mktime(time.strptime(start, format))
    etime = time.mktime(time.strptime(end, format))

    ptime = stime + prop * (etime - stime)

    return time.strftime(format, time.localtime(ptime))


def randomDate(start, end, prop):
    return strTimeProp(start, end, '%m/%d/%Y', prop)


if __name__ == '__main__':
    client = MongoClient('mongodb://localhost:27017/')
    db = client.course_work
    channels = db.channels
    videos = db.videos
    trends = db.trends

    list_channels = []

    # for channel in channels.find():
    #     list_channels.append(channel["_id"])

    # CREATED TRENDS
    for k in range(1,6):
        month = str(k)
        if k < 10:
            month = "0" + month

        list_videos = []
        for i in range(1,21):
            rday = random.randint(1,30)
            day = month + "/" + str(rday) + "/2018"
            if rday < 10:
                day = month + "/" + "0" + str(rday) + "/2018"
            video = videos.find_one({"date_created": day})
            if video != None:
                list_videos.append(video["_id"])

        trend = {
            "date": month + "/2018",
            "video_id_list": list_videos
        }
        trends.insert_one(trend)




    # CREATED VIDEOS
    # for i in range(10000):
    #     video = {"date_created": randomDate("12/06/2015", "12/06/2018", random.random()),
    #                 "likes": random.randint(1,50000),
    #                 "dislikes": random.randint(1,500000),
    #                 "views": random.randint(1,1000000),
    #                 "channel_id": ObjectId(list_channels[random.randint(1,498)])
    #                 }
    #     videos.insert_one(video)

    # CREATED CHANNELS
    # for i in range(1, 500):
    #     channel = {"date_created": randomDate("12/06/2008", "12/06/2015", random.random()),
    #     "num_subs": random.randint(1,5000000)}
    #     channels.insert_one(channel)
