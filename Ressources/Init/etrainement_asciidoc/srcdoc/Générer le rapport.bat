@echo off
color 5E
echo. 
set /a num=0
:avant
set /a num=%num%+1
if exist ..\doc\rapportV%num%*.html echo rapport existant && goto :avant
cd srcdoc
python ..\..\..\..\tools\asciidoc869\asciidoc.py -a data-uri -o ..\doc\rapportV%num%_%DATE:~0,2%.%DATE:~3,2%.%DATE:~6,4%_%time:~0,2%h%time:~3,2%.html doc.adoc
pause
