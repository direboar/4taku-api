FROM openjdk:11

WORKDIR /app

COPY ./code-with-quarkus/ /app/code-with-quarkus/

RUN apt update \
    && apt install -y bash \
    && apt install -y curl \
    && curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/ \
    && curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio 

WORKDIR /app/code-with-quarkus
RUN ./mvnw install
    
CMD ./mvnw quarkus:dev
