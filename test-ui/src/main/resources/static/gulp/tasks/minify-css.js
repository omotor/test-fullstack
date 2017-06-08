'use strict';

const gulp = require('gulp');
const concat = require('gulp-concat');
const minifyCss = require("gulp-minify-css");

var cssDestDir = '../dist/css';
var cssFiles= [
	'../css/*.css',
	'../node_modules/bootstrap/dist/css/bootstrap.min.css'
	];

gulp.task('minify-css', function() {
  return gulp.src(cssFiles)
    .pipe(minifyCss())
    .pipe(concat('min.css'))
    .pipe(gulp.dest(cssDestDir));
});