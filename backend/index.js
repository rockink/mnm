'use strict';

const Hapi = require('hapi');

// Create a server with a host and port
const server = new Hapi.Server();

var Clarifai = require('clarifai');
var base64 = require('base64-js');


server.connection({
    host: 'localhost',
    port: 8011
});



var app = new Clarifai.App(
  'U7NP_x68AbuhoFVj1zpIQ-87hwomwrL-AjTi-jhj',
  'KIm-Ew0ho9DJjo3DkWBqBOtb5Y4C-9nReephrL2B'
);


server.route({
    method: 'GET',
    path:'/hello',
    handler: function (request, reply) {

        return reply('hello world');
    }
});

// server.route({
//     method: 'GET',
//     path:'/getrecipe',
//     handler: function (request, reply) {
//
//       app.models.predict(Clarifai.FOOD_MODEL, "https://samples.clarifai.com/food.jpg").then(
//           function(response) {
//             // do something with response
//             return reply(response);
//           },
//           function(err) {
//             // there was an error
//           }
//         );
//
//     }
// });

server.route({
    method: 'GET',
    path:'/getrecipe',
    handler: function (request, reply) {

        // console.log(request.query.pic);

        // var send = 'iVBORw0KGgoAAAANSUhEUgAAAKAAAAB4CAIAAAD6wG44AAAAA3NCSVQICAjb4U/gAAADHUlEQVR4nO3dsU4UURSH8XPOXtm1NXaUJEbtTAx08CTGxtgY6HgReANewMpY+QAUaOsL8A4EhnssUBKFDHPj7GT3z/cr4e7ZgY8ZILMz64vFwobZ398fuPLG8fFx03rmL2N+ND0Ga4fA4ggsjsDiCCyOwOIILI7A4ggsjsDiCCyOwOIILI7A4nxvb2/g0sxsG+3etJ75y5hftre3Bz5A4/zoY5vPIVocgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcWV8/PzgUs3NzebRg+fzPzlzXeuD9aezyFaHIHFEVjcaIHdurQwM297adj/Sgvzzqym10mfeE2MFvgqNtyqp9VpDwpPame5kVailkmfeE2MVqNUc6tdROSke9LVrKZZya4Ge/A9RvupT+8sY5bdi7Mf4WZm78usacKr72dN63/Pz2KeaYuT7oI/Ke4a8bAW6TVqvP7T6WVpHH7WFviv+RknHXXvwTdFHIHFEVgcgcURWByBxRFYnB8eHg5c2n/+Mt3MatT49nQ+wna1yvj88UP/Eo3zu63z2YPFEVgcgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcX51tbWwKU7Ozs9n709H/zp65cRtqtVxrvnz/qX9G//Xaenp03rV3P+aFf43wZu2ogRPfiFrOYV+MuezyFaHIHFEVgcgcURWByBxRFYHIHFEVgcgcWNdo+OaqXkpZlVi7BurLEPiszO52HVM7hV1l2jBd6oF9ce6THLmj7dgeEqbJadW61RJ74H21oYrUQXkVZK1pz2sF9qeFoXhdtk3Wu0PdizuHXXXn6+fXPzkalOt9W0mV9fpocZkf/lu7u7Q5dKvGHyY5tfhu83q3mBM/P75/NvkjgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsDgCi+MNosXn+3w+9P7dBwcHTU9wdHTUtJ75y5hfWl8nMNzyJjN/+Hx+B4sjsDgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsLgy/CrV1bz+lfn989mDxRFYHIHFEVgcgcURWNwvL209KjxuvWMAAAAASUVORK5CYII=;                                                                                              nO3dsU4UURSH8XPOXtm1NXaUJEbtTAx08CTGxtgY6HgReANewMpY+QAUaOsL8A4EhnssUBKFDHPj                                                                                              7GT3z/cr4e7ZgY8ZILMz64vFwobZ398fuPLG8fFx03rmL2N+ND0Ga4fA4ggsjsDiCCyOwOIILI7A                                                                                              4ggsjsDiCCyOwOIILI7A4nxvb2/g0sxsG+3etJ75y5hftre3Bz5A4/zoY5vPIVocgcURWByBxRFY                                                                                              HIHFEVgcgcURWByBxRFYHIHFEVgcgcWV8/PzgUs3NzebRg+fzPzlzXeuD9aezyFaHIHFEVjcaIHd                                                                                              urQwM297adj/Sgvzzqym10mfeE2MFvgqNtyqp9VpDwpPame5kVailkmfeE2MVqNUc6tdROSke9LV                                                                                              rKZZya4Ge/A9RvupT+8sY5bdi7Mf4WZm78usacKr72dN63/Pz2KeaYuT7oI/Ke4a8bAW6TVqvP7T                                                                                              6WVpHH7WFviv+RknHXXvwTdFHIHFEVgcgcURWByBxRFYnB8eHg5c2n/+Mt3MatT49nQ+wna1yvj8                                                                                              8UP/Eo3zu63z2YPFEVgcgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcX51tbWwKU7Ozs9                                                                                              n709H/zp65cRtqtVxrvnz/qX9G//Xaenp03rV3P+aFf43wZu2ogRPfiFrOYV+MuezyFaHIHFEVgc                                                                                              gcURWByBxRFYHIHFEVgcgcWNdo+OaqXkpZlVi7BurLEPiszO52HVM7hV1l2jBd6oF9ce6THLmj7d                                                                                              geEqbJadW61RJ74H21oYrUQXkVZK1pz2sF9qeFoXhdtk3Wu0PdizuHXXXn6+fXPzkalOt9W0mV9f                                                                                              pocZkf/lu7u7Q5dKvGHyY5tfhu83q3mBM/P75/NvkjgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4                                                                                              AosjsDgCi+MNosXn+3w+9P7dBwcHTU9wdHTUtJ75y5hfWl8nMNzyJjN/+Hx+B4sjsDgCiyOwOAKL                                                                                              I7A4AosjsDgCiyOwOAKLI7A4AosjsLgy/CrV1bz+lfn989mDxRFYHIHFEVgcgcURWNwvL209Kjxu                                                                                              vWMAAAAASUVORK5CYII=';

        // var data = {
        //   base64 : 'iVBORw0KGgoAAAANSUhEUgAAAKAAAAB4CAIAAAD6wG44AAAAA3NCSVQICAjb4U/gAAADHUlEQVR4nO3dsU4UURSH8XPOXtm1NXaUJEbtTAx08CTGxtgY6HgReANewMpY+QAUaOsL8A4EhnssUBKFDHPj7GT3z/cr4e7ZgY8ZILMz64vFwobZ398fuPLG8fFx03rmL2N+ND0Ga4fA4ggsjsDiCCyOwOIILI7A4ggsjsDiCCyOwOIILI7A4nxvb2/g0sxsG+3etJ75y5hftre3Bz5A4/zoY5vPIVocgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcWV8/PzgUs3NzebRg+fzPzlzXeuD9aezyFaHIHFEVjcaIHdurQwM297adj/Sgvzzqym10mfeE2MFvgqNtyqp9VpDwpPame5kVailkmfeE2MVqNUc6tdROSke9LVrKZZya4Ge/A9RvupT+8sY5bdi7Mf4WZm78usacKr72dN63/Pz2KeaYuT7oI/Ke4a8bAW6TVqvP7T6WVpHH7WFviv+RknHXXvwTdFHIHFEVgcgcURWByBxRFYnB8eHg5c2n/+Mt3MatT49nQ+wna1yvj88UP/Eo3zu63z2YPFEVgcgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcX51tbWwKU7Ozs9n709H/zp65cRtqtVxrvnz/qX9G//Xaenp03rV3P+aFf43wZu2ogRPfiFrOYV+MuezyFaHIHFEVgcgcURWByBxRFYHIHFEVgcgcWNdo+OaqXkpZlVi7BurLEPiszO52HVM7hV1l2jBd6oF9ce6THLmj7dgeEqbJadW61RJ74H21oYrUQXkVZK1pz2sF9qeFoXhdtk3Wu0PdizuHXXXn6+fXPzkalOt9W0mV9fpocZkf/lu7u7Q5dKvGHyY5tfhu83q3mBM/P75/NvkjgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsDgCi+MNosXn+3w+9P7dBwcHTU9wdHTUtJ75y5hfWl8nMNzyJjN/+Hx+B4sjsDgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsLgy/CrV1bz+lfn989mDxRFYHIHFEVgcgcURWNwvL209KjxuvWMAAAAASUVORK5CYII='
        // };

        var data = {
          base64 : request.query.pic
        };

        console.log("----------------------DATA----------------------------------");
        console.log(data);

      app.models.predict(Clarifai.GENERAL_MODEL, data).then(
         function(response) {
           // do something with response
           reply(response);
         },
         function(err) {
           // there was an error
           reply(err);
          //  console.log(send);
         }
       );

    }

});


