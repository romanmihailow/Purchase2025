import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domaine.PurchaseItem;
import ru.netology.repository.ProductRepository;
import static org.mockito.Mockito.*;

public class ProductManagerTest {

//    ProductRepository repo = new ProductRepository();
ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);
    PurchaseItem item1 = new PurchaseItem(11, 1, "Хлеб", 40, 10);
    PurchaseItem item2 = new PurchaseItem(12, 10, "Булка", 7, 81);
    PurchaseItem item3 = new PurchaseItem(13, 111, "Кортошка", 15, 8);
    PurchaseItem item4 = new PurchaseItem(14, 12, "Хлеб", 33, 7);

//    @BeforeEach
//    public void setup(){
//        manager.add(item1);
//        manager.add(item2);
//        manager.add(item3);
//        manager.add(item4);
//    }

    @Test
    public void shouldReverseAllItems() {
        PurchaseItem[] expected = new PurchaseItem[] {item4, item3, item2, item1};
        PurchaseItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSum() {
        PurchaseItem[] items = {item1, item2, item3, item4};
        doReturn(items).when(repo).getItems();



        int expected = 1318;
        int actual = manager.getTotal();
        Assertions.assertEquals(expected, actual);
    }
}
