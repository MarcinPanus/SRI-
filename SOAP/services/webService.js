const soap = require("soap");
const MoviesService = require("./MoviesService");

let serviceObject = {
  MoviesService: {
    MoviesServiceSoapPort: MoviesService,
  },
};

let xml = require("fs").readFileSync("./service.wsdl", "utf8");

module.exports = { serviceObject, xml };
