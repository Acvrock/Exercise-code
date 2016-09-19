/**
 * Created by moon on 8/17/16.
 */
var page = require('webpage').create();
page.open('http://h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=22410887612&type=0&f=TB1M3TnLXXXXXXcXVXX8qtpFXlX', function() {
    page.render('github.png');
    phantom.exit();
});