/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entities.Book;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessionbeans.BookFacade;

/**
 *
 * @author QQ
 */
@WebService(serviceName = "BookWS")
@Stateless()
public class BookWS {

    @EJB
    private BookFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "all")
    public List<Book> all() {
        return ejbRef.all();
    }

    @WebMethod(operationName = "searchLike")
    public List<Book> searchLike(@WebParam(name = "title") String title) {
        return ejbRef.searchLike(title);
    }

    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "code") String code) {
        return ejbRef.delete(code);
    }

}
