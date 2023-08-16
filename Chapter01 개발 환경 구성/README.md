# 개발 환경 구성

## 1. JDK 설치 및 JAVA_HOME 환경 변수 설정
- JDK 다운로드
https://www.oracle.com/kr/java/technologies/javase/javase8-archive-downloads.html
설치 경로: C:\java

- JAVA_HOME 환경 변수 설정
[내 PC] - [속성] - [고급 시스템 설정] - [고급] - [환경 변수]
'PC에 대한 사용자 변수' 항목 - [새로 만들기] - JAVA_HOME 등록, 환경 변수 JAVA_HOME의 값: JDK 설치 경로 폴더 지정
'시스템 변수' 항목에 사용할 경우 - %JAVA_HOME%\bin을 맨 앞에 추가
<br>

## 2. Maven 설치
- 다운로드
https://maven.apache.org/download.cgi
https://maven.apache.org/install.html

설치 경로: C:\devtool\apache-maven-3.9.4
'PC에 대한 사용자 변수' 항목 - PATH항목 - mavn 설치 경로\bin 추가하기
<br>
## 3. Gradle 설치
- 다운로드
https://gradle.org/next-steps/?version=4.4&format=bin

설치 경로: C:\devtool\gradle-4.4
'PC에 대한 사용자 변수' 항목 - PATH항목 - gradle설치 경로\bin 추가하기
<br>
## 4. Eclipse IDE 설치 
- 다운 로드
https://www.eclipse.org/downloads/packages/release/2021-03/r

설치 경로: C:\devtool\eclipse