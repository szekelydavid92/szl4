@echo off 
pushd . 
cd C:\Users\BME\git\szl4Ultimate\szl4\Windows\ 
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_31 
set PATH=C:\Program Files\Abev 2006\krtitok;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Program Files (x86)\AMD APP\bin\x86_64;C:\Program Files (x86)\AMD APP\bin\x86;C:\Program Files\Common Files\Microsoft Shared\Windows Live;C:\Program Files (x86)\Common Files\Microsoft Shared\Windows Live;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Windows Live\Shared;C:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;C:\Program Files (x86)\Calibre2\;C:\Program Files\TortoiseSVN\bin;C:\Program Files (x86)\Java\jdk1.6.0_07\bin;C:\Program Files (x86)\Java\jre1.6.0_07;C:\VXIPNP\WinNT\Bin;C:\Program Files (x86)\AMD\ATI.ACE\Core-Static;C:\Program Files (x86)\Windows Kits\8.1\Windows Performance Toolkit\;C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;C:\Program Files (x86)\Microsoft SDKs\TypeScript\1.0\;C:\Program Files\Microsoft SQL Server\120\Tools\Binn\;C:\Program Files (x86)\Common Files\Propellerhead Software\ReWire\;C:\Program Files\Common Files\Propellerhead Software\ReWire\;C:\Users\BME\Documents\Mesters�ges intelligencia\pddl\lpg-win-binary\;C:\Program Files (x86)\Skype\Phone\;C:\Program Files\Java\jdk1.8.0_31\bin\ 
if exist ..\bin rd /s /q ..\bin 
mkdir ..\bin 
cd ..\src 
javac -d ..\bin bottom_layer\*.java common\*.java proto\*.java upper_layer\entity\*.java upper_layer\reactive\*.java upper_layer\wormhole\*.java upper_layer\*.java 
echo The compiled files are in the C:\Users\BME\git\szl4Ultimate\szl4\Windows\bin folder 
popd 
pause 
