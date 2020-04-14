# nablarch-plugins-bundle-test

UI開発基盤のテストを行う際に使用するプロジェクトです。

## テスト環境構築の方法

1. [Maven](https://maven.apache.org/)と[node(v0.10.26)](https://nablarch.github.io/docs/LATEST/doc/development_tools/ui_dev/doc/development_environment/initial_setup.html#node-js)をインストールしておいてください。
1. nablarch-plugins-bundle-testと同じディレクトリに[nablarch-plugins-bundle](https://github.com/nablarch/nablarch-plugins-bundle)をcloneしてください。
    ```
    git clone https://github.com/nablarch/nablarch-plugins-bundle.git
    ```
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


