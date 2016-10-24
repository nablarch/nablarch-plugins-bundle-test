# nablarch-plugins-bundle-test

UI開発基盤のテストを行う際に使用するプロジェクトです。

## テスト環境構築の方法

1. nablarch-plugins-bundleをチェックアウトしてください。
2. コマンドプロンプトを起動してください。
3. 環境変数http_proxyを設定し、nablarch_plugins_bundle/bin/setup.batを実行してください。
4. nablarch_plugins_bundle\node_modulesのジャンクションを、nablarch_ui_plugins_test/ui_plugins に作成してください。
  コマンド例は以下の通りです。
```
  mklink /j C:\nablarch\workspace\nablarch_plugins_bundle_test\ui_plugins\node_modules C:\nablarch\workspace\nablarch_plugins_bundle\node_modules
```
5. nablarch_plugins_bundle_test/ui_plugins/bin/ui_build.batを実行してください。
6. 手順5までを実施することで、以下のコマンドでテストが実行できる状態となります。
```
  nablarch_plugins_bundle_test\ui_test\サーバ動作確認.bat
  nablarch_plugins_bundle_test\ui_test\ローカル画面確認.bat
```
