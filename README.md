#This ReadME covers the installation process of Java Fx on Eclipse 2020 
#Java Fx Installation Steps on Eclipse 2020:
1. Download latest Eclipse version for Java developers at https://www.eclipse.org/downloads/packages/
2. Download JavaFx Plugin from  help -> Eclipse Marketplace _> type in FX and download the e(fx) plugin and restart Eclipse
3. Download latest Java FX version from https://gluonhq.com/products/javafx/ 
4. Extract file to whichever folder space you want
5. Right click on eclipse board, then click on New, then click on Other, then select Java FX Project, name your empty new FX project.
6. Go to Preferences setting on Eclipse (can be accessed by typing in Help Search Bar or Apple logo if you use a MacBook)
7. While in the Preference setting, click on User Libraries under the Build Path section.
8. Click on New in User Libraries and create and name your own User Library, JavaFX
9. Then click onAdd External Jars, where you open and add the contents of the lib folder of that Java Fx Jdk download from Step 3 into your user library. Apply and Close
10. Then Right Click on Your Java FX Project,  go to Build Path, then go to Configure Build Path, go to Libraries, then click on Class Path, click on add library, click on User Library, and check the name of the Java library you created in step 7.
11. Then go to Run -> Run configurations, click on arguments, and type add --module-path “user/javafxjdk(downloadname)/lib” --add-modules javafx.controls,javafx.fxml
12. Run should work!
