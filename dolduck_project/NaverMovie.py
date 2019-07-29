# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import urllib.request

resp = urllib.request.urlopen('https://movie.naver.com/movie/running/current.nhn')
# print(resp)
soup = BeautifulSoup(resp, 'html.parser')
# print(soup)

movieList = soup.findAll('dl',{'class','lst_dsc'})
# print(movieList)

for movieOne in movieList:
    link = movieOne.find('a')
    num = movieOne.select('.num')[0]
    print('%s %s'%(link.text, num.text))

# 사진 링크
moviemovie = soup.findAll('div',{'class','thumb'})
for movieOne in moviemovie:
    pic = movieOne.find('a')
    for a in pic:
        print('%s'%(a.get('src')))