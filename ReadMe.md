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
2. docker build -f src/main/docker/Dockerfile.jvm -t quarkus/code-with-quarkus-jvm
3. docker run -i --rm -p 8080:8080 quarkus/code-with-quarkus-jvm
##### 補足 host上で　api/src/main/docker-compose.yamlでAPIが動くことは確認済み。