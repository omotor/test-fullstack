const gulp = require('gulp');

const uglify = require("gulp-uglify");
const concat = require('gulp-concat');

gulp.task('minify-js-app-dev', function () {
    gulp.src([
            '../app/app.js',
            '../app/*.js',
            '../app/configuration/*.js',
            '../app/interceptors/*.js',
            '../app/directives/*.js',
            '../app/services/*.js',
            '../app/controllers/*.js'])
        .pipe(concat('app.min.js'))
        .pipe(gulp.dest('../dist/js'));
});

gulp.task('minify-js-app', function () {
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
        .pipe(gulp.dest('../dist/js'));
});

gulp.task('minify-js-vendors', function () {
        gulp.src([
                '../node_modules/jquery/dist/jquery.min.js',
                '../node_modules/bootstrap/dist/js/bootstrap.min.js',
                '../node_modules/angular/angular.min.js',
                '../node_modules/@uirouter/angularjs/release/angular-ui-router.min.js',
                '../node_modules/ladda/dist/spin.min.js',
                '../node_modules/ladda/dist/ladda.min.js',
                '../node_modules/angular-ladda/dist/angular-ladda.min.js',
                '../node_modules/angular-resource/angular-resource.min.js',
                '../node_modules/angular-input-masks/releases/angular-input-masks-standalone.min.js',
                '../node_modules/angular-br-filters/release/angular-br-filters.min.js',
                '../node_modules/angular-growl-v2/build/angular-growl.min.js'])
            .pipe(uglify())
            .pipe(concat('vendors.min.js'))
            .pipe(gulp.dest('../dist/js'));
});

gulp.task('minify-js', ['minify-js-app', 'minify-js-vendors'], function () {

});