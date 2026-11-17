# Secure Vault

Proyecto final de Lenguajes y Paradigmas de Programación: baúl digital de secretos en consola (Java).

## Estructura

```
SecureVault/
├── vault/
│   ├── Secreto.java        (clase abstracta)
│   ├── Credencial.java
│   ├── NotaTexto.java
│   ├── Cifrable.java       (interfaz)
│   ├── CifradorXor.java
│   ├── Hasheador.java
│   ├── GestorBoveda.java
│   └── Main.java
└── vault_data/             (la crea la aplicación al ejecutarse)
```

## Requisitos

- JDK 17 o superior (`javac -version`)

## Compilación y ejecución

Desde la carpeta `SecureVault/`:

```
javac -encoding UTF-8 vault/*.java
java vault.Main
```
