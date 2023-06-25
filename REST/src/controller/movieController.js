const Movie = require("../model/movie");
const { validationResult } = require("express-validator");

const getAllMovies = async (req, res) => {
  const movies = await Movie.findAndCountAll();
  const movieLinks = movies.rows.map((movie) => {
    return {
      ...movie.dataValues,
      links: [
        {
          self: `${req.protocol}://${req.get("host")}/api/movie/${movie.id}`,
        },
      ],
    };
  });
  res.send({
    context: movieLinks,
    total: movies.count,
  });
};

const getMovie = async (req, res) => {
  const id = req.params.id;
  await Movie.findOne({ where: { id: id } }).then((item) => {
    if (item != null) {
      res.send({
        context: item,
        links: [
          {
            self: `${req.protocol}://${req.get("host")}/api/movie/${id}`,
          },
        ],
      });
    } else {
      res.sendStatus(404);
    }
  });
};

const saveMovie = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }
  const movie = {
    title: req.body.title,
    genre: req.body.genre,
    year: req.body.year,
  };
  await Movie.create(movie).then(() => {
    res.status(201).send("New movie added to database");
  });
};

const updateMovie = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }

  const id = req.params.id;
  await Movie.findByPk(id).then((item) => {
    if (item != null) {
      item
        .update({
          title: req.body.title,
          genre: req.body.genre,
          year: req.body.year,
        })
        .then(() => {
          res.status(201).send("Successfully updated movie");
        });
    } else {
      res.sendStatus(404);
    }
  });
};

const deleteMovie = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }
  const id = req.params.id;
  await Movie.findByPk(id).then((item) => {
    if (item != null) {
      item.destroy();
      res.status(200).send("Movie removed from database");
    } else {
      res.sendStatus(404);
    }
  });
};

module.exports = {
  getAllMovies,
  getMovie,
  saveMovie,
  updateMovie,
  deleteMovie,
};
