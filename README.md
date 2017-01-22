# Foodify

##Summary
* Inspiration
* What it does
* How it works
* What tech is used
* Who did this

## # Foodify

##Summary
* Inspiration
* What it does
* How it works
* What tech is used
* Who did this


##Inspiration
Remember that frustration when you see a delicious dish somewhere but don’t know the name nor how to cook it? Gone are the days with our Foodify app. 

##What it does
Foodify is a project that allows users to take a picture of food, identify ingredients and then get recipes.

##How it works
First the user takes a picture and submit it to the background of the project. The first part of the background uses Clarifai API with its visual recognizion to identify the name of the ingredients and the food theme.
Then the first part of the background sends this list of ingredients to the second part of the background which connects to Food2Fork API, returning relevant recipes with the above ingredients and themes.
Finally, this information is sent to the Android app and shown to users.

##What tech is used
For the first part of the backround we used Java.
For the second part of the background we used Javascript (NodeJS).
The app is developed in Android Studio

## Who did this
Foodify is a project developed by My Nguyen, Nirmal Nepal and Marc Benedí.

