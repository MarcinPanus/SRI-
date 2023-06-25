class Movie {
  constructor(id, title, director) {
    this.id = id;
    this.title = title;
    this.director = director;
  }

  update(data) {
    this.title = data.title || this.title;
    this.director = data.director || this.director;
  }
}

module.exports = Movie;
