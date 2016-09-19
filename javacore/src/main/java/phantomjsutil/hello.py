#!/usr/bin/python
# -*- coding: UTF-8 -*-
from selenium import webdriver
driver = webdriver.PhantomJS(executable_path='phantomjs')
#executable_path为你的phantomjs可执行文件路径
driver.get("http://h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=22410887612&type=0&f=TB1M3TnLXXXXXXcXVXX8qtpFXlX/")

#或得js变量的值
r = driver.execute_script("return newsJason")
print r

#selenium在webdriver的DOM中使用选择器来查找元素，名字直接了当，by对象可使用的选择策略有：id,class_name,css_selector,link_text,name,tag_name,tag_name,xpath等等
print driver.find_element_by_tag_name("body").text
print driver.find_element_by_csss_selector("#content").text
print driver.find_element_by_id("content").text