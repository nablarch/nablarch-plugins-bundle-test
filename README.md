# nablarch-plugins-bundle-test

UI開発基盤のテストを行う際に使用するプロジェクトです。

## テスト環境構築の方法

## 資材のダウンロード
1. nablarch-plugins-bundle-testと同じディレクトリに[nablarch-plugins-bundle](https://github.com/nablarch/nablarch-plugins-bundle)をcloneしてください。
    ```
    git clone https://github.com/nablarch/nablarch-plugins-bundle.git
    ```

## Dockerを使用しない場合
### 手順
1. [Maven](https://maven.apache.org/)と[node(v0.10.26)](https://nablarch.github.io/docs/LATEST/doc/development_tools/ui_dev/doc/development_environment/initial_setup.html#node-js)をインストールしておいてください。
1. コマンドプロンプトを起動してください。
1. プロキシ環境下の場合は環境変数http_proxy、https_proxyを設定してください。
    ```
    set http_proxy=＜プロキシURL＞
    set https_proxy=＜プロキシURL＞
    ```
1. nablarch-plugins-bundle/bin/setup.batを実行してください。
    ```
    nablarch-plugins-bundle\bin\setup.bat
    ```
1. nablarch-plugins-bundle\node_modulesのジャンクションをnablarch-plugins-bundle-test\ui_pluginsに作成してください。
    ```
    mklink /j .\nablarch-plugins-bundle-test\ui_plugins\node_modules .\nablarch-plugins-bundle\node_modules
    ```
1. nablarch-plugins-bundle-test/ui_plugins/bin/ui_build.batを実行してください。
    ```
    nablarch-plugins-bundle-test\ui_plugins\bin\ui_build.bat
    ```
1. 以下のコマンドでテストが実行できる状態となります。
    1. サーバー動作確認
        ```
        nablarch-plugins-bundle-test\ui_test\サーバ動作確認.bat
        ```
        - ブラウザが開くので「デモ画面を開く」リンクを選択するとUI開発基盤の提供部品の動きを確認できます。
    1. ローカル画面確認
        ```
        nablarch-plugins-bundle-test\ui_test\ローカル画面確認.bat
        ```
        - ブラウザが開くので画面リンクを選択するとローカル画面表示を確認できます。

## Dockerを使用する場合
### Dockerを使用する利点
- Dockerを使用する場合開発PCに古いnodeをインストールする必要がありますが、それを避けることが出来ます。

### 環境
- WSL2 + Docker Desktop for Windows
- Proxyなし

### 手順
以下の手順はコマンドプロンプトから行なうことをお勧め済ます。  
(Git Bash の場合エラー出力されるコマンドがあるかもしれません)

1. Dockerイメージをビルドします。
    ```
    $ cd nablarch-plugins-bundle-test/docker/buid_and_run/
    $ docker build -t ui_dev_build_run .
    ```
2. Docker コンテナを使用して/nablarch/nablarch-plugins-bundle/bin/setup.shを実行してください。
    ```
     $ docker run --rm -v <クローンしたディレクトリ>/nablarch-plugins-bundle/:/nablarch-plugins-bundle ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle/bin; /nablarch-plugins-bundle/bin/setup.sh"
    ```
    パス指定の例：
    ```
    $ docker run --rm -v /c/Users/seko/git/github/nablarch/nablarch-plugins-bundle/:/nablarch-plugins-bundle ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle/bin; /nablarch-plugins-bundle/bin/setup.sh"
    ```
3. nablarch-plugins-bundle\node_modulesをnablarch-plugins-bundle-test\ui_pluginsにコピーしてください。  
   以下は注意事項です。
   - ジャンクションはDocker実行時にファイルを参照できないので不可です。
   - nablarch-plugins-bundleをビルドするたびにコピーしなおしてください。
4. nablarch-plugins-bundle-test/ui_plugins/bin/ui_build.shを実行してください。
    ```
     docker run --rm -v <クローンしたディレクトリ>/nablarch-plugins-bundle-test/:/nablarch-plugins-bundle-test ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle-test/ui_plugins/bin; /nablarch-plugins-bundle-test/ui_plugins/bin/ui_build.sh"
    ```
    パス指定の例：
    ```
     docker run --rm -v /c/Users/seko/git/github/nablarch/nablarch-plugins-bundle-test/:/nablarch-plugins-bundle-test ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle-test/ui_plugins/bin; /nablarch-plugins-bundle-test/ui_plugins/bin/ui_build.sh"
    ```
5. 以下のコマンドでテストが実行できる状態となります。
    1. 「サーバー動作確認」と「ローカル画面確認」個別に起動する場合
       1. サーバー動作確認
           ```
           docker run --rm -it -p 7777:7777 -v <クローンしたディレクトリ>/nablarch-plugins-bundle-test/:/nablarch-plugins-bundle-test ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle-test/ui_test; /nablarch-plugins-bundle-test/ui_test/uiTestServer.sh"
           ```
           パス指定の例：
           ```
           docker run --rm -it -p 7777:7777 -v /c/Users/seko/git/github/nablarch/nablarch-plugins-bundle-test/:/nablarch-plugins-bundle-test ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle-test/ui_test; /nablarch-plugins-bundle-test/ui_test/uiTestServer.sh"
           ```
           ブラウザを起動して `http://localhost:7777/tools/index.html` にアクセスし「デモ画面を開く」リンクを選択すると、UI開発基盤の動きを確認することができます。
       2. ローカル画面確認
           パス指定の例：
           ```
           docker run --rm -p 8888:8888 -v <クローンしたディレクトリ>/nablarch-plugins-bundle-test/:/nablarch-plugins-bundle-test ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle-test/ui_test; /nablarch-plugins-bundle-test/ui_test/localServer.sh"
           ```
           パス指定の例：
           ```
           docker run --rm -it -p 8888:8888 -v /c/Users/seko/git/github/nablarch/nablarch-plugins-bundle-test/:/nablarch-plugins-bundle-test ui_dev_build_run /bin/bash -c "cd /nablarch-plugins-bundle-test/ui_test; /nablarch-plugins-bundle-test/ui_test/localServer.sh"
           ```
           ブラウザを起動して `http://localhost:8888` にアクセスすることで、ローカル画面表示を確認できます。

       「サーバー動作確認」「ローカル画面確認」ともに、テスト終了後は `CTRL+C` でコンテナを停止してください。
