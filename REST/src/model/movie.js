const { Model, DataTypes } = require("sequelize");
const sequelize = require("./dbconfig");

class Movie extends Model {}

Movie.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
    },
    title: {
      type: DataTypes.STRING,
    },
    genre: {
      type: DataTypes.STRING,
    },
    year: {
      type: DataTypes.INTEGER,
    },
  },
  {
    sequelize,
    modelName: "movie",
    timestamps: false,
  }
);

module.exports = Movie;
