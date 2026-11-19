# Secure Vault

Proyecto final de Lenguajes y Paradigmas de Programación: baúl digital de secretos en consola (Java).

## Estructura

```
SECURE-VAULT/
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

Desde la carpeta `SECURE-VAULT/`:

```
javac -encoding UTF-8 vault/*.java
java vault.Main
```

## Diagrama de clases

> Los métodos de `GestorBoveda` son una propuesta y siguen en discusión hasta que el equipo cierre las firmas.
> El código fuente del diagrama está en [`docs/diagrama-clases.mmd`](docs/diagrama-clases.mmd) y hay una versión en imagen en [`docs/diagrama-clases.png`](docs/diagrama-clases.png).

```mermaid
classDiagram
    direction TB

    class Secreto {
        <<abstract>>
        -String id
        -String nombre
        -String hashNombre
        -String contenidoCifrado
        +getId() String
        +getNombre() String
        +getHashNombre() String
        +getContenidoCifrado() String
        +setNombre(String) void  «final»
        +setHashNombre(String) void  «final»
        +setContenidoCifrado(String) void  «final»
        +mostrarDetalle(String contenidoPlano)* void
    }

    class Credencial {
        -String usuario
        -String servicio
        +mostrarDetalle(String contenidoPlano) void
    }

    class NotaTexto {
        -String categoria
        +mostrarDetalle(String contenidoPlano) void
    }

    class Cifrable {
        <<interface>>
        +cifrar(String textoPlano, String claveMaestra) String
        +descifrar(String textoCifradoBase64, String claveMaestra) String
    }

    class CifradorXor {
        +cifrar(String textoPlano, String claveMaestra) String
        +descifrar(String textoCifradoBase64, String claveMaestra) String
    }

    class Hasheador {
        <<utilidad>>
        -Hasheador()
        +hasheador(String palabraClave)$ String
    }

    class Tipo {
        <<enumeration>>
        CREDENCIAL
        NOTA
    }

    class GestorBoveda {
        -Cifrable cifrador
        +crearBoveda(String clave) void
        +login(String clave) boolean
        +cambiarClave(String nueva) void
        +crear(Secreto s, String contenidoPlano) void
        +leer(String id) Secreto
        +modificar(String id, ...) void
        +eliminar(String id) void
        +listar() List~Secreto~
        +buscar(String nombre) List~Secreto~
        +buscar(Tipo tipo) List~Secreto~
    }

    class Main {
        +main(String[] args)$ void
    }

    Secreto <|-- Credencial
    Secreto <|-- NotaTexto
    Cifrable <|.. CifradorXor
    GestorBoveda --> Cifrable : usa
    GestorBoveda ..> Hasheador : usa
    GestorBoveda --> Secreto : administra
    GestorBoveda *-- Tipo : define
    Main --> GestorBoveda : usa
```
