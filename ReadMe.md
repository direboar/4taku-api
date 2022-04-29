### 開発環境
1. hello-quarkus\Dockerfileをdev-containerで開く
2. code-with-quarkusに移動
3. ./mvnw quarkus:dev
4. 実行とデバッグ→Attach to Remote Progmram

Windows上からlocalhost:8080でアクセス可能。

### postgresのportについて
1. portを固定すると、コード修正時に同じPortでpostgresが起動してしまいテストがエラーとなる。回避策としてportを指定しないようにしている。postgresのクライアントから接続する場合は、5432に固定すること。
