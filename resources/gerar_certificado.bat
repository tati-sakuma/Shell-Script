@echo off
setlocal

:: Solicitar informações ao usuário
set /p DOMAIN="Digite o domínio ou IP para o certificado: "
set /p ORG="Digite o nome da organização: "
set /p CITY="Digite a cidade: "
set /p STATE="Digite o estado: "
set /p COUNTRY="Digite o país (código de 2 letras): "

:: Validar se os campos foram preenchidos
if "%DOMAIN%"=="" (
    echo O campo dominio/IP é obrigatório!
    exit /b
)
if "%ORG%"=="" (
    echo O campo organização é obrigatório!
    exit /b
)
if "%CITY%"=="" (
    echo O campo cidade é obrigatório!
    exit /b
)
if "%STATE%"=="" (
    echo O campo estado é obrigatório!
    exit /b
)
if "%COUNTRY%"=="" (
    echo O campo país é obrigatório!
    exit /b
)

:: Montar o valor do subject
set SUBJ=/C=%COUNTRY%/ST=%STATE%/L=%CITY%/O=%ORG%/CN=%DOMAIN%

:: Gerar o certificado usando OpenSSL
openssl req -x509 -nodes -days 365 -newkey rsa:2048 ^
  -keyout server.key -out server.crt ^
  -subj "%SUBJ%"

:: Mensagem de sucesso
if %ERRORLEVEL% equ 0 (
    echo Certificado gerado com sucesso!
) else (
    echo Falha ao gerar o certificado!
)

endlocal
