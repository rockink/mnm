from flask import Flask
from flask import json
from flask import request
from flask import Response
from flask import jsonify
import requests

app = Flask(__name__)

ingredients = []

@app.route("/")
def index():
    return "Welcome to Future!"

@app.route("/getrecipe", methods=["GET"])
def getrecipe():
    global ingredients
    #Convert list to good format
    if len(ingredients) == 0:
        return "No ingredients in the input list"
    ing_list = ingredients[0]
    for x in ingredients[1:]:
        ing_list = ing_list + '+'+x
    #Connect to API
    r = requests.get("""http://food2fork.com/api/search?key=c8f85723afc6d6858a0dab1004a76365&q="""+ing_list)
    try:
        return str(r.text)
    except Exception as e:
        return str(e)

@app.route("/getingredients", methods=["GET"])
def getingredients():
    ing = ""
    for x in ingredients:
        ing = ing + x
    return ing

@app.route("/clear")
def clear():
    global ingredients
    ingredients = []
    return "OK"

@app.route("/additem/<string:item>", methods=["GET"])
def additem(item):
    global ingredients
    ingredients.append(item)
    return item

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
