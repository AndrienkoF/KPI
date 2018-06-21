from flask import Flask
from flask import (
    Blueprint, flash, g, redirect, render_template, request, session, url_for
)
from pymongo import MongoClient
from bson.objectid import ObjectId
import pandas as pd
import numpy as np

app = Flask(__name__)
client = MongoClient('mongodb://localhost:27017/')
db = client.course_work
channels = db.channels
videos = db.videos
trends = db.trends

@app.route("/", methods=('GET', 'POST'))
def index():
    if request.method == 'GET':
        trends_list = []
        for y in range(2016, 2019):
            for m in range(1, 13):
                if m < 10:
                    m = "0" + str(m)
                    trend = trends.find_one({"date": str(m) + "/" + str(y)})
                else:
                    trend = trends.find_one({"date": str(m) + "/" + str(y)})
                if trend is not None:
                    trends_list.append(trend["video_id_list"])

        views_per_month = []
        for y in range(len(trends_list)):
            num = 0
            for l in range(len(trends_list[y])):
                video = videos.find_one(trends_list[y][l])
                num = num + video["views"]
            views_per_month.append(num)
        response = {
            "all_views": views_per_month
        }
        return render_template('index.html', response = response)

    if request.method == 'POST':
        video_id = request.form['video_id']
        return redirect('/video_info?id=' + video_id)

@app.route("/video_info", methods=('GET', 'POST'))
def video_info():
    if request.method == 'GET':
        video_id = request.args.get('id')
        video_info = videos.find_one({"_id": ObjectId(video_id)})
        channel_info = channels.find_one({"_id": video_info["channel_id"]})
        response = {
            "id": video_info["_id"],
            "date": video_info["date_created"],
            "likes": video_info["likes"],
            "dislikes": video_info["dislikes"],
            "views": video_info["views"],
            "channel": {
                "id": channel_info["_id"],
                "date": channel_info["date_created"],
                "subs": channel_info["num_subs"]
            }
        }
        return render_template('videoInfo.html', response = response)

@app.route("/trend_stat", methods=('GET', 'POST'))
def trend_stat():
    if request.method == 'GET':
        trend = trends.find()
        frame = pd.DataFrame({'num': range(10), 'chars': ['a']*10})
        print(trend)
        response = {

        }
        return render_template('trendsStatistic1.html', response = response)

    if request.method == 'POST':
        channels_list = []
        trends_list = []
        chn = []
        nm = []
        year = request.form['year']
        for m in range(1,13):
            if m < 10:
                m = "0" + str(m)
            for trend in trends.find({"date": str(m) + "/" + str(year)}):
                for video_id in trend["video_id_list"]:
                    channel_id = videos.find_one({"_id": video_id})["channel_id"]
                    channels_list.append(channel_id)

        counter = {}
        for elem in channels_list:
            counter[elem] = counter.get(elem, 0) + 1


        for element, count in counter.items():
            if count > 1:
                trends_list.append([element, count])

        trends_list.sort(key=lambda i: i[1], reverse=1)
        for i in range(len(trends_list)):
            chn.append(trends_list[i][0])
            nm.append(trends_list[i][1])

        frame = pd.DataFrame({'channel': chn, 'num': nm})
        frame.to_csv('trend_statistic' + str(year) + '.csv', header=True, index=None)

        return render_template('trendsStatistic1.html')


if __name__ == '__main__':
    app.run(debug=True)
