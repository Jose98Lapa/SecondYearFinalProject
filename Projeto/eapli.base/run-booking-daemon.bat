REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ECAFETERIA_CP=ecafeteria.daemon.booking\target\app.bootstrap-4.0.0.jar;ecafeteria.daemon.booking\target\dependency\*;

REM call the java VM, e.g, 
java -cp %ECAFETERIA_CP% eapli.ecafeteria.daemon.booking.ECafeteriaBookingDaemon -port:8899
