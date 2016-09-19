/**
 * Created by moon on 8/17/16.
 */
var webpage = require('webpage'), page = webpage.create();
var fs = require('fs');
page.viewportSize = { width: 624, height: 800 };
page.clipRect = { top: 0, left: 0, width: 1024, height: 800 };
page.settings = {
    javascriptEnabled: true,
    loadImages: true,
    webSecurityEnabled: false,
    userAgent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36'
    //要指定谷歌ua,我用火狐无法浏览
};
var lastReceived = new Date().getTime();
var requestCount = 0;
var responseCount = 0;
var requestIds = [];
var startTime = new Date().getTime();

page.onLoadStarted = function () {
    page.startTime = new Date();
};//获取页面开始加载的时间



page.open('http://h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=22410887612&type=0&f=TB1M3TnLXXXXXXcXVXX8qtpFXlX', function () {
    console.log('start');
    if (status === 'fail') {
        console.log('open page fail!');
    } else {
        waitFor(function () {
            return page.evaluate(function () {
                //判断页面加载完成的信号,
                return $(".des-alimg").length > 0;
            });
        }, function () {
            console.log('加载无比!');

            //页面加载完成后我们的DOM操作,
            //引入外部js库
            // page.includeJs("http://xxxx/jquery-1.9.1.min.js", function () {
            //     page.evaluate(function () { //操作页面事件
            //         console.log("jQuery version:" + jQuery.fn.jquery);
            //         $("a", ".goods-list-items").each(function () {
            //             console.log($(this).attr("href"));
            //         });
            //     });
            //     setTimeout(function () {
            //         page.render('../snapshot/taoba2o.png');
            //     }, 2000);
            //     //console.log()
            //     var t = Date.now() - page.startTime; //页面加载完成后的当前时间减去页面开始加载的时间，为整个页面加载时间
            //     console.log('firstLoadPage time :' + t + 'ms');
            //     console.log("end");
            //     setTimeout(function () {
            //         page.close();
            //         phantom.exit();
            //     }, 0);
            // });
        });
    }
});

function screan(filename) {
    page.render(filename);
}


function waitFor(testFx, onReady, timeOutMillis) {
    var maxtimeOutMillis = timeOutMillis ? timeOutMillis : 50000, //< Default Max Timout is 3s
        start = new Date().getTime(),
        condition = false,
        interval = setInterval(function () {
            if ((new Date().getTime() - start < maxtimeOutMillis) && !condition) {
                // If not time-out yet and condition not yet fulfilled
                screan('../snapshot/taobao.png');
                condition = (typeof (testFx) === "string" ? eval(testFx) : testFx()); //< defensive code
                console.log(page.content);
                // scrollToBottom(
                //     function () {
                //             //判断页面加载完成的信号,
                //              console.log('滚动');}
                // );
            } else {
                if (!condition) {
                    // If condition still not fulfilled (timeout but condition is 'false')
                    console.log("'waitFor()' timeout");
                    phantom.exit(1);
                } else {
                    // Condition fulfilled (timeout and/or condition is 'true')
                    console.log("'waitFor()' finished in " + (new Date().getTime() - start) + "ms.");
                    typeof (onReady) === "string" ? eval(onReady) : onReady(); //< Do what it's supposed to do once the condition is fulfilled
                    clearInterval(interval); //< Stop this interval
                }
            }
        }, 250); //< repeat check every 250ms
};

page.onCallback = function (data) {
    console.log('CALLBACK: ' + JSON.stringify(data));
    // Prints 'CALLBACK: { "hello": "world" }'
};


page.onAlert = function (msg) {
    console.log('ALERT: ' + msg);
};

page.onConsoleMessage = function (msg, lineNum, sourceId) {
    console.log('CONSOLE:' + msg);
    //var d = "http://h5.m.taobao.com/awp/core/detail.htm?id=43064483679";
    var re = new RegExp("[/?id=]+[0-9]{11}");
    var arr = (msg.match(re));
    //if (arr != null) {
    //    console.log(msg.match(re)[0].replace("?id=", ""));
    //}
};


page.onError = function (msg, trace) {
    var msgStack = ['ERROR: ' + msg];
    if (trace && trace.length) {
        msgStack.push('TRACE:');
        trace.forEach(function (t) {
            msgStack.push(' -> ' + t.file + ': ' + t.line + (t.function ? ' (in function "' + t.function + '")' : ''));
        });
    }

    console.error(msgStack.join('\n'));

};

// function scrollToBottom (callback) {
//
//     var TIMES = 10  // 最多滚动10次，防止无限加载
//         , INTERVAL = 600  // 每次滚动之间的间隔时间，太短有可能不会触发懒加载事件
//         , delta = 1500    // 每次的滚动距离，太长有可能导致之间有的部分未加载
//         , preScrollTop = 0  // 滚动前的 window.scrollTop 值
//         , curScrollTOp = 0;  // 滚动后的 window.scrollTop 值
//
//     var scroll = function () {
//         preScrollTop = $(window).scrollTop();
//         TIMES --;
//         $(window).scrollTop(preScrollTop + delta);
//     };
//
//     scroll();
//
//     var timer = setInterval(function () {
//
//         curScrollTOp = $(window).scrollTop();
//
//         if (TIMES <= 0 || (curScrollTOp - preScrollTop) <= 3 ) {
//             // 滚动结束
//             clearInterval(timer);
//             return callback();
//         }
//
//         scroll();
//
//     }, INTERVAL);
//
// }
