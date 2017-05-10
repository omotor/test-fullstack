const gulp = require('gulp');
const watch = require('gulp-watch');
const browserSync = require('browser-sync').create('MyServer');


var proxyMiddleware = require('http-proxy-middleware');
gulp.task('browser-sync',['watch','minify-css'], function () {
    var proxy = proxyMiddleware('/api', {target: 'http://localhost:5000'});
    
    
    browserSync.init({
        server: {
            baseDir: "../",
            middleware: proxy
        }
    });
    gulp.watch("../**/*.html").on('change', browserSync.reload);
    gulp.watch("../**/*.css").on('change', browserSync.reload);
    gulp.watch("../**/*.js").on('change', browserSync.reload);
});


gulp.task('watch', function () {
    gulp.watch('../less/**/*.less', ['minify-css']);
});