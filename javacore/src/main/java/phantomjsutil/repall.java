package phantomjsutil;

/**
 * Created by moon on 8/17/16.
 *
 * @Description:
 */
public class repall {

    public static void main(String[] args) {
       String page =  "\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\"/>\n" +
                "    <title>电脑版图文详情</title>\n" +
                "    <meta content=\"yes\" name=\"apple-mobile-web-app-capable\" />\n" +
                "    <meta content=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />\n" +
                "    <meta name=\"format-detection\" content=\"telephone=no\" />\n" +
                "    <meta name=\"spm-id\" content=\"a2141\" />\n" +
                "    <script type=\"text/javascript\">\n" +
                "        window.onerror = function(e){\n" +
                "            console.error(e);\n" +
                "        }\n" +
                "        //页面加载时间打点\n" +
                "        window['detailLoadTime'] = Date.now();\n" +
                "        (function(){\n" +
                "            var params = location.search.slice(1).split('&');\n" +
                "            var hashs = location.hash.slice(2).split('&');\n" +
                "            params = params.concat(hashs);\n" +
                "            var tmParam = {};\n" +
                "            var tmKey;\n" +
                "            for(var i=0,len=params.length;i<len;i++){\n" +
                "                tmKey = params[i].split('=');\n" +
                "                tmParam[tmKey[0]] = tmKey[1];\n" +
                "            }\n" +
                "            var descType = tmParam.type || 0;\n" +
                "            var userId = tmParam.buyerId;\n" +
                "            userId = userId ? String(userId) : null;\n" +
                "            if(descType && descType == 1){\n" +
                "                document.write('<meta name=\"viewport\" content=\"width=750,maximum-scale=1,user-scalable=yes\" />');\n" +
                "            }\n" +
                "            else{\n" +
                "                dpr = 1;\n" +
                "                document.write('<meta content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\" name=\"viewport\" />')\n" +
                "            }\n" +
                "        })();\n" +
                "    </script>\n" +
                "    <link type=\"text/css\" rel=\"stylesheet\" href=\"./css/detail_new.css\" />\n" +
                "</head>\n" +
                "<body data-spm=\"7690265\" >\n" +
                "<div id=\"J_loading\" class=\"loading\"><div class=\"loading-icon\"></div></div>\n" +
                "<script src=\"//h5.m.taobao.com/app/lib/js/zepto.1.0.4.js\"></script>\n" +
                "<script src=\"//h5.m.taobao.com/app/detail/js/aplus_wap.js\"></script>\n" +
                "<script src=\"//h5.m.taobao.com/app/detail/js/combo.js\"></script>\n" +
                "<script src=\"./js/detail_new.js\"></script>\n" +
                "</body>\n" +
                "</html>\n";
        page =  page.replaceAll("\\./","//h5.m.taobao.com/app/detail/");
        page =  page.replaceAll("<\\/body>","<script></body>");
        System.out.println(page);
    }
}
