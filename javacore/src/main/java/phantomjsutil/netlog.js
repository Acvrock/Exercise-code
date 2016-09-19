/**
 * Created by moon on 8/17/16.
 */
var page = require('webpage').create();
page.onResourceRequested = function (request) {
    console.log('Request ' + JSON.stringify(request, undefined, 4));
};
page.onResourceReceived = function (response) {
    console.log('Receive ' + JSON.stringify(response, undefined, 4));
};
page.open(url, function (status) {
    //Page is loaded!
    if (status !== 'success') {
        console.log('Unable to post!');
    } else {
        //console.log(page.content);
        //var title = page.evaluate(function() {
        //  return document.title;//示范下如何使用页面的jsapi去操作页面的  www.oicqzone.com
        //  });
        //console.log(title);
        page.render('example.png');
        console.log(page.content);
    }
    phantom.exit();
});