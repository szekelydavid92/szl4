@echo off
echo Give me the location of java jdk! (Usually: "C:\Program Files\Java\<jdkX.X.X_XX>")
set /p Location=
set JAVA_HOME=%Location%
set PATH=%PATH%;%Location%\bin\
cd ..




if exist bin rd /s /q bin
mkdir bin
cd src
javac -d ..\bin bottom_layer\*.java common\*.java proto\*.java upper_layer\entity\*.java upper_layer\reactive\*.java upper_layer\wormhole\*.java upper_layer\*.java
cd ..
echo The compiled files are in the root\bin folder




echo @echo off > Windows\Futtato.bat
echo set JAVA_HOME=%Location% >> Windows\Futtato.bat
echo set PATH=%PATH%;%Location%\bin >> Windows\Futtato.bat
echo java -cp bin proto.ProtoMain >> Windows\Futtato.bat
echo Created the root\Windows\Futtato.bat file




echo @echo off > Windows\FuttatoOsszes.bat
echo set JAVA_HOME=%Location% >> Windows\FuttatoOsszes.bat
echo set PATH=%PATH%;%Location%\bin >> Windows\FuttatoOsszes.bat

for %%a in (testInput\*) do (
	(
		echo echo.
		echo echo.
		echo echo.
		echo echo.
		echo echo %%a
		echo echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		echo java -cp bin proto.ProtoMain ^< %%a
	) >> Windows\FuttatoOsszes.bat
)
echo Created the root\Windows\FuttatoOsszes.bat file
pause
