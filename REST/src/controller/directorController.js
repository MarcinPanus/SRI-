const Director = require("../model/director");
const Movie = require("../model/movie");
const { validationResult } = require("express-validator");

const getAllDirectors = async (req, res) => {
  const directors = await Director.findAndCountAll();
  const directorLinks = directors.rows.map((director) => {
    return {
      ...director.dataValues,
      links: [
        {
          self: `${req.protocol}://${req.get("host")}/api/director/${
            director.id
          }`,
        },
        {
          related: `${req.protocol}://${req.get("host")}/api/directors/${
            director.id
          }/movies`,
        },
      ],
    };
  });
  res.send({
    context: directorLinks,
    total: directors.count,
  });
};

const getDirector = async (req, res) => {
  const id = req.params.id;
  await Director.findOne({ where: { id: id } }).then((item) => {
    if (item != null) {
      res.send({
        context: item,
        links: [
          {
            self: `${req.protocol}://${req.get("host")}${req.originalUrl}`,
          },

          {
            related: `${req.protocol}://${req.get(
              "host"
            )}/api/directors/${id}/movies`,
          },
        ],
      });
    } else {
      res.sendStatus(404);
    }
  });
};

const saveDirector = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }
  const director = {
    name: req.body.name,
  };
  await Director.create(director).then(() => {
    res.status(201).send("New director added to database");
  });
};

const updateDirector = async (req, res) => {
  const id = req.params.id;
  await Director.findByPk(id).then((item) => {
    if (item != null) {
      item
        .update({
          name: req.body.name,
        })
        .then(() => {
          res.status(201).send("Successfully updated director");
        });
    } else {
      res.sendStatus(404);
    }
  });
};

const deleteDirector = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }

  const id = req.params.id;
  await Director.findByPk(id).then((item) => {
    if (item != null) {
      item.destroy();
      res.status(200).send("Director removed from database");
    } else {
      res.sendStatus(404);
    }
  });
};

const getMovieWithDirector = async (req, res) => {
  const id = req.params.id;
  await Movie.findOne({ where: { id: id }, include: [Director] }).then(
    (item) => {
      if (item != null) {
        const response = {
          ...item.toJSON(),
          links: [
            {
              self: `${req.protocol}://${req.get(
                "host"
              )}/api/movies/${id}/director`,
            },
            {
              related: `${req.protocol}://${req.get("host")}/api/movies/${id}`,
            },
          ],
        };
        res.send(response);
      } else {
        res.sendStatus(404);
      }
    }
  );
};

const getDirectorsForMovie = async (req, res) => {
  const id = req.params.id;
  await Movie.findOne({ where: { id: id } }).then((item) => {
    if (item != null) {
      item.getDirector().then((director) => {
        res.send({
          context: director,
          links: [
            {
              self: `${req.protocol}://${req.get("host")}${req.originalUrl}`,
            },
            {
              related: `${req.protocol}://${req.get("host")}/api/director/${
                director.id
              }`,
            },
          ],
        });
      });
    } else {
      res.sendStatus(404);
    }
  });
};

const addDirectorToMovie = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }
  const movieId = req.params.id;
  const directorId = req.body.director_id;
  await Movie.findByPk(movieId).then((item) => {
    if (item != null) {
      item
        .update({
          director_id: directorId,
        })
        .then(() => {
          res.status(201).send("Successfully added director to movie");
        });
    } else {
      res.sendStatus(404);
    }
  });
};

const removeDirectorFromMovie = async (req, res) => {
  const errors = validationResult(req);
  if (!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
  }
  const movieId = req.params.id;
  await Movie.findByPk(movieId).then((item) => {
    if (item != null) {
      item
        .update({
          director_id: null,
        })
        .then(() => {
          res.status(200).send("Successfully removed director from movie");
        });
    } else {
      res.sendStatus(404);
    }
  });
};

module.exports = {
  getAllDirectors,
  getDirector,
  saveDirector,
  updateDirector,
  deleteDirector,
  getMovieWithDirector,
  getDirectorsForMovie,
  addDirectorToMovie,
  removeDirectorFromMovie,
};
