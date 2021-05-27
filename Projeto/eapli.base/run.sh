#!/bin/sh
echo "Usage:"
echo "./run rebuild[y/n] module[user/bootstrap/backoffice]"
alias proj="cd /REPO/lei20_21_s4_2dl_1/Projeto/eapli.base"
if [ $1 = "y" ]
then
echo "REBUILDING . . . . . ."
proj
mvn clean dependency:copy-dependencies package
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