#!/bin/sh
echo "Usage:"
echo " [REBUILD(y/n)|pull|private] module[user/bootstrap/backoffice]"
alias proj="cd /REPO/lei20_21_s4_2dl_1/Projeto/eapli.base"
alias repo="cd /REPO/lei20_21_s4_2dl_1"
alias persistance="cd /REPO/lei20_21_s4_2dl_1/Projeto/eapli.base/base.persistence.impl/src/main/resources/META-INF"

if [ $1 = "y" ]
then
echo "REBUILDING . . . . . ."
proj
mvn clean dependency:copy-dependencies package
echo "Rebuilt"
fi

if [ $1 = "pull" ]
then
repo
echo "Pulling from repo"
git fetch --all
git reset --hard origin/master
proj
chmod +x run.sh
cp -p run.sh /
fi


if [ $1 = "private" ]
then
echo "Changing to local database ip . . . . . ."
persistance
sed -i 's/vsgate-s2.dei.isep.ipp.pt:10221/10.9.20.221:2225/' persistence.xml
echo "Rebuilt"
fi



case $2 in
    user )
proj
export BASE_CP=base.app.user.console/target/base.app.user.console-1.3.0-SNAPSHOT.jar:base.app.user.console/target/dependency/*;
java -cp $BASE_CP eapli.base.app.user.console.BaseUserApp
    ;;
    bootstrap )
proj
export BASE_CP=base.app.bootstrap/target/base.app.bootstrap-1.3.0-SNAPSHOT.jar:base.app.bootstrap/target/dependency/*;
java -cp $BASE_CP eapli.base.app.bootstrap.BaseBootstrap
    ;;
    backoffice)
proj
export BASE_CP=base.app.backoffice.console/target/base.app.backoffice.console-1.3.0-SNAPSHOT.jar:base.app.backoffice.console/target/dependency/*;
java -cp $BASE_CP eapli.base.app.backoffice.console.BaseBackoffice  
    ;;
esac
