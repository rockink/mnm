'use strict';

const Hapi = require('hapi');

// Create a server with a host and port
const server = new Hapi.Server();

var Clarifai = require('clarifai');


server.connection({
    host: 'localhost',
    port: 8010
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

        console.log(req);

      app.models.predict(Clarifai.GENERAL_MODEL, {base64: request.query.base64}).then(
         function(response) {
           // do something with response
           reply(response);
         },
         function(err) {
           // there was an error
           console.log(err);
           reply(err);
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
