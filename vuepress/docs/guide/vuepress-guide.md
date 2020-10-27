# vuepress 文档管理

## 下载项目
```shell
git@github.com:ctlHub/mall.git
```

## 切换分支
切换到分支 vuepress
```shell
git checkout vuepress
```

## 环境安装

进入文件夹 vuepress，打开控制台，查看是否安装 node

```shell
node -v
```

没安装的话，官网下载安装 [https://nodejs.org/en/](https://nodejs.org/en/)

安装完成之后安装 yarn

```shell
npm install -g yarn
```

在 vuepress 目录下运行命令

```shell
yarn install
```

安装完成后，多出 node_modules 文件夹

## 文档目录

``` lua
├─.vuepress
│  ├─dist
│  │  ├─assets
│  │  │  ├─css
│  │  │  ├─img
│  │  │  └─js
│  │  ├─backend
│  │  ├─frontend
│  │  └─images
│  └─public
│      └─images
├─backend
└─frontend
```

- .vuepress 配置文件目录，不要动
- backend、fronend 文档目录，可以随便创建，**不能含中文名**，文档下面创建 md 文档，文件名不能包含中文名，标题会读取 md 文档中的第一个 ```# 标题```，每个文档最好只有一个一级标题

## 本地预览

在 vuepress 目录下运行命令，开启本地预览

```shell
npm run dev
```

## 提交

- **项目提交：**

  在 **vuepress 分支**下进行提交，不要合并到主分支

  ```shell
  git add .
  git commit -m "xxxx"
  git push origin vuepress
  ```

- **文档提交**

  在 vuepress 目录下，命令行输入

  ```shell
  sh deploy.sh
  ```
  
  文档内容提交在 **doucment 分支**，不要合并

**vuepress 分支 **存放原 md 文件，**document 分支** 存放生成的 html 文件，两个分支不要合并。

## 地址

https://ctlhub.github.io/mall/

## 主页配置

/vuepress/docs/README.md

```markdown
---
home: true
heroImage: /images/mall-logo.png
heroText: ctlHub-Mall
tagline: 书以启智,技于谋生,活出斜杠
actionText: 开始阅读 →
features:
  - title: 读书
    details: 随笔川迹,文以载道,虚心学习,自省自知,多读一页书,就少一分无知,多一分智慧
  - title: 技术
    details: 用心记录技术,走心分享,始于前端,不止于前端,励志成为一名优秀的全栈工程师,真正的实现码中致富
  - title: 生活
    details: 无分享,不生活,一个具有情怀的技匠,路上正追逐斜杠青年的践行者
footer: MIT Licensed | Copyright © 2020-present chlHub
---
```