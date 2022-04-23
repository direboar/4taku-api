FROM openjdk:11

WORKDIR /app

RUN apt update \
    && apt install -y bash \
    && apt install -y curl \
    && curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/ \
    && curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio 


RUN  useradd --shell /bin/bash -u 1024 -o -c "" -m myuser
RUN mkdir -p /shared/tmp && chown myuser. /shared/ -R
USER myuser
# 以降のCOPY、RUN、CMDはmyuserで実施される。

# permissionを指定してCOPYする。
COPY --chmod=777 ./code-with-quarkus/ /app/code-with-quarkus/
WORKDIR /app/code-with-quarkus
RUN ./mvnw install
    
CMD ./mvnw quarkus:dev
