const express = require("express");
const { check, validationResult } = require("express-validator");

const {
  getAllMovies,
  getMovie,
  saveMovie,
  updateMovie,
  deleteMovie,
} = require("../controller/movieController");

const router = express.Router();

// http://localhost:3005/api/movies
router.get("/movies", getAllMovies);

// http://localhost:3005/api/movie/id
router.get("/movie/:id", getMovie);

// http://localhost:3005/api/movie
/*
{
    "title": "Beoning",
    "genre": "thriller",
    "year": "2018"
}
*/
router.post(
  "/movie",
  [
    check("title").not().isEmpty().withMessage("Title is required"),
    check("genre").not().isEmpty().withMessage("Genre is required"),
    check("year").not().isEmpty().withMessage("Year is required"),
  ],
  saveMovie
);

// http://localhost:3005/api/movie/id
/*
{
    "title": "Burning"
}
*/
router.put("/movie/:id", updateMovie);

// http://localhost:3005/api/profile/id
router.delete(
  "/movie/:id",
  [check("id").isNumeric().withMessage("ID must be a number")],
  deleteMovie
);

module.exports = {
  routes: router,
};
