from flask import Flask
from flask import (
    Blueprint, flash, g, redirect, render_template, request, session, url_for
)

app = Flask(__name__)
client = MongoClient('mongodb://localhost:27017/')
db = client.course_work
channels = db.channels
videos = db.videos
trends = db.trends

@app.route("/", methods=('GET', 'POST'))
def index():
    
    return render_template('index.html', test=test)


if __name__ == '__main__':
    app.run(debug=True)
