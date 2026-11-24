# Secure Vault

Programa de consola en Java para guardar contraseñas y notas protegidas con una clave maestra.
Proyecto final de Lenguajes y Paradigmas de Programación.

## Qué va a hacer

- La primera vez pide crear una clave maestra; las siguientes, pide escribirla.
- Guarda dos tipos de secretos: **credenciales** (servicio, usuario y contraseña) y **notas** (categoría y texto).
- Desde un menú se puede crear, ver, modificar, eliminar y buscar secretos, y cambiar la clave maestra.
- Todo se guarda en la carpeta `vault_data/`: los secretos cifrados y la clave maestra como hash (SHA-256).

## Cómo va

- **Listo:** `Secreto`, `Credencial`, `NotaTexto`, `Hasheador` y el menú de `Main`.
- **Falta:** `GestorBoveda`, el cifrado de `CifradorXor` y conectar el menú (por ahora cada opción dice «Pendiente»).

## Archivos

| Archivo | Para qué sirve |
|---|---|
| `Secreto.java` | Molde general de un secreto (clase abstracta). |
| `Credencial.java` | Secreto con servicio y usuario. |
| `NotaTexto.java` | Secreto con categoría. |
| `Cifrable.java` | Interfaz: cifrar y descifrar. |
| `CifradorXor.java` | Cifrado XOR con la clave maestra. |
| `Hasheador.java` | Saca el hash SHA-256 de un texto. |
| `GestorBoveda.java` | Guarda, busca y administra los secretos. |
| `Main.java` | Arranque y menú. |

Todos están en `vault/`.

## Cómo correrlo

Necesitas Java 17 o más nuevo. Desde la carpeta `SECURE-VAULT/`:

```
javac -encoding UTF-8 vault/*.java
java vault.Main
```

## Diagrama de clases

![Diagrama de clases](docs/diagrama-clases.png)

Los métodos de `GestorBoveda` todavía pueden cambiar. El código del diagrama está en [`docs/diagrama-clases.mmd`](docs/diagrama-clases.mmd).
