const gulp = require('gulp');
const requireDir = require('require-dir');
const uglify = require('gulp-uglify');

requireDir('./tasks');

gulp.task('default', ['browser-sync', 'build-js', 'build-css'], function () {
});
	
gulp.task('build-js', function() {
    return gulp.src('../**/*.js')
    	.pipe(concat('minified.js'))
		.pipe(uglify())
		.pipe(gulp.dest('dist/js'));

gulp.task('minify-css', function() {
	return gulp.src('../**/*.css')
		.pipe(concat('all.css'))
		.pipe(uglify())
		.pipe(gulp.dest('dist/css'));
