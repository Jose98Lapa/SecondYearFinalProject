REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ECAFETERIA_CP=ecafeteria.app.bootstrap\target\app.bootstrap-4.0.0.jar;ecafeteria.app.bootstrap\target\dependency\*;

REM call the java VM, e.g, 
java -cp %ECAFETERIA_CP% eapli.ecafeteria.app.bootstrap.ECafeteriaBootstrap -bootstrap:demo -smoke:basic
