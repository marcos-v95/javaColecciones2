/*Empleando la clase HashMap()(con un String de clave y un entero largo de valor) implemente una agenda de teléfonos.
    HashMap<String, Long> agenda = new HashMap<String, Long>();
El algoritmo debe contener un menú inicial con 3 opciones
    1- Cargar Datos en la Agenda
    2- Buscar Teléfono por Nombre
    3- Listar Agenda
El usuario deberá elegir que desea hacer:
    1- Cargar Datos en la Agenda
        Debe solicitar el nombre completo de la persona y su respectivo teléfono, el nombre será usado como clave y el teléfono como valor del HashMap.
        Se deben poder solicitar todas las personas que se deseen hasta que se indique que no se quiere seguir cargando, cada vez que se ingrese una nueva persona se deberá validar si la clave ya existe (puede usar la función containsKey), si existe deberá informar de la situación al usuario, si no existe
        se agregara al HashMap. Al terminar la carga se debe mostrar el menú nuevamente.
    2- Buscar Teléfono por Nombre
        Se debe solicitar el nombre de la persona a buscar, si no se encuentra mostrar el mensaje “La persona buscada no se encuentra en la agenda”, caso contrario mostrar por pantalla el teléfono de la persona que se encontró en el HashMap. Al finalizar mostrar nuevamente el menú.
    3- Listar Agenda
        Recorrer la totalidad de elementos que posee el HashMap agenda, mostrando cada uno de los nombres y teléfonos que se encuentran almacenados. Al finalizar volver al menú.*/

import java.util.HashMap;
import java.util.Scanner;

public class AgendaTelefonica {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Creamos la agenda telefonica y la variable que contendra la opcion de menu elegida
        HashMap<String,Long> phoneBook = new HashMap<String, Long>();
        int optionMenu=0;
        // Implementacion del menu con un bucle do while, para repetirlo hasta ingresar 4 (salir)
        do {
            String menu = """
                Bienvenidos al menu de la Agenda Telefonica
                    1- Cargar Datos en la agenda
                    2- Buscar Teléfono por Nombre
                    3- Listar agenda
                    4- Salir de la agenda
                Seleccione una opcion del menú:""" ;

            System.out.println(menu);

            optionMenu=sc.nextInt();
            sc.nextLine(); //limpia el buffer de scanner

            switch (optionMenu){
                case 1: // Cargar datos en la agenda
                    String name;
                    long phoneNumber;
                    do{
                        System.out.println("Ingrese su nombre completo: ");
                        name= sc.nextLine();

                        if(phoneBook.containsKey(name)){ //retorna true si encuentra el valor de la key
                            System.out.println("El nombre ingresado ya existe en la agenda");
                        }else{
                            System.out.println("Ingrese su numero de telefono: ");
                            phoneNumber=sc.nextLong();
                            phoneBook.put(name,phoneNumber);// agregamos los valores como clave y valor a la agenda
                            System.out.println("Contacto agregado correctamente!");
                            sc.nextLine(); //limpiamos el buffer de scanner
                        }
                        System.out.println("Desea seguir cargando contactos? (s/n): ");
                    }while(sc.nextLine().equalsIgnoreCase("s")); //retorna true si encuentra el valor de la letra (minuscula o mayuscula)
                    break;
                case 2: // Buscar telefono por nombre
                    System.out.println("Ingrese el nombre del contacto que desea buscar en su agenda: ");
                    name=sc.nextLine();

                    if(phoneBook.containsKey(name)){
                        System.out.println("Numero de telefono de " + name + " es :" + phoneBook.get(name));
                    } else{
                        System.out.println("El contacto no se encuentra en su agenda");
                    }
                    break;
                case 3: // Listar contactos de la agenda
                    System.out.println("Contactos de la agenda: ");

                    for (String contact : phoneBook.keySet()) { //itera y el valor de la key del hasmap
                        Long phone = phoneBook.get(contact);
                        System.out.println();
                        System.out.println("Nombre: " + contact + " - Teléfono: " + phone);
                    }
                    break;
                case 4: // Salir de la agenda
                    System.out.println("Saliendo de la agenda, Gracias por utilizar nuestro programa!");
                    break;
                default:
                    System.out.println("Opción no válida. Porfavor, ingrese una opcion del menu");
                    break;
            }
        } while (optionMenu!=4);
        sc.close(); // cerramos scanner
    }
}