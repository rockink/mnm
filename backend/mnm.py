from flask import Flask

app = Flask(__name__)

from clarifai import rest
from clarifai.rest import ClarifaiApp
from clarifai.rest import Image as ClImage
import json
from flask import request

cApp = ClarifaiApp()

l = set()
l.add("tomato")
l.add()


@app.route('/')
def hello_world():
    return 'Hello World!'


@app.route('/photos')
def photos():
    url = request.args.get('url')
    model = cApp.models.get('general-v1.3')
    image = ClImage(url=url)
    response = model.predict([image])
    print(response)
    return json.dumps(response)


if __name__ == '__main__':
    app.run()
