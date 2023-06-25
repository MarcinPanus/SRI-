const express = require("express");
const sequelize = require("./model/dbconfig");
const movieRoutes = require("./routes/movieRoutes");
const directorRoutes = require("./routes/directorRoutes");

(async () => {
  await sequelize.sync({ force: true });
})();

const app = express();
app.use(express.json());

app.use("/api", movieRoutes.routes, directorRoutes.routes);

const PORT = process.env.PORT || 3005;
app.listen(PORT, () => {
  console.log(`Service endpoint = http://localhost:${PORT}`);
});
