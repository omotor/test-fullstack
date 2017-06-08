'use strict';

const gulp = require('gulp');
const concat = require('gulp-concat');  
const uglify = require('gulp-uglify');  

var jsDest = '../dist/js';
gulp.task('minify-js-app-boot', function() {  
    return gulp.src('../app/app.js')
        .pipe(uglify())
        .pipe(concat('app.boot.min.js'))
        .pipe(gulp.dest(jsDest));
});


gulp.task('minify-js-app', function() {  
    return gulp.src(['../app/**/*.js', '!../app/app.js'])
        .pipe(uglify())
        .pipe(concat('app.min.js'))
        .pipe(gulp.dest(jsDest));
});


var jsVendorFiles = [  
	 '../node_modules/jquery/dist/jquery.min.js',
     '../node_modules/bootstrap/dist/js/bootstrap.min.js',
     '../node_modules/angular/angular.min.js',
     '../node_modules/angular-messages/angular-messages.min.js',
     '../node_modules/angular-ui-router/release/angular-ui-router.min.js',
 ];	

gulp.task('minify-js-vendors', function() {  
    return gulp.src(jsVendorFiles)
         .pipe(gulp.dest(jsDest));
});

gulp.task('minify-js', ['minify-js-app-boot','minify-js-app', 'minify-js-vendors'], function () {

});