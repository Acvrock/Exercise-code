/**
 * Created by moon on 8/17/16.
 */
console.log('Loading a web page');
var page = require('webpage').create();
var url = 'http://h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=22410887612&type=0&f=TB1M3TnLXXXXXXcXVXX8qtpFXlX';
page.open(url, function (status) {
    //Page is loaded!
    if (status !== 'success') {
        console.log('Unable to post!');
    } else {
        console.log(page.content);
    }
    phantom.exit();
});
