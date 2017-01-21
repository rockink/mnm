from flask import Flask
from flask import Flask
from flask import json
from flask import request
from flask import Response
from flask import jsonify
import requests
import json

app = Flask(__name__)

from clarifai import rest
from clarifai.rest import ClarifaiApp
from clarifai.rest import Image as ClImage
import json
from flask import request

cApp = ClarifaiApp()


@app.route('/')
def hello_world():
    return 'Hello World!'


# @app.route("/getrecipe", methods=["GET"])
def getrecipe(string):
    print("prinnting")
    str = jsonify({"count": 6, "recipes": [{"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/16632",
                                     "title": "Homemade Tomato Basil Pasta Sauce",
                                     "source_url": "http://allrecipes.com/Recipe/Homemade-Tomato-Basil-Pasta-Sauce/Detail.aspx",
                                     "recipe_id": "16632", "image_url": "http://static.food2fork.com/9974469b28.jpg",
                                     "social_rank": 99.01308896879686, "publisher_url": "http://allrecipes.com"},
                                    {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/32857",
                                     "title": "Tomato and Basil Pasta Sauce",
                                     "source_url": "http://allrecipes.com/Recipe/Tomato-And-Basil-Pasta-Sauce/Detail.aspx",
                                     "recipe_id": "32857", "image_url": "http://static.food2fork.com/65311165b6.jpg",
                                     "social_rank": 40.03519428497633, "publisher_url": "http://allrecipes.com"},
                                    {"publisher": "Tasty Kitchen", "f2f_url": "http://food2fork.com/view/c03648",
                                     "title": "Pasta with Fresh Tomato Basil Cream Sauce",
                                     "source_url": "http://tastykitchen.com/recipes/main-courses/pasta-with-fresh-tomato-basil-cream-sauce/",
                                     "recipe_id": "c03648",
                                     "image_url": "http://static.food2fork.com/TomatoCream173c1.jpg",
                                     "social_rank": 38.50838232405916, "publisher_url": "http://tastykitchen.com"},
                                    {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/e01fcc",
                                     "title": "Shrimp Pasta with Tomato Basil Sauce",
                                     "source_url": "http://allrecipes.com/Recipe/Shrimp-Pasta-With-Tomato-Basil-Sauce/Detail.aspx",
                                     "recipe_id": "e01fcc", "image_url": "http://static.food2fork.com/9558903647.jpg",
                                     "social_rank": 37.29133639924764, "publisher_url": "http://allrecipes.com"},
                                    {"publisher": "Tasty Kitchen", "f2f_url": "http://food2fork.com/view/b72a85",
                                     "title": "Tomato Basil Pasta Cream Sauce with Kielbasa Sausage & Mushrooms",
                                     "source_url": "http://tastykitchen.com/recipes/main-courses/tomato-basil-pasta-cream-sauce-with-kielbasa-sausage-mushrooms/",
                                     "recipe_id": "b72a85",
                                     "image_url": "http://static.food2fork.com/TomatoBasilPastaCreamSaucewithKielbasaSausageMushrooms410x27333fe.jpg",
                                     "social_rank": 36.74159520631872, "publisher_url": "http://tastykitchen.com"},
                                    {"publisher": "Tasty Kitchen", "f2f_url": "http://food2fork.com/view/f1f98c",
                                     "title": "Sun-Dried Tomato and Basil Pasta Sauce",
                                     "source_url": "http://tastykitchen.com/recipes/homemade-ingredients/sun-dried-tomato-and-basil-pasta-sauce/",
                                     "recipe_id": "f1f98c",
                                     "image_url": "http://static.food2fork.com/noimage2f00.recipeimage.gif",
                                     "social_rank": 34.824278384591125, "publisher_url": "http://tastykitchen.com"}]})

    # print(str)
    return str

    # global stringList
    # # Convert list to good format
    # if len(stringList) == 0:
    #     return "No ingredients in the input list"
    # # Connect to API
    # r = requests.get("""http://food2fork.com/api/search?key=c8f85723afc6d6858a0dab1004a76365&q=""" + stringList)
    # try:
    #     return str(r.text)
    # except Exception as e:
    #     return str(e)



@app.route('/getrecipe' , methods=['GET'])
def photos():
    # url = request.args.get('url')
    # model = cApp.models.get('general-v1.3')
    # image = ClImage(url=url)
    # response = model.predict([image])
    #
    # print(response)
    #
    # # response = jsonify(response)
    #
    # response = response['status']
    # print(response.outputs)
    #
    #
    # list = response.data.concepts
    # print(response.status)
    #
    # string = ""
    #
    # for item in list:
    #     string = string+"+"+item
    #
    # print(string)

    # return getrecipe(string)
    return getrecipe("")


@app.route("/getingredients", methods=["GET"])
def getingredients():
    global stringList
    return stringList


@app.route("/additem", methods=["GET"])
def additem():
    global stringList
    stringList = request.args.get('ingredients')
    return stringList


if __name__ == '__main__':
    app.run()
