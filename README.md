# code-with-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


### 開発環境
1. hello-quarkus\Dockerfileをdev-containerで開く
2. code-with-quarkusに移動
3. ./mvnw quarkus:dev
4. 実行とデバッグ→Attach to Remote Progmram

Windows上からlocalhost:8080でアクセス可能。

### postgresのportについて
1. portを固定すると、コード修正時に同じPortでpostgresが起動してしまいテストがエラーとなる。回避策としてportを指定しないようにしている。postgresのクライアントから接続する場合は、5432に固定すること。

### 起動方法まとめ
####　devモードでの起動方法（親プロジェクト上から）
1. ./mvnw quarkus:dev -pl api
2. ./mvnw quarkus:dev -pl batch

#### slim.jarでの実行方法
1. java -jar batch/target/quarkus-app/quarkus-run.jar
2. java -jar batch/target/quarkus-app/quarkus-run.jar update-hero
3. java -jar batch/target/quarkus-app/quarkus-run.jar get-minder-ranking

#### docker-image (see src/main/docker/Dockerfile.jvm)
1. ./mvnw clean package
2. ../mvnw clean package -Dquarkus.container-image.build=true (api)
3. docker run -i --rm -p 8080:8080 minokuba/4taku-api
4. ../mvnw clean package -Dquarkus.container-image.build=true (batch)
5. docker run -i --rm -p 8080:8080 minokuba/4taku-batch
##### 補足 host上で　api/src/main/docker-compose.yamlでAPIが動くことは確認済み。
