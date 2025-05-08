# <img src="images/file.png" width="40"> Lógica con Ficheros (Programación)

Recuerda aplicar la lógica a cada una de las funciones que se plantean, reflexionando sobre que se se pide, y en un contexto **NO INFORMÁTICO** lo resolverias.

## Ejercicio 1

Este programa en Java solicita al usuario el nombre de un fichero y verifica si existe. Define la función:

```java
boolean existeFichero(String nombreFichero)
```

## Ejercicio 2

Crea una función en Java que reciba **solo el nombre de un directorio** y devuelva `true` si el directorio existe, y `false` en caso contrario.  

```java
boolean existeDirectorio(String nombreDirectorio)
```

## Ejercicio 3

Implementa un método que permita insertar una nueva criatura en una lista. El método debe recibir un objeto Criatura y agregarlo a la lista.

```java
public boolean insertar(Criatura criatura);
```

## Ejercicio 4

Crea un método que elimine una criatura de la lista dado su identificador único (id).

```java
public boolean borrar(String id);
```

## Ejercicio 5

Implementa un método que devuelva todas las criaturas de la lista.

```java
public List<Criatura> obtenerCriaturas();
```

## Ejercicio 6

Crea un método que modifique los atributos de una criatura dada su identificación única (id).

```java
public void modificar(Criatura nuevaModificada);
```

## Ejercicio 7

Implementa un método que busque una criatura en la lista.

```java
public Criatura buscar(String id);
```

## Ejercicio 8

Crea un método que busque todas las criaturas que tengan un nombre específico.

```java
public List<Criatura> buscarPorNombre(String nombre);
```

## Ejercicio 9

Implementa un método que busque todas las criaturas que provengan de un origen específico.

```java
public List<Criatura> buscarPorOrigen(String origen);
```

## Ayuda en el ejercicio

```java
public static void create(String data,File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine(); // Añadir una nueva línea después del registro
            System.out.println("Registro agregado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        create("Juan, 25 años", archivo);
    }
```

```java
public static void read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        read(archivo);
    }
```

## Mucha Suerte

<img src="images/suerte.png">

</div>