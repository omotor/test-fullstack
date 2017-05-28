const gulp = require('gulp');

const minifyCss = require("gulp-minify-css");
const concat = require('gulp-concat');

gulp.task('minify-css-app', function () {
    gulp.src([
            '../css/*.css'])
        .pipe(minifyCss())
        .pipe(concat('app.min.css'))
        .pipe(gulp.dest('../dist/css'));
});

gulp.task('minify-css-vendors', function () {
    gulp.src([
            '../node_modules/bootstrap/dist/css/bootstrap.min.css',
            '../node_modules/ladda/dist/ladda-themeless.min.css',
            '../node_modules/angular-growl-v2/build/angular-growl.min.css'])
        .pipe(minifyCss())
        .pipe(concat('vendors.min.css'))
        .pipe(gulp.dest('../dist/css'));
});


gulp.task('minify-copyfonts', function() {
    gulp.src('../node_modules/bootstrap/dist/fonts/*.{ttf,woff,woff2,eof,svg,eot}')
        .pipe(gulp.dest('../dist/fonts'));
});

gulp.task('minify-css', ['minify-css-app', 'minify-css-vendors', 'minify-copyfonts'], function () {

});