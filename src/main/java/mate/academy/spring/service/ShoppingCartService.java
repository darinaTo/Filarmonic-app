package mate.academy.spring.service;

import mate.academy.spring.model.ConcertSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;

public interface ShoppingCartService {
    void addSession(ConcertSession concertSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
