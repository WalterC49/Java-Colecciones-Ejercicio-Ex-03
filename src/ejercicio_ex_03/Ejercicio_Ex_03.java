/*
mplemente un programa para una Librería haciendo uso de un HashSet para evitar datos
repetidos. Para ello, se debe crear una clase llamada Libro que guarde la información de
cada uno de los libros de una Biblioteca. La clase Libro debe guardar el título del libro,
autor, número de ejemplares y número de ejemplares prestados. También se creará en
el main un HashSet de tipo Libro que guardará todos los libros creados.
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos sus
datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le
pregunta al usuario si quiere crear otro Libro o no.
La clase Librería contendrá además los siguientes métodos:
• Constructor por defecto.
• Constructor con parámetros.
• Métodos Setters/getters
• Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al método.
El método se incrementa de a uno, como un carrito de compras, el atributo
ejemplares prestados, del libro que ingresó el usuario. Esto sucederá cada vez que
se realice un préstamo del libro. No se podrán prestar libros de los que no queden
ejemplares disponibles para prestar. Devuelve true si se ha podido realizar la
operación y false en caso contrario.
• Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método. El
método decrementa de a uno, como un carrito de compras, el atributo ejemplares
prestados, del libro seleccionado por el usuario. Esto sucederá cada vez que se
produzca la devolución de un libro. No se podrán devolver libros donde que no
tengan ejemplares prestados. Devuelve true si se ha podido realizar la operación y
false en caso contrario.
• Método toString para mostrar los datos de los libros.
*/
package ejercicio_ex_03;

import Entidades.Libro;
import java.util.HashSet;

/**
 *
 * @author Walter
 */
public class Ejercicio_Ex_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Este programa guarda libros en un conjunto y los maneja con un menú.");
        HashSet<Libro> Libros = new HashSet();
        String titulo;
        String autor;
        Integer numEjem;
        Integer numEjemPrest;
        String respuesta;
        boolean continuar=false;
        
        do{
            System.out.print("\nIngrese el titulo de un libro: ");
            titulo=Libro.leer.nextLine();
            System.out.print("Ingrese a su autor: ");
            autor=Libro.leer.nextLine();
            System.out.print("Ingrese el Nº de ejemplares que posee: ");
            numEjem=Libro.leer.nextInt();
            System.out.print("Ingrese el Nº de ejemplares prestados: ");
            numEjemPrest=Libro.leer.nextInt();
            Libros.add(new Libro(titulo, autor, numEjem, numEjemPrest));
            do{
                System.out.print("\n¿Desea agregar otro libro?(s/n) ");
                respuesta = Libro.leer.next().toLowerCase();
                switch(respuesta){
                    case "s":
                        continuar=true;
                        break;
                    case "n":
                        continuar=false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
            }while(!(respuesta.equals("s")||respuesta.equals("n")));
            Libro.leer.nextLine();
        }while(continuar==true);
        System.out.println("-------------------------------------------------");
        int op;
        String buscar;
        do{
            System.out.println("\nMENÚ"
                    + "\n1- Prestar libro."
                    + "\n2- Devolver libro."
                    + "\n3- Mostrar libros."
                    + "\n4- Salir del programa.");
            System.out.print("Opción: ");
            op=Libro.leer.nextInt();
            Libro.leer.nextLine();
            boolean encontrado=false;
            switch(op){
                case 1:
                    System.out.print("\nIngrese el titulo del libro que quiere prestar: ");
                    buscar=Libro.leer.nextLine();
                    for (Libro i : Libros) {
                        if(i.getTitulo().equals(buscar)){
                            encontrado=true;
                            System.out.println((Libro.Prestamo(i))?"El libro se prestó":"No hay ejemplares para prestar.");
                        }
                    }
                    if(!encontrado){
                        System.out.println("Ese libro no existe.");
                    }
                    break;
                case 2:
                    System.out.print("\nIngrese el titulo del libro que quiere devolver: ");
                    buscar=Libro.leer.nextLine();
                    for (Libro i : Libros) {
                        if(i.getTitulo().equals(buscar)){
                            encontrado=true;
                            System.out.println((Libro.Devolucion(i))?"El libro se devolvió":"Ese libro no fue prestadó.");
                        }
                    }if(!encontrado){
                        System.out.println("Ese libro no existe.");
                    }
                    break;
                case 3:
                    Libro.MostrarLibros(Libros);
                    break;
                case 4:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        }while(op!=4);
    }
    
}
