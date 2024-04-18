#!/usr/bin/env bash

EXEC=`pwd`

cd ~/goinfre
curl -O https://download.java.net/java/GA/jdk13/5b8a42f3905b406298b72d750b6919f6/33/GPL/openjdk-13_osx-x64_bin.tar.gz
tar zxvf openjdk-13_osx-x64_bin.tar.gz
rm -rf openjdk-13_osx-x64_bin.tar.gz
if [ -z $(echo ${PATH} | grep -i "jdk-13.jdk/Contents/Home/bin") ]; then
	sed -i -e "/PATH/d" ${HOME}/.zshrc
	echo "PATH=${HOME}/goinfre/jdk-13.jdk/Contents/Home/bin:${PATH}" >> ${HOME}/.zshrc
	rm -f ~/.zshrc-e
fi

cd ${EXEC}