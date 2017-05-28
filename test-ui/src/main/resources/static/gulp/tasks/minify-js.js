const gulp = require('gulp');

const uglify = require("gulp-uglify");
const concat = require('gulp-concat');

gulp.task('minify-js-dev', function () {
    gulp.src([
            '../app/app.js',
            '../app/*.js',
            '../app/configuration/*.js',
            '../app/interceptors/*.js',
            '../app/directives/*.js',
            '../app/services/*.js',
            '../app/controllers/*.js'])
        .pipe(concat('app.min.js'))
        .pipe(gulp.dest('../dist'));
});

gulp.task('minify-js', function () {
    gulp.src([
            '../app/app.js',
            '../app/*.js',
            '../app/configuration/*.js',
            '../app/interceptors/*.js',
            '../app/directives/*.js',
            '../app/services/*.js',
            '../app/controllers/*.js'])
        .pipe(uglify())
        .pipe(concat('app.min.js'))
        .pipe(gulp.dest('../dist'));
});
