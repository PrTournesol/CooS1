rem echo off
set ASCIIDOCDIR=.\tools\asciidoc869\
set PLANTUMLDIR=.\tools\
set SPRINTDIR=%~dp0
set SRCDIR=.\src\
set BINDIR=.\bin\
set SRCDOCDIR=.\srcdoc\
set DOCDIR=.\doc\

set MAKETEST=1

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des executables
@echo ///////////////////////////////////////////////////////
javac -d %BINDIR% %SRCDIR%HelloMonde.java

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des documentations
@echo ///////////////////////////////////////////////////////
java -jar %PLANTUMLDIR%plantuml.jar -Tpng -o %SRCDOCDIR%images %SRCDOCDIR%diag0.puml
python %ASCIIDOCDIR%asciidoc.py -a data-uri -o %DOCDIR%doc.html %SRCDOCDIR%doc.adoc