var request = require('superagent');


var getRecipe = function(list, reply){

  var query = "";
  var length = list.length > 5 ? 5 : list.length;
  for(var i = 0; i < length; i++){
    query  = query + "," + list[i];
  }

  console.log("LORD THIS IS IT!");
    request
      .get("http://food2fork.com/api/search?key=c8f85723afc6d6858a0dab1004a76365&q="+query)
      .end(function(err, res){

          if(err)console.error("THIS IS A HUGE ERROR"  + err);
          else {

            console.error("something is wrong data is not coming ");
            console.log(res.text);


            return reply(res.text);

          }

      });


};


server.route({
  method: 'GET',
  path: '/android',
  handler: function(request, reply){

    var fakeData = {
      "count": 13,
      "recipes":
      [
        {
          "publisher":
          "All Recipes",
          "f2f_url": "http://food2fork.com/view/32219", "title": "Terrific Turkey Chili", "source_url": "http://allrecipes.com/Recipe/Terrific-Turkey-Chili/Detail.aspx", "recipe_id": "32219", "image_url": "http://static.food2fork.com/121406cb64.jpg", "social_rank": 99.9999979241772, "publisher_url": "http://allrecipes.com"}, {"publisher": "Epicurious", "f2f_url": "http://food2fork.com/view/f00677", "title": "Zucchini and Corn Tacos", "source_url": "http://www.epicurious.com/recipes/food/views/Zucchini-and-Corn-Tacos-354249", "recipe_id": "f00677", "image_url": "http://static.food2fork.com/354249ce8a.jpg", "social_rank": 94.67769382505922, "publisher_url": "http://www.epicurious.com"}, {"publisher": "Bon Appetit", "f2f_url": "http://food2fork.com/view/50866", "title": "Chile-Corn Custard Squares", "source_url": "http://www.bonappetit.com/recipes/2009/06/chile_corn_custard_squares", "recipe_id": "50866", "image_url": "http://static.food2fork.com/mare_chile_corn_custard_squares_h2875.jpg", "social_rank": 80.68285909795597, "publisher_url": "http://www.bonappetit.com"}, {"publisher": "Epicurious", "f2f_url": "http://food2fork.com/view/82e1d4", "title": "Poblano and Mushroom Tacos", "source_url": "http://www.epicurious.com/recipes/food/views/Poblano-and-Mushroom-Tacos-355771", "recipe_id": "82e1d4", "image_url": "http://static.food2fork.com/355771787f.jpg", "social_rank": 68.83505220772952, "publisher_url": "http://www.epicurious.com"}, {"publisher": "Serious Eats", "f2f_url": "http://food2fork.com/view/31cc43", "title": "Dinner Tonight: Healthy and Delicious Braised Greens Tacos", "source_url": "http://www.seriouseats.com/recipes/2008/02/dinner-tonight-braised-greens-tacos.html", "recipe_id": "31cc43", "image_url": "http://static.food2fork.com/20080212dinnertonightgreentacose0a8.jpg", "social_rank": 59.04395893403631, "publisher_url": "http://www.seriouseats.com/"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/32824", "title": "Tofu Tacos I", "source_url": "http://allrecipes.com/Recipe/Tofu-Tacos-I/Detail.aspx", "recipe_id": "32824", "image_url": "http://static.food2fork.com/1507723181.jpg", "social_rank": 50.519601929460855, "publisher_url": "http://allrecipes.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/18026", "title": "Jollyrogers' Chilaquiles", "source_url": "http://allrecipes.com/Recipe/Jollyrogers-Chilaquiles/Detail.aspx", "recipe_id": "18026", "image_url": "http://static.food2fork.com/17676440c0.jpg", "social_rank": 46.95571929015768, "publisher_url": "http://allrecipes.com"}, {"publisher": "Epicurious", "f2f_url": "http://food2fork.com/view/6ede49", "title": "Chile-Corn Custard Squares", "source_url": "http://www.epicurious.com/recipes/food/views/Chile-Corn-Custard-Squares-353419", "recipe_id": "6ede49", "image_url": "http://static.food2fork.com/epicuriousfacebook511b.png", "social_rank": 40.376436045748875, "publisher_url": "http://www.epicurious.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/5fd95e", "title": "Vegetarian Black Bean Enchiladas", "source_url": "http://allrecipes.com/Recipe/Vegetarian-Black-Bean-Enchiladas/Detail.aspx", "recipe_id": "5fd95e", "image_url": "http://static.food2fork.com/10051870820.jpg", "social_rank": 39.0058682084061, "publisher_url": "http://allrecipes.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/8b6a37", "title": "Cinco de Mayo Casserole", "source_url": "http://allrecipes.com/Recipe/Cinco-De-Mayo-Casserole/Detail.aspx", "recipe_id": "8b6a37", "image_url": "http://static.food2fork.com/100498334dc.jpg", "social_rank": 36.53277389525525, "publisher_url": "http://allrecipes.com"}, {"publisher": "Bon Appetit", "f2f_url": "http://food2fork.com/view/50577", "title": "Poblano and Mushroom Tacos", "source_url": "http://www.bonappetit.com/recipes/quick-recipes/2009/11/poblano_and_mushroom_tacos", "recipe_id": "50577", "image_url": "http://static.food2fork.com/mare_poblano_and_mushroom_tacos_ve546.jpg", "social_rank": 35.565927843371426, "publisher_url": "http://www.bonappetit.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/2315", "title": "Bacon, Avocado and Cheese Omelet", "source_url": "http://allrecipes.com/Recipe/Bacon-Avocado-And-Cheese-Omelet/Detail.aspx", "recipe_id": "2315", "image_url": "http://static.food2fork.com/98591627d3.jpg", "social_rank": 35.18691939406289, "publisher_url": "http://allrecipes.com"}, {"publisher": "Cookstr", "f2f_url": "http://food2fork.com/view/45280", "title": "Beef and Bean Burritos", "source_url": "http://www.cookstr.com/recipes/beef-and-bean-burritos", "recipe_id": "45280", "image_url": "http://static.food2fork.com/recipe22592c91f.jpg", "social_rank": 34.80777735743579, "publisher_url": "http://www.cookstr.com"}]};
    return reply(fakeData);

  }
});


server.route({
    method: 'POST',
    path:'/getrecipe',
    handler: function (request, reply) {

        //THIS IS THE ONE THAT WE ARE GOING TO USE!


        // var fakeData = {
        //   "count": 13,
        //   "recipes":
        //   [
        //     {
        //       "publisher":
        //       "All Recipes",
        //       "f2f_url": "http://food2fork.com/view/32219",
        //       "title": "Terrific Turkey Chili",
        //       "source_url": "http://allrecipes.com/Recipe/Terrific-Turkey-Chili/Detail.aspx",
        //       "recipe_id": "32219",
        //       "image_url": "http://static.food2fork.com/121406cb64.jpg",
        //       "social_rank": 99.9999979241772, "publisher_url": "http://allrecipes.com"},
        //       {"publisher": "Epicurious", "f2f_url": "http://food2fork.com/view/f00677", "title": "Zucchini and Corn Tacos", "source_url": "http://www.epicurious.com/recipes/food/views/Zucchini-and-Corn-Tacos-354249", "recipe_id": "f00677", "image_url": "http://static.food2fork.com/354249ce8a.jpg", "social_rank": 94.67769382505922, "publisher_url": "http://www.epicurious.com"}, {"publisher": "Bon Appetit", "f2f_url": "http://food2fork.com/view/50866", "title": "Chile-Corn Custard Squares", "source_url": "http://www.bonappetit.com/recipes/2009/06/chile_corn_custard_squares", "recipe_id": "50866", "image_url": "http://static.food2fork.com/mare_chile_corn_custard_squares_h2875.jpg", "social_rank": 80.68285909795597, "publisher_url": "http://www.bonappetit.com"}, {"publisher": "Epicurious", "f2f_url": "http://food2fork.com/view/82e1d4", "title": "Poblano and Mushroom Tacos", "source_url": "http://www.epicurious.com/recipes/food/views/Poblano-and-Mushroom-Tacos-355771", "recipe_id": "82e1d4", "image_url": "http://static.food2fork.com/355771787f.jpg", "social_rank": 68.83505220772952, "publisher_url": "http://www.epicurious.com"}, {"publisher": "Serious Eats", "f2f_url": "http://food2fork.com/view/31cc43", "title": "Dinner Tonight: Healthy and Delicious Braised Greens Tacos", "source_url": "http://www.seriouseats.com/recipes/2008/02/dinner-tonight-braised-greens-tacos.html", "recipe_id": "31cc43", "image_url": "http://static.food2fork.com/20080212dinnertonightgreentacose0a8.jpg", "social_rank": 59.04395893403631, "publisher_url": "http://www.seriouseats.com/"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/32824", "title": "Tofu Tacos I", "source_url": "http://allrecipes.com/Recipe/Tofu-Tacos-I/Detail.aspx", "recipe_id": "32824", "image_url": "http://static.food2fork.com/1507723181.jpg", "social_rank": 50.519601929460855, "publisher_url": "http://allrecipes.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/18026", "title": "Jollyrogers' Chilaquiles", "source_url": "http://allrecipes.com/Recipe/Jollyrogers-Chilaquiles/Detail.aspx", "recipe_id": "18026", "image_url": "http://static.food2fork.com/17676440c0.jpg", "social_rank": 46.95571929015768, "publisher_url": "http://allrecipes.com"}, {"publisher": "Epicurious", "f2f_url": "http://food2fork.com/view/6ede49", "title": "Chile-Corn Custard Squares", "source_url": "http://www.epicurious.com/recipes/food/views/Chile-Corn-Custard-Squares-353419", "recipe_id": "6ede49", "image_url": "http://static.food2fork.com/epicuriousfacebook511b.png", "social_rank": 40.376436045748875, "publisher_url": "http://www.epicurious.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/5fd95e", "title": "Vegetarian Black Bean Enchiladas", "source_url": "http://allrecipes.com/Recipe/Vegetarian-Black-Bean-Enchiladas/Detail.aspx", "recipe_id": "5fd95e", "image_url": "http://static.food2fork.com/10051870820.jpg", "social_rank": 39.0058682084061, "publisher_url": "http://allrecipes.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/8b6a37", "title": "Cinco de Mayo Casserole", "source_url": "http://allrecipes.com/Recipe/Cinco-De-Mayo-Casserole/Detail.aspx", "recipe_id": "8b6a37", "image_url": "http://static.food2fork.com/100498334dc.jpg", "social_rank": 36.53277389525525, "publisher_url": "http://allrecipes.com"}, {"publisher": "Bon Appetit", "f2f_url": "http://food2fork.com/view/50577", "title": "Poblano and Mushroom Tacos", "source_url": "http://www.bonappetit.com/recipes/quick-recipes/2009/11/poblano_and_mushroom_tacos", "recipe_id": "50577", "image_url": "http://static.food2fork.com/mare_poblano_and_mushroom_tacos_ve546.jpg", "social_rank": 35.565927843371426, "publisher_url": "http://www.bonappetit.com"}, {"publisher": "All Recipes", "f2f_url": "http://food2fork.com/view/2315", "title": "Bacon, Avocado and Cheese Omelet", "source_url": "http://allrecipes.com/Recipe/Bacon-Avocado-And-Cheese-Omelet/Detail.aspx", "recipe_id": "2315", "image_url": "http://static.food2fork.com/98591627d3.jpg", "social_rank": 35.18691939406289, "publisher_url": "http://allrecipes.com"}, {"publisher": "Cookstr", "f2f_url": "http://food2fork.com/view/45280", "title": "Beef and Bean Burritos", "source_url": "http://www.cookstr.com/recipes/beef-and-bean-burritos", "recipe_id": "45280", "image_url": "http://static.food2fork.com/recipe22592c91f.jpg", "social_rank": 34.80777735743579, "publisher_url": "http://www.cookstr.com"}]};
        //
        //
        // return reply(fakeData);




        // console.log(request.query.pic);

        // var send = 'iVBORw0KGgoAAAANSUhEUgAAAKAAAAB4CAIAAAD6wG44AAAAA3NCSVQICAjb4U/gAAADHUlEQVR4nO3dsU4UURSH8XPOXtm1NXaUJEbtTAx08CTGxtgY6HgReANewMpY+QAUaOsL8A4EhnssUBKFDHPj7GT3z/cr4e7ZgY8ZILMz64vFwobZ398fuPLG8fFx03rmL2N+ND0Ga4fA4ggsjsDiCCyOwOIILI7A4ggsjsDiCCyOwOIILI7A4nxvb2/g0sxsG+3etJ75y5hftre3Bz5A4/zoY5vPIVocgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcWV8/PzgUs3NzebRg+fzPzlzXeuD9aezyFaHIHFEVjcaIHdurQwM297adj/Sgvzzqym10mfeE2MFvgqNtyqp9VpDwpPame5kVailkmfeE2MVqNUc6tdROSke9LVrKZZya4Ge/A9RvupT+8sY5bdi7Mf4WZm78usacKr72dN63/Pz2KeaYuT7oI/Ke4a8bAW6TVqvP7T6WVpHH7WFviv+RknHXXvwTdFHIHFEVgcgcURWByBxRFYnB8eHg5c2n/+Mt3MatT49nQ+wna1yvj88UP/Eo3zu63z2YPFEVgcgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcX51tbWwKU7Ozs9n709H/zp65cRtqtVxrvnz/qX9G//Xaenp03rV3P+aFf43wZu2ogRPfiFrOYV+MuezyFaHIHFEVgcgcURWByBxRFYHIHFEVgcgcWNdo+OaqXkpZlVi7BurLEPiszO52HVM7hV1l2jBd6oF9ce6THLmj7dgeEqbJadW61RJ74H21oYrUQXkVZK1pz2sF9qeFoXhdtk3Wu0PdizuHXXXn6+fXPzkalOt9W0mV9fpocZkf/lu7u7Q5dKvGHyY5tfhu83q3mBM/P75/NvkjgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsDgCi+MNosXn+3w+9P7dBwcHTU9wdHTUtJ75y5hfWl8nMNzyJjN/+Hx+B4sjsDgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsLgy/CrV1bz+lfn989mDxRFYHIHFEVgcgcURWNwvL209KjxuvWMAAAAASUVORK5CYII=;                                                                                              nO3dsU4UURSH8XPOXtm1NXaUJEbtTAx08CTGxtgY6HgReANewMpY+QAUaOsL8A4EhnssUBKFDHPj                                                                                              7GT3z/cr4e7ZgY8ZILMz64vFwobZ398fuPLG8fFx03rmL2N+ND0Ga4fA4ggsjsDiCCyOwOIILI7A                                                                                              4ggsjsDiCCyOwOIILI7A4nxvb2/g0sxsG+3etJ75y5hftre3Bz5A4/zoY5vPIVocgcURWByBxRFY                                                                                              HIHFEVgcgcURWByBxRFYHIHFEVgcgcWV8/PzgUs3NzebRg+fzPzlzXeuD9aezyFaHIHFEVjcaIHd                                                                                              urQwM297adj/Sgvzzqym10mfeE2MFvgqNtyqp9VpDwpPame5kVailkmfeE2MVqNUc6tdROSke9LV                                                                                              rKZZya4Ge/A9RvupT+8sY5bdi7Mf4WZm78usacKr72dN63/Pz2KeaYuT7oI/Ke4a8bAW6TVqvP7T                                                                                              6WVpHH7WFviv+RknHXXvwTdFHIHFEVgcgcURWByBxRFYnB8eHg5c2n/+Mt3MatT49nQ+wna1yvj8                                                                                              8UP/Eo3zu63z2YPFEVgcgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcX51tbWwKU7Ozs9                                                                                              n709H/zp65cRtqtVxrvnz/qX9G//Xaenp03rV3P+aFf43wZu2ogRPfiFrOYV+MuezyFaHIHFEVgc                                                                                              gcURWByBxRFYHIHFEVgcgcWNdo+OaqXkpZlVi7BurLEPiszO52HVM7hV1l2jBd6oF9ce6THLmj7d                                                                                              geEqbJadW61RJ74H21oYrUQXkVZK1pz2sF9qeFoXhdtk3Wu0PdizuHXXXn6+fXPzkalOt9W0mV9f                                                                                              pocZkf/lu7u7Q5dKvGHyY5tfhu83q3mBM/P75/NvkjgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4                                                                                              AosjsDgCi+MNosXn+3w+9P7dBwcHTU9wdHTUtJ75y5hfWl8nMNzyJjN/+Hx+B4sjsDgCiyOwOAKL                                                                                              I7A4AosjsDgCiyOwOAKLI7A4AosjsLgy/CrV1bz+lfn989mDxRFYHIHFEVgcgcURWNwvL209Kjxu                                                                                              vWMAAAAASUVORK5CYII=';

        // var data = {
        //   base64 : 'iVBORw0KGgoAAAANSUhEUgAAAKAAAAB4CAIAAAD6wG44AAAAA3NCSVQICAjb4U/gAAADHUlEQVR4nO3dsU4UURSH8XPOXtm1NXaUJEbtTAx08CTGxtgY6HgReANewMpY+QAUaOsL8A4EhnssUBKFDHPj7GT3z/cr4e7ZgY8ZILMz64vFwobZ398fuPLG8fFx03rmL2N+ND0Ga4fA4ggsjsDiCCyOwOIILI7A4ggsjsDiCCyOwOIILI7A4nxvb2/g0sxsG+3etJ75y5hftre3Bz5A4/zoY5vPIVocgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcWV8/PzgUs3NzebRg+fzPzlzXeuD9aezyFaHIHFEVjcaIHdurQwM297adj/Sgvzzqym10mfeE2MFvgqNtyqp9VpDwpPame5kVailkmfeE2MVqNUc6tdROSke9LVrKZZya4Ge/A9RvupT+8sY5bdi7Mf4WZm78usacKr72dN63/Pz2KeaYuT7oI/Ke4a8bAW6TVqvP7T6WVpHH7WFviv+RknHXXvwTdFHIHFEVgcgcURWByBxRFYnB8eHg5c2n/+Mt3MatT49nQ+wna1yvj88UP/Eo3zu63z2YPFEVgcgcURWByBxRFYHIHFEVgcgcURWByBxRFYHIHFEVgcgcX51tbWwKU7Ozs9n709H/zp65cRtqtVxrvnz/qX9G//Xaenp03rV3P+aFf43wZu2ogRPfiFrOYV+MuezyFaHIHFEVgcgcURWByBxRFYHIHFEVgcgcWNdo+OaqXkpZlVi7BurLEPiszO52HVM7hV1l2jBd6oF9ce6THLmj7dgeEqbJadW61RJ74H21oYrUQXkVZK1pz2sF9qeFoXhdtk3Wu0PdizuHXXXn6+fXPzkalOt9W0mV9fpocZkf/lu7u7Q5dKvGHyY5tfhu83q3mBM/P75/NvkjgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsDgCi+MNosXn+3w+9P7dBwcHTU9wdHTUtJ75y5hfWl8nMNzyJjN/+Hx+B4sjsDgCiyOwOAKLI7A4AosjsDgCiyOwOAKLI7A4AosjsLgy/CrV1bz+lfn989mDxRFYHIHFEVgcgcURWNwvL209KjxuvWMAAAAASUVORK5CYII='
        // };




        var data = {
          base64 : request.payload.pic
        };

        console.log("----------------------DATA----------------------------------");
        console.log(data);

      app.models.predict(Clarifai.FOOD_MODEL, data).then(
         function(response) {


          console.log("RETURNING");
          // console.log(response.outputs[0].data);

          var query = "";

          var concepts = response.outputs[0].data.concepts;

          console.error("looping " + concepts.length);
          var list = [];
          var length = concepts.length;
          for(var i = 0; i < length || i < 5; i++){
              // query = query +"+"+concets[i].name;
              // console.log("inside " + concepts[i].name);
              console.log(concepts[i].name);
              list.push(concepts[i].name);
          }

          console.log(list);

          console.error("WE ARE ALMOST DONE!! HAHA");
          //get the RECIPIE AND WE ARE DONE!!
          //CALLBACK HELL!
          getRecipe(list, reply);

          // return reply(query);


         },
         function(err) {
           // there was an error
           reply(err);
          //  console.log(send);
         }
       );
    }

});




// Start the server
server.start((err) => {

    if (err) {
        throw err;
    }
    console.log('Server running at:', server.info.uri);
});
