var gulp = require('gulp');
var concat = require('gulp-concat');

var uglify = require('gulp-uglify');


var path = '../app/js/';
gulp.task('scripts', function() {
  gulp.src([
  	path+'*.js'  	
  	])
    .pipe(concat('main.min.js'))
    .pipe(uglify())
    .pipe(gulp.dest(path+'./dist/'))
});

var path = '../app/css/';
gulp.task('scripts', function() {
  gulp.src([
  	path+'*.css'  	
  	])
    .pipe(concat('style.min.css'))
    .pipe(uglify())
    .pipe(gulp.dest(path+'./dist/'))
});

gulp.task('default', ['scripts']);