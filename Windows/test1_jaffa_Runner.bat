@echo off
pushd .
cd C:\Users\BME\Documents\Szoftlab 4\batch_file\szl4\Windows\
cd ..
java -cp bin proto.ProtoMain < testInput\test1_jaffa
java -cp bin proto.ProtoMain < testInput\test1_jaffa > output\testOut1_jaffa
echo 1_jaffa | java -cp bin proto.TestOutput
popd
