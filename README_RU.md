# Jaspersoft Studio (Community Edition)

### Сборка проекта.
инструкции от Jaspersoft Studio 
https://community.jaspersoft.com/documentation/tibco-jaspersoft-studio-source-build-guide/v630/tibco-jaspersoft-studio-source-build
https://community.jaspersoft.com/wiki/contributing-tibco-jaspersoft-studio-and-building-sources

Для сборки необходимы следующие компоненты (взяты https://github.com/TIBCOSoftware/jaspersoft-studio-ce/releases):
##### 1. Source code (этот проект)
##### 2. jasperreports-eclipse-plugin-6.15.0_ce.zip - дополнительные для сборки библиотеки , распакованы в локацию исходников:
- net.sf.jasperreports
- net.sf.jasperreports.doc
- net.sf.jasperreports.feature
- net.sf.jasperreports.samples
- net.sf.jasperreports.samples.feature
##### 3. targetrepo-417-6.15.0.zip (размещен как lfs файл к проекту) , распаковать и указать путь к этой папке в maven settings.xml , пример:
<!-- Local Repository with the target platform for building -->
<targetplatform.repo>/d:/dev/targetRepoE417</targetplatform.repo>
##### 4. папка с jre.packages.location с тремя jre для сборки , путь к папке указывается в maven settings.xml , (размещены в ./jre/ как lfs файлы):
<!-- JRE files location -->
<jre.packages.location>d:\\dev\\jre</jre.packages.location>
jre были взяты-вырезаны из дистрибутивов :
- TIB_js-studiocomm_6.15.0_linux_x86_64.tgz
- TIB_js-studiocomm_6.15.0_macosx_x86_64.dmg
- TIB_js-studiocomm_6.15.0_windows_x86_64.zip
для сборки jre должны быть запакованы в .tar.gz с именами :
- jre-11.0.8-linux-x64.tar.gz
- jre-11.0.8-macosx-x64.tar.gz
- jre-11.0.8-windows-x64.tar.gz

##### перед вызовом команды сборки необходимо в net.sf.jasperreports необходимо скопировать зависимости, вызвать  две команды из директории \net.sf.jasperreports:
```mvn -f pom-jrl.xml  dependency:copy-dependencies```
```mvn -f pom-jrl-spring.xml  dependency:copy-dependencies```

##### сборка осуществляется командой mvn clean package  в локации проекта из папки aggregator, пример:
```mvn clean package -s C:\Users\user\.m2\settingsExample.xml```
settingsExample.xml приложен к проекту


