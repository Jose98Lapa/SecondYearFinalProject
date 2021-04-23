#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export ECAFETERIA_CP=ecafeteria.app.backoffice.console/target/app.backoffice.console-4.0.0.jar:ecafeteria.app.backoffice.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $ECAFETERIA_CP eapli.ecafeteria.app.backoffice.console.ECafeteriaBackoffice
