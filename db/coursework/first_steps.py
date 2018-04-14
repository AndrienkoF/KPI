from flask import Flask
from flask_pymongo import PyMongo

app = Flask(__name__)

app.config['MONGO_DBNAME'] = 'subs_likes'
app.config['MONGO_URI'] = 'mongodb://sub_user:sub_user@ds221339.mlab.com:21339/subs_likes'

mongo = PyMongo(app)

@app.route('/add')
def add():
    user = mongo.db.users
    user.insert({'name' : 'Fedia', 'landuage' : 'JS'})
    user.insert({'name' : 'Oleg', 'landuage' : 'C'})
    user.insert({'name' : 'Keni', 'landuage' : 'Java'})
    user.insert({'name' : 'Ben', 'landuage' : 'C#'})
    return 'Added Users!'

@app.route('/find')
def find():
    user = mongo.db.users
    find = user.find_one({'name' : 'Oleg'})
    return 'You found ' + find['name'] + '\nFav lang is ' + find['landuage']

@app.route('/update')
def update():
    user = mongo.db.users
    find = user.find_one({'name' : 'Fedia'})
    find['landuage'] = 'JS'
    user.save(find)
    return 'Update User!'

@app.route('/delete')
def delete():
    user = mongo.db.users
    find = user.find_one({'name' : 'Oleg'})
    user.remove(find)
    return 'Remove user!'


if __name__ == '__main__' :
    app.run(debug=True)
