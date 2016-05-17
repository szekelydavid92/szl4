@echo off
pushd .
cd %~dp0
cd ..
echo Give me the location of java jdk! (Usually: "C:\Program Files\Java\<jdkX.X.X_XX>")
set /p Location=

echo @echo off > WindowsFinal\Compile.bat
echo pushd . >> WindowsFinal\Compile.bat
echo cd %~dp0 >> WindowsFinal\Compile.bat
echo set JAVA_HOME=%Location% >> WindowsFinal\Compile.bat
echo set PATH=%PATH%;%Location%\bin\ >> WindowsFinal\Compile.bat
echo if exist ..\bin rd /s /q ..\bin >> WindowsFinal\Compile.bat
echo mkdir ..\bin >> WindowsFinal\Compile.bat
echo cd ..\src >> WindowsFinal\Compile.bat
echo javac -d ..\bin bottom_layer\*.java common\*.java proto\*.java view\*.java upper_layer\entity\*.java upper_layer\reactive\*.java upper_layer\wormhole\*.java upper_layer\*.java >> WindowsFinal\Compile.bat
echo echo The compiled files are in the %~dp0bin folder >> WindowsFinal\Compile.bat
echo popd >> WindowsFinal\Compile.bat
echo pause >> WindowsFinal\Compile.bat
echo Created the %~dp0Compile.bat file

echo @echo off > WindowsFinal\Run.bat
echo pushd . >> WindowsFinal\Run.bat
echo cd %~dp0 >> WindowsFinal\Run.bat
echo set JAVA_HOME=%Location% >> WindowsFinal\Run.bat
echo set PATH=%PATH%;%Location%\bin >> WindowsFinal\Run.bat
echo java -cp ..\bin view.ViewMain >> WindowsFinal\Run.bat
echo popd >> WindowsFinal\Run.bat
echo Created the %~dp0Run.bat file

popd
pause
