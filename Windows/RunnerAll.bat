@echo off 
pushd . 
cd C:\Users\BME\git\szl4Ultimate\szl4\Windows\ 
cd .. 
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_31 
set PATH=C:\Program Files\Abev 2006\krtitok;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Program Files (x86)\AMD APP\bin\x86_64;C:\Program Files (x86)\AMD APP\bin\x86;C:\Program Files\Common Files\Microsoft Shared\Windows Live;C:\Program Files (x86)\Common Files\Microsoft Shared\Windows Live;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Windows Live\Shared;C:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;C:\Program Files (x86)\Calibre2\;C:\Program Files\TortoiseSVN\bin;C:\Program Files (x86)\Java\jdk1.6.0_07\bin;C:\Program Files (x86)\Java\jre1.6.0_07;C:\VXIPNP\WinNT\Bin;C:\Program Files (x86)\AMD\ATI.ACE\Core-Static;C:\Program Files (x86)\Windows Kits\8.1\Windows Performance Toolkit\;C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;C:\Program Files (x86)\Microsoft SDKs\TypeScript\1.0\;C:\Program Files\Microsoft SQL Server\120\Tools\Binn\;C:\Program Files (x86)\Common Files\Propellerhead Software\ReWire\;C:\Program Files\Common Files\Propellerhead Software\ReWire\;C:\Users\BME\Documents\Mesters�ges intelligencia\pddl\lpg-win-binary\;C:\Program Files (x86)\Skype\Phone\;C:\Program Files\Java\jdk1.8.0_31\bin 
echo.
echo.
echo.
echo.
echo test10
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test10
echo.
echo.
echo.
echo.
echo test11
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test11
echo.
echo.
echo.
echo.
echo test1_jaffa
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test1_jaffa
echo.
echo.
echo.
echo.
echo test1_oneill
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test1_oneill
echo.
echo.
echo.
echo.
echo test2
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test2
echo.
echo.
echo.
echo.
echo test3
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test3
echo.
echo.
echo.
echo.
echo test4
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test4
echo.
echo.
echo.
echo.
echo test5
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test5
echo.
echo.
echo.
echo.
echo test6
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test6
echo.
echo.
echo.
echo.
echo test7
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test7
echo.
echo.
echo.
echo.
echo test8
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test8
echo.
echo.
echo.
echo.
echo test9
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test9
echo.
echo.
echo.
echo.
echo test9_rand
echo ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
java -cp bin proto.ProtoMain < testInput\test9_rand
popd 
