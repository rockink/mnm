from flask import Flask

app = Flask(__name__)

from clarifai import rest
from clarifai.rest import ClarifaiApp
from clarifai.rest import Image as ClImage
import json

cApp = ClarifaiApp()


@app.route('/')
def hello_world():
    return 'Hello World!'


@app.route('/photos')
def photos():
    model = cApp.models.get('general-v1.3')
    image = ClImage(url='https://samples.clarifai.com/metro-north.jpg')
    response = model.predict([image])
    print(response)
    return json.dumps(response)


if __name__ == '__main__':
    app.run()
