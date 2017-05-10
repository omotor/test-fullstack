const gulp = require('gulp');
const cleanCSS = require('gulp-clean-css');
const rename = require('gulp-rename');

gulp.task('minify-css', ['less'],function () {
    return gulp.src(['../css/*.css','!../css/*.min.css'])
            .pipe(cleanCSS({compatibility: 'ie8'}))
            .pipe(rename({
                suffix: '.min'
            }))
            .pipe(gulp.dest('../css'));
});