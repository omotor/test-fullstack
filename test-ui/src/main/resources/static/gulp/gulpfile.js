const gulp = require('gulp');
const requireDir = require('require-dir');

requireDir('./tasks');

gulp.task('default', ['minify-js', 'minify-css'], function () {

});