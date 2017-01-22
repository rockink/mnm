# Name of the project. replace XX for the real name

##Summary
* What it does
* How it works
* What tech is used
* Who did this

##What it does
XX is a project that allows users to take a picture of food, identify ingredients and then get recipes.

##How it works
First the user takes a picture and submit it to the background of the project. The first part of the background uses Clarifai API for its amazing image recognizion to identify the name of the ingredients and the food theme.
Then the first part of the background sends this list of ingredients to the second part of the background which connects to Food2Fork API, returning relevant recipes with the above ingredients.
Finally, this information is send to the Android app and shown to users.

##What tech is used
For the first part of the backround we used Java.
For the second part of the background we used Python (Flask).

## Who did this
MNM is a project developed by My Nguyen, Nirmal Nepal and Marc Benedí.

