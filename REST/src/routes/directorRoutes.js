const express = require("express");
const { check, validationResult } = require("express-validator");

const {
  getAllDirectors,
  getDirector,
  saveDirector,
  updateDirector,
  deleteDirector,
  getMovieWithDirector,
  getDirectorsForMovie,
  addDirectorToMovie,
  removeDirectorFromMovie,
} = require("../controller/directorController");

const router = express.Router();

// http://localhost:3005/api/directors
router.get("/directors", getAllDirectors);

// http://localhost:3005/api/director/id
router.get("/director/:id", getDirector);

// http://localhost:3005/api/director
/*
{
    "name": "Lee Chang-dong"
}
*/
router.post(
  "/director",
  [check("name").not().isEmpty().withMessage("Name is required")],
  saveDirector
);

// http://localhost:3005/api/director/id
/*
{
    "name": "Lee Chang-dong"
}
*/
router.put("/director/:id", updateDirector);

// http://localhost:3005/api/profile/id
router.delete(
  "/director/:id",
  [check("id").not().isEmpty().withMessage("Id is required")],
  deleteDirector
);

// http://localhost:3005/api/movies/:id/director
router.get("/movies/:id/director", getMovieWithDirector);

// http://localhost:3005/api/directors/:id/movies
router.get("/directors/:id/movies", getDirectorsForMovie);

// http://localhost:3005/api/movies/:id/directors
/*
{
    "director_id": 2
}
*/
router.post(
  "/movies/:id/directors",
  [check("director_id").not().isEmpty().withMessage("Director ID is required")],
  addDirectorToMovie
);

// http://localhost:3005/api/movies/:id/directors/:director_id
router.delete(
  "/movies/:id/directors/:director_id",
  [check("id").not().isEmpty().withMessage("Movie ID is required")],
  removeDirectorFromMovie
);

module.exports = {
  routes: router,
};
