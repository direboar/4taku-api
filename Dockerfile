FROM openjdk:11
#Debian GNU/Linux 11 \n \l

WORKDIR /app

RUN apt update \
    && apt install -y bash \
    && apt install -y curl \
    && curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/ \
    && curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio 

#dockerをinstall
RUN apt-get update
RUN apt-get install docker.io -y 

#user追加
RUN useradd --shell /bin/bash -u 1000 -o -c "" -m myuser 
RUN mkdir -p /shared/tmp && chown myuser. /shared/ -R

#以下dondのための設定。
#dockerのグループにユーザを追加
RUN usermod -aG docker myuser
#dockerグループのgidをhost側のgroupidに変更
RUN groupmod -g 1001 docker

#以降のCOPY、RUN、CMDはmyuserで実施される。
USER myuser

#permissionを指定してCOPYする。
COPY --chmod=777 . .
#mvnwを解決できなくなってしまった。。一旦mvnwの実行をRUNで行わないようにする。
# COPY --chmod=777 . /app/
# WORKDIR /app/
# RUN ./mvnw install -Dmaven.test.skip
    
# CMD ./mvnw quarkus:dev
