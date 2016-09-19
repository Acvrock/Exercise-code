/**
 * Created by moon on 8/17/16.
 */
var webpage = require('webpage').create();
webpage
    .open('http://h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=22410887612&type=0&f=TB1M3TnLXXXXXXcXVXX8qtpFXlX') // loads a page
    .then(function(){ // executed after loading
        // store a screenshot of the page
        webpage.viewportSize =
        { width:650, height:320 };
        webpage.render('page.png',
            {onlyViewport:true});
        // then open a second page
        return webpage.open('http://h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=22410887612&type=0&f=TB1M3TnLXXXXXXcXVXX8qtpFXlX');
    })
    .then(function(){
        // click somewhere on the second page
        webpage.sendEvent("click", 5, 5,
            'left', 0);
        slimer.exit()
    });