package books;


import com.core.entity.book.model.Books;
import com.core.entity.book.services.BooksDTO;
import com.core.entity.book.services.BooksMapper;
import com.core.entity.exceptions.BuildException;

public class BooksTest {
    public static void main(String[]args) {
        //Correcte Llibre
        Books b;
        try{
            b=Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia", "Santillana", "987500505", 12.405, 34.56, 34.32, 12.45, true, 12.4);
            System.out.println(b.getDetails());

            //Mapper
            BooksDTO bdto = BooksMapper.dtoFromBook(b);
            System.out.println("Autor: " + bdto.getAuthor());

            Books bcopy =  BooksMapper.bookFromDTO(bdto);
            System.out.println("Mapper Book: " + bcopy.getDetails());
        }catch(BuildException e){
            System.out.println(e.toString());
            b=null;
        }

        //Incorrecte Llibre
        try{
            BooksDTO bdto = new BooksDTO(-12, -12, "a", "", "a", "a", -0, "a", "a", "", -12, -12, -12, -12,false, -34);
            Books bo = BooksMapper.bookFromDTO(bdto);
            System.out.println(bo.getDetails());
        }catch(BuildException e){
            System.out.println("Error del llibre: " + e.toString());
            b=null;
        }
    }
}
