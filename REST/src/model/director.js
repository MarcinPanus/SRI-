const { Model, DataTypes } = require("sequelize");
const sequelize = require("./dbconfig");
const Movie = require("./movie");

class Director extends Model {}

Director.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
    },
    name: {
      type: DataTypes.STRING,
    },
  },
  {
    sequelize,
    modelName: "director",
    timestamps: false,
  }
);

Director.hasMany(Movie, { foreignKey: "director_id" });
Movie.belongsTo(Director, { foreignKey: "director_id" });

module.exports = Director;
