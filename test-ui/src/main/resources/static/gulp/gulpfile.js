const gulp = require('gulp');
const requireDir = require('require-dir');
const concat = require('gulp-concat');  
const rename = require('gulp-rename');  
const uglify = require('gulp-uglify');  
const cleanCSS = require('gulp-clean-css');

requireDir('./tasks');

gulp.task('default', ['scripts','minify-css'], function () {
	
});

var jsFiles = 'app/**/*.js',  
jsDest = 'dist/scripts';

gulp.task('scripts', function() {  
    return gulp.src(jsFiles)
        .pipe(concat('scripts.js'))
        .pipe(rename({
            suffix: ".min"
          }))
        .pipe(uglify())
        .pipe(gulp.dest(jsDest));
});

var cssFiles= 'app/css/*.css',
cssDest = 'dist/css';

gulp.task('minify-css', function() {
  return gulp.src(cssFiles)
    .pipe(cleanCSS({compatibility: 'ie8'}))
    .pipe(rename({
            suffix: ".min"
          }))
    .pipe(gulp.dest(cssDest));
});