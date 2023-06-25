const http = require("http");
const express = require("express");
const soap = require("soap");
const { serviceObject, xml } = require("./services/webService");

const app = express();
const server = http.createServer(app);

soap.listen(server, "/wsdl", serviceObject, xml);

server.listen(3030, () => {
  console.log("Server listening on port 3030");
});
