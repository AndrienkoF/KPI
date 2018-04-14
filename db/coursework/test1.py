import requests
import json

payload = {'part': 'snippet', 'key': 'AIzaSyAxGiWN7YGdIZEFn6DQA4bUkUhdDxWXmnA',
            'chart' :'mostPopular', 'regionCode' :'UA', 'maxResults': 20}

l = requests.Session().get('https://www.googleapis.com/youtube/v3/videos', params=payload)
resp_dict = json.loads(l.content)
# print resp_dict['items']
for i in resp_dict['items']:
     print "Title: ",i['snippet']['title']
     print "Channel: ",i['snippet']['channelTitle']
     print "\n"
