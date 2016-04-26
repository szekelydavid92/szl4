@echo off
pushd .
cd %~dp0
cd ..
echo Give me the location of java jdk! (Usually: "C:\Program Files\Java\<jdkX.X.X_XX>")
set /p Location=





echo @echo off > Windows\Compiler.bat
echo pushd . >> Windows\Compiler.bat
echo cd %~dp0 >> Windows\Compiler.bat
echo set JAVA_HOME=%Location% >> Windows\Compiler.bat
echo set PATH=%PATH%;%Location%\bin\ >> Windows\Compiler.bat
echo if exist ..\bin rd /s /q ..\bin >> Windows\Compiler.bat
echo mkdir ..\bin >> Windows\Compiler.bat
echo cd ..\src >> Windows\Compiler.bat
echo javac -d ..\bin bottom_layer\*.java common\*.java proto\*.java upper_layer\entity\*.java upper_layer\reactive\*.java upper_layer\wormhole\*.java upper_layer\*.java >> Windows\Compiler.bat
echo echo The compiled files are in the %~dp0bin folder >> Windows\Compiler.bat
echo popd >> Windows\Compiler.bat
echo pause >> Windows\Compiler.bat
echo Created the %~dp0Compiler.bat file





echo @echo off > Windows\Runner.bat
echo pushd . >> Windows\Runner.bat
echo cd %~dp0 >> Windows\Runner.bat
echo set JAVA_HOME=%Location% >> Windows\Runner.bat
echo set PATH=%PATH%;%Location%\bin >> Windows\Runner.bat
echo java -cp ..\bin proto.ProtoMain >> Windows\Runner.bat
echo popd >> Windows\Runner.bat
echo Created the %~dp0Runner.bat file





echo @echo off > Windows\RunnerAll.bat
echo pushd . >> Windows\RunnerAll.bat
echo cd %~dp0 >> Windows\RunnerAll.bat
echo cd .. >> Windows\RunnerAll.bat
echo set JAVA_HOME=%Location% >> Windows\RunnerAll.bat
echo set PATH=%PATH%;%Location%\bin >> Windows\RunnerAll.bat
cd testInput
for %%a in (*) do (
	echo %%a > %%a.txt
	(
		echo echo.
		echo echo.
		echo echo.
		echo echo.
		echo echo %%a
		echo echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		echo java -cp bin proto.ProtoMain ^< testInput\%%a ^> output\%%a
		echo java -cp bin proto.ProtoMain ^< testInput\%%a
		echo java -cp bin proto.TestOutput ^< %%a.txt
	) >> ..\Windows\RunnerAll.bat
)
cd ..
echo popd >> Windows\RunnerAll.bat
echo Created the %~dp0RunnerAll.bat file





cd testInput
for %%a in (*) do (
	echo %%a > %%a.txt
	(
		echo @echo off
		echo pushd .
		echo cd %~dp0
		echo cd ..
		echo java -cp bin proto.ProtoMain ^< testInput\%%a ^> output\%%a
		echo java -cp bin proto.ProtoMain ^< testInput\%%a
		echo java -cp bin proto.TestOutput ^< %%a.txt
		echo popd
	) > ..\Windows\%%a_Runner.bat
)
cd ..
echo Created the %~dp0^<teszteset neve^>_Runner.bat files





popd
pause