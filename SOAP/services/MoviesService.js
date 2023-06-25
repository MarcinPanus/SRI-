const Movie = require("../models/Movie");

let movies = [];

let MoviesService = {

  AddMovie: (args) => {
    let newMovie = new Movie(args.id, args.title, args.director);
    movies.push(newMovie);
    return { result: `Movie with id: ${args.id} added` };
  },

  GetMovie: (args) => {
    let movie = movies.find((item) => item.id === args.id);
    if (!movie) {
      throw new Error(`No movie found with id: ${args.id}`);
    }
    return movie;
  },

  UpdateMovie: (args) => {
    let movie = movies.find((item) => item.id === args.id);
    if (!movie) {
      throw new Error(`No movie found with id: ${args.id}`);
    }
    movie.update(args);
    return { result: `Movie with id: ${args.id} updated` };
  },

  DeleteMovie: (args) => {
    let initialLength = movies.length;
    movies = movies.filter((item) => item.id !== args.id);
    if (movies.length === initialLength) {
      throw new Error(`No movie found with id: ${args.id}`);
    } else {
      return { result: `Movie with id: ${args.id} deleted` };
    }
  },
  
  ListMovies: () => {
    return movies;
  },
};

module.exports = MoviesService;